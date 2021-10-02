package com.github.twitch4j.codegen.engine.pebble;

import com.github.twitch4j.codegen.engine.pebble.filter.PadRightFilter;
import com.github.twitch4j.codegen.engine.pebble.filter.WrapInFilter;
import com.github.twitch4j.codegen.engine.pebble.function.GetOrDefaultFunction;
import com.github.twitch4j.codegen.engine.pebble.function.NewLineFunction;
import com.github.twitch4j.codegen.engine.pebble.operator.StartsWithOperator;
import com.mitchellbosecke.pebble.attributes.AttributeResolver;
import com.mitchellbosecke.pebble.extension.Extension;
import com.mitchellbosecke.pebble.extension.Filter;
import com.mitchellbosecke.pebble.extension.Function;
import com.mitchellbosecke.pebble.extension.NodeVisitorFactory;
import com.mitchellbosecke.pebble.extension.Test;
import com.mitchellbosecke.pebble.operator.BinaryOperator;
import com.mitchellbosecke.pebble.operator.UnaryOperator;
import com.mitchellbosecke.pebble.tokenParser.TokenParser;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CodeGenPebbleExtension implements Extension {

    @Override
    public Map<String, Filter> getFilters() {
        return Map.of(
                "padright", new PadRightFilter(),
                "wrapin", new WrapInFilter()
        );
    }

    @Override
    public Map<String, Test> getTests() {
        return null;
    }

    @Override
    public Map<String, Function> getFunctions() {
        return Map.of(
                "newline", new NewLineFunction(),
                "getOrDefault", new GetOrDefaultFunction()
        );
    }

    @Override
    public List<TokenParser> getTokenParsers() {
        return null;
    }

    @Override
    public List<BinaryOperator> getBinaryOperators() {
        return Arrays.asList(new StartsWithOperator());
    }

    @Override
    public List<UnaryOperator> getUnaryOperators() {
        return null;
    }

    @Override
    public Map<String, Object> getGlobalVariables() {
        return null;
    }

    @Override
    public List<NodeVisitorFactory> getNodeVisitors() {
        return null;
    }

    @Override
    public List<AttributeResolver> getAttributeResolver() {
        return null;
    }
}
