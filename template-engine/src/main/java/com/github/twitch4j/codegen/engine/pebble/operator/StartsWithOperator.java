package com.github.twitch4j.codegen.engine.pebble.operator;

import com.mitchellbosecke.pebble.node.expression.BinaryExpression;
import com.mitchellbosecke.pebble.operator.Associativity;
import com.mitchellbosecke.pebble.operator.BinaryOperator;
import com.mitchellbosecke.pebble.operator.BinaryOperatorType;

public class StartsWithOperator implements BinaryOperator {

    /**
     * This precedence is set based on
     * <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html">Java
     * Operators</a> 30 is the same precedence pebble has set for operators like {@code instanceof}
     * like <a href="https://github.com/PebbleTemplates/pebble/wiki/extending-pebble">Extending
     * Pebble</a>.
     */
    public int getPrecedence() {
        return 30;
    }

    public String getSymbol() {
        return "startswith";
    }

    public BinaryOperatorType getType() {
        return BinaryOperatorType.NORMAL;
    }

    public BinaryExpression<?> getInstance() {
        return new StartsWithExpression();
    }

    public Associativity getAssociativity() {
        return Associativity.LEFT;
    }

}
