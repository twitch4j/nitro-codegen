package com.github.twitch4j.codegen.engine.pebble.filter;

import com.mitchellbosecke.pebble.extension.Filter;
import com.mitchellbosecke.pebble.template.EvaluationContext;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WrapInFilter implements Filter {

    @Override
    public List<String> getArgumentNames() {
        List<String> names = new ArrayList<>();
        names.add("left");
        names.add("right");
        return names;
    }

    @Override
    public Object apply(Object inputObj, Map<String, Object> args, PebbleTemplate self, EvaluationContext context, int lineNumber) {
        String left = (String) args.get("left");
        String right = (String) args.get("right");

        if(inputObj == null) {
            return null;
        }

        return left + inputObj + right;
    }

}
