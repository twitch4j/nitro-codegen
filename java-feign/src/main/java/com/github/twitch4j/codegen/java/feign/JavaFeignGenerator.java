package com.github.twitch4j.codegen.java.feign;

import io.swagger.v3.oas.annotations.tags.Tags;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.tags.Tag;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.openapitools.codegen.CliOption;
import org.openapitools.codegen.CodegenConfig;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenOperation;
import org.openapitools.codegen.CodegenParameter;
import org.openapitools.codegen.CodegenProperty;
import org.openapitools.codegen.CodegenType;
import org.openapitools.codegen.SupportingFile;
import org.openapitools.codegen.api.TemplateFileType;
import org.openapitools.codegen.languages.AbstractJavaCodegen;
import org.openapitools.codegen.utils.ModelUtils;

import java.util.*;
import java.util.regex.Pattern;

import static org.openapitools.codegen.utils.StringUtils.camelize;

@Slf4j
public class JavaFeignGenerator extends AbstractJavaCodegen implements CodegenConfig {

    protected static String CODEGEN_NAME = "custom-java-feign";
    protected static String CODEGEN_HELP = "Generates a " + CODEGEN_NAME + " client library.";

    public CodegenType getTag() {
        return CodegenType.CLIENT;
    }

    public String getName() {
        return CODEGEN_NAME;
    }

    public String getHelp() {
        return CODEGEN_HELP;
    }

    public static final String JETBRAINS_ANNOTATION_NULLABLE = "jetbrainsAnnotationsNullable";
    public static final String REQUEST_OVERLOAD_MAP = "requestOverloadMap";
    public static final String REQUEST_OVERLOAD_SPEC = "requestOverloadSpec";

    @Setter
    private Boolean jetbrainsAnnotationsNullable = true;

    public JavaFeignGenerator() {
        super();

        // setup
        templateDir = CODEGEN_NAME;

        // reset / reconfigure base generator
        modelTemplateFiles.clear();
        apiTemplateFiles.clear();
        apiTestTemplateFiles.clear();
        modelDocTemplateFiles.clear();
        apiDocTemplateFiles.clear();
        importMapping.remove("ApiModelProperty", "io.swagger.annotations.ApiModelProperty");
        importMapping.remove("ApiModel", "io.swagger.annotations.ApiModel");
        setDateLibrary("java8");

        // features
        cliOptions.add(CliOption.newBoolean(JETBRAINS_ANNOTATION_NULLABLE, "Enable JetBrains Annotations Nullable", this.jetbrainsAnnotationsNullable));

        // configuration
        setSerializableModel(true);
        setJetbrainsAnnotationsNullable(true);
    }

    @Override
    public void processOpts() {
        super.processOpts();

        // date library
        if (getDateLibrary() == "java8") {
            // use instant
            typeMapping.put("date", "Instant");
            importMapping.put("Instant", "java.time.Instant");
        }

        // nullable
        // - intellij annotation
        if (additionalProperties.containsKey(JETBRAINS_ANNOTATION_NULLABLE)) {
            this.setJetbrainsAnnotationsNullable(Boolean.parseBoolean(additionalProperties.get(JETBRAINS_ANNOTATION_NULLABLE).toString()));
        }
        additionalProperties.put(JETBRAINS_ANNOTATION_NULLABLE, jetbrainsAnnotationsNullable);
        // - query by map
        additionalProperties.put(REQUEST_OVERLOAD_MAP, false);
        additionalProperties.put(REQUEST_OVERLOAD_SPEC, true); // TODO: enable

        // feign main class
        additionalProperties.put("mainClassName", camelize(openAPI.getInfo().getTitle(), false).replace(" ", ""));

        // directories
        final String invokerFolder = (sourceFolder + "/" + invokerPackage).replace(".", "/");
        final String apiFolder = (sourceFolder + "/" + apiPackage).replace(".", "/");
        final String modelFolder = (sourceFolder + "/" + modelPackage).replace(".", "/");
        final String specFolder = (invokerFolder + "/spec");

        // common files
        modelTemplateFiles.put("model.peb", ".java");
        apiTemplateFiles.put("api.peb", ".java");
        apiTestTemplateFiles.put("api_test.peb", ".java");

        // feign main interface
        supportingFiles.clear();
        // - final interface (extending api_collect interface, workaround because feign can't handle multiple extends in the root interface)
        supportingFiles.add(new SupportingFile("api_main.peb", apiFolder, additionalProperties.get("mainClassName")+".java"));
        // - collect all interfaces into a single one
        supportingFiles.add(new SupportingFile("api_collect.peb", apiFolder, additionalProperties.get("mainClassName")+"ApiCollection.java"));
        // - api client
        supportingFiles.add(new SupportingFile("api_client.peb", invokerFolder, additionalProperties.get("mainClassName")+"Client.java").doNotOverwrite());

        // spec files
        if ((boolean) additionalProperties.get(REQUEST_OVERLOAD_SPEC) == true) {
            apiTemplateFiles.put("api_spec.peb", "Spec.java");
        }
    }

