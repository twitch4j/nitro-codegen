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

    private List<TemplatingEngineAdapter> engineAdapters = new ArrayList<>();

    private List<String> extensions = new ArrayList<>();

    public AutoEngineAdapter() {
        engineAdapters.add(new MustacheEngineAdapter());
        engineAdapters.add(new HandlebarsEngineAdapter());
        engineAdapters.add(new PebbleEngineAdapter());
        engineAdapters.add(new JtwigEngineAdapter());


        engineAdapters.forEach(a -> extensions.addAll(Arrays.asList(a.getFileExtensions())));
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

        log.warn("No template engine for extension {} - File: {}", extension, templateFile);

        return null;
    }
}
