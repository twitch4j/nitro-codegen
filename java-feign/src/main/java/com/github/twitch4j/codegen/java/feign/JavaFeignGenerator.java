package com.github.twitch4j.codegen.java.feign;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.codegen.CodegenConfig;
import org.openapitools.codegen.CodegenType;

import java.util.*;

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

    public JavaFeignGenerator() {
        super();

        // setup
        templateDir = CODEGEN_NAME;

        // dirs
        final String invokerFolder = (sourceFolder + '/' + invokerPackage).replace(".", "/");
        final String apiFolder = (sourceFolder + '/' + apiPackage).replace(".", "/");

        // common files
        modelTemplateFiles.put("model.peb", ".java");
        apiTemplateFiles.put("api.peb", ".java");
        apiTestTemplateFiles.put("api_test.peb", ".java");

        // support files
        // supportingFiles.add(new SupportingFile("README.peb", "", "README.md"));

        // add original openapi yaml to resources
        // supportingFiles.add(new SupportingFile("openapi.peb", projectFolder + "/resources/openapi", "openapi.yaml"));

        // configuration
        setSerializableModel(true);
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
        if (vendorExtensions != null) {
            Map<String, Object> vendorExtensionsAdd = new HashMap<>();
            vendorExtensions.keySet().stream().filter(key -> key.contains("-")).forEach(key -> vendorExtensionsAdd.put(key.replace("-", "_"), vendorExtensions.get(key)));
            vendorExtensions.putAll(vendorExtensionsAdd);
        }
    }
}