    /**
     * inspect and modify openapi spec
     */
    @Override
    public void preprocessOpenAPI(OpenAPI openAPI) {
        super.preprocessOpenAPI(openAPI);

        if (openAPI == null) {
            return;
        }

        String mainName = camelize(openAPI.getInfo().getTitle(), false);

        // tags
        openAPI.getTags().clear();
        openAPI.setTags(List.of(new Tag().name(mainName)));

        if (openAPI.getPaths() != null) {
            for (String pathname : openAPI.getPaths().keySet()) {
                PathItem path = openAPI.getPaths().get(pathname);
                if (path.readOperations() != null) {
                    for (Operation operation : path.readOperations()) {
                        log.info("Processing operation {}", operation.getOperationId());
                        processVendorExtensions(operation.getExtensions());

                        // change tags
                        /*
                        operation.getTags().clear();
                        operation.setTags(List.of(mainName));
                        */
                    }
                }
            }
        }
        if (openAPI.getComponents() != null && openAPI.getComponents().getSchemas() != null) {
            openAPI.getComponents().getSchemas().entrySet().forEach(schema -> {
                log.info("Processing schema {}", schema.getKey());
                processVendorExtensions(schema.getValue().getExtensions());
            });
        }
    }

    /**
     * some template engines have trouble with vendorExtensions, if the keys contain a minus, therefore we duplicate the values and replace the minus with a underscore for compatibility
     *
     * @param vendorExtensions vendorExtensions
     */
    private void processVendorExtensions(Map<String, Object> vendorExtensions) {
        // todo: modify vendor extensions
    }

    @Override
    public void postProcessModelProperty(CodegenModel model, CodegenProperty property) {
        super.postProcessModelProperty(model, property);

        // clear legacy imports from base codegen
        model.imports.remove("ApiModelProperty");
        model.imports.remove("ApiModel");
    }

    @Override
    public CodegenModel fromModel(String name, Schema model) {
        CodegenModel codegenModel = super.fromModel(name, model);

        // clear legacy imports from base codegen
        codegenModel.imports.remove("ApiModel");
        codegenModel.imports.remove("org.threeten.bp.LocalDate");

        return codegenModel;
    }

    @Override
    public Map<String, Object> postProcessOperationsWithModels(Map<String, Object> objs, List<Object> allModels) {
        objs = super.postProcessOperationsWithModels(objs, allModels);

        Map<String, Object> operations = (Map<String, Object>) objs.get("operations");
        List<CodegenOperation> operationList = (List<CodegenOperation>) operations.get("operation");
        for (CodegenOperation op : operationList) {
            // collect all required scopes and store them into vendor extension
            if (op.hasAuthMethods) {
                Set<String> requiredScopes = new HashSet<>();
                op.authMethods.forEach(method -> {
                    Optional.ofNullable(method.scopes).ifPresent(scope -> scope.forEach(s -> requiredScopes.add(s.get("scope").toString())));
                });
                op.vendorExtensions.put("x-required-scopes", requiredScopes);
            }
        }
        return objs;
    }

    /**
     * Log Output
     */
    @Override
    public void postProcess() {
        System.out.println("################################################################################");
        System.out.println("# Thanks for using OpenAPI Generator.                                          #");
        System.out.println("#                                                                              #");
        System.out.println("# This generator's contributed by github.com/twitch4j                          #");
        System.out.println("################################################################################");
    }
}
