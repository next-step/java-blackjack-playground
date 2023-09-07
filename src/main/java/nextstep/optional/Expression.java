package nextstep.optional;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum Expression {
    PLUS("+"), MINUS("-"), TIMES("*"), DIVIDE("/");

    private String expression;

    Expression(String expression) {
        this.expression = expression;
    }

    private static boolean matchExpression(Expression e, String expression) {
        return expression.equals(e.expression);
    }
    public String getExpression(){
        return this.expression;
    }
    private static final Map<String, Expression> expressionMap = Collections.unmodifiableMap(
            Arrays.stream(values()).collect(Collectors.toMap(Expression::getExpression, Function.identity()))
    );

    static Expression of(String expression) {
        return Optional.ofNullable(expressionMap.get(expression)).orElseThrow(
                () -> new IllegalArgumentException(String.format("%s는 사칙연산에 해당하지 않는 표현식입니다.", expression))
        );
//        return Arrays.stream(values()).filter(v -> matchExpression(v, expression)).findAny().orElseThrow(
//                () -> new IllegalArgumentException(String.format("%s는 사칙연산에 해당하지 않는 표현식입니다.", expression))
//        );
    }
}
