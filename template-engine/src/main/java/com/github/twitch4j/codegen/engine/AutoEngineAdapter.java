package com.github.twitch4j.codegen.engine;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.openapitools.codegen.api.TemplatingEngineAdapter;
import org.openapitools.codegen.api.TemplatingExecutor;
import org.openapitools.codegen.templating.HandlebarsEngineAdapter;
import org.openapitools.codegen.templating.MustacheEngineAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
public class AutoEngineAdapter implements TemplatingEngineAdapter {

    private static List<TemplatingEngineAdapter> engineAdapters = new ArrayList<>();

    private static List<String> extensions = new ArrayList<>();

    public AutoEngineAdapter() {
        // load all known adapters, just once
        if (engineAdapters.isEmpty()) {
            engineAdapters.add(new MustacheEngineAdapter());
            engineAdapters.add(new HandlebarsEngineAdapter());
            engineAdapters.add(new PebbleEngineAdapter());

            engineAdapters.forEach(adapter-> {
                log.info("registered template engine adapter {}!", adapter.getIdentifier());
                extensions.addAll(Arrays.asList(adapter.getFileExtensions()));
            });
        }
    }

    @Override
    public String getIdentifier() {
        return "auto";
    }

    @Override
    public String[] getFileExtensions() {
        return extensions.toArray(new String[]{});
    }

    @Override
    public String compileTemplate(TemplatingExecutor executor, Map<String, Object> bundle, String templateFile) throws IOException {
        String extension = FilenameUtils.getExtension(templateFile);

        // select the correct engine adapter for this file extension
        for (TemplatingEngineAdapter engineAdapter : engineAdapters) {
            if (Arrays.stream(engineAdapter.getFileExtensions()).anyMatch(extension::equalsIgnoreCase)) {
                log.warn("Template {} will use engine {}", templateFile, engineAdapter.getIdentifier());
                return engineAdapter.compileTemplate(executor, bundle, templateFile);
            }
        }

        log.warn("No template engine found for file extension {} - File: {}", extension, templateFile);
        return null;
    }
}
