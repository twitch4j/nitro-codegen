package com.github.twitch4j.codegen.java.feign;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.codegen.CliOption;
import org.openapitools.codegen.CodegenConfig;
import org.openapitools.codegen.CodegenOperation;
import org.openapitools.codegen.CodegenParameter;
import org.openapitools.codegen.CodegenType;
import org.openapitools.codegen.SupportingFile;
import org.openapitools.codegen.api.TemplateFileType;

import java.util.*;
import java.util.regex.Pattern;

import static org.openapitools.codegen.utils.StringUtils.camelize;

@Slf4j
public class JavaFeignGenerator extends AbstractJava8Codegen implements CodegenConfig {

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

        // features
        cliOptions.add(CliOption.newBoolean(JETBRAINS_ANNOTATION_NULLABLE, "Enable JetBrains Annotations Nullable", this.jetbrainsAnnotationsNullable));

        // configuration
        setSerializableModel(true);
        setJetbrainsAnnotationsNullable(true);
    }

    @Override
    public void processOpts() {
        super.processOpts();

        // nullable
        // - intellij annotation
        if (additionalProperties.containsKey(JETBRAINS_ANNOTATION_NULLABLE)) {
            this.setJetbrainsAnnotationsNullable(Boolean.parseBoolean(additionalProperties.get(JETBRAINS_ANNOTATION_NULLABLE).toString()));
        }
        additionalProperties.put(JETBRAINS_ANNOTATION_NULLABLE, jetbrainsAnnotationsNullable);
        // - query by map
        additionalProperties.put(REQUEST_OVERLOAD_MAP, false);
        additionalProperties.put(REQUEST_OVERLOAD_SPEC, true);

        // feign main class
        additionalProperties.put("mainClassName", camelize(openAPI.getInfo().getTitle(), false).replace(" ", ""));

        // directories
        final String invokerFolder = (sourceFolder + '/' + invokerPackage).replace(".", "/");
        final String apiFolder = (sourceFolder + '/' + apiPackage).replace(".", "/");
        final String modelFolder = (sourceFolder + '/' + modelPackage).replace(".", "/");

        // common files
        modelTemplateFiles.put("model.peb", ".java");
        apiTemplateFiles.put("api.peb", ".java");
        apiTestTemplateFiles.put("api_test.peb", ".java");

        // feign main interface
        supportingFiles.clear();
        supportingFiles.add(new SupportingFile("api_all.peb", apiFolder, additionalProperties.get("mainClassName")+".java").doNotOverwrite());
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
        if (openAPI.getPaths() != null) {
            for (String pathname : openAPI.getPaths().keySet()) {
                PathItem path = openAPI.getPaths().get(pathname);
                if (path.readOperations() != null) {
                    for (Operation operation : path.readOperations()) {
                        log.info("Processing operation {}", operation.getOperationId());
                        processVendorExtensions(operation.getExtensions());
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
}
