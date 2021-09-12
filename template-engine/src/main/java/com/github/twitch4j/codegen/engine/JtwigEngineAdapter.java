package com.github.twitch4j.codegen.engine;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.openapitools.codegen.api.TemplatingEngineAdapter;
import org.openapitools.codegen.api.TemplatingExecutor;

import java.io.*;
import java.util.Map;

@Slf4j
public class JtwigEngineAdapter implements TemplatingEngineAdapter {

    @Getter
    private final String identifier = "jtwig";

    @Getter
    private final String[] fileExtensions = new String[]{"twig"};

    @Override
    public String compileTemplate(TemplatingExecutor executor, Map<String, Object> bundle, String templateFile) throws IOException {
        JtwigTemplate template = JtwigTemplate.inlineTemplate(executor.getFullTemplateContents(templateFile));

        // map bundle into model
        JtwigModel model = JtwigModel.newModel();
        for (Map.Entry<String, Object> entry : bundle.entrySet()) {
            model = model.with(entry.getKey(), entry.getValue());
            log.info("Template variable set: {} = {}", entry.getKey(), entry.getValue());
        }

        return template.render(model);
    }
}
