package com.rogercw.spel;

import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * Created by 1 on 2018/4/28.
 */
public class LiteralExprDemo {
    public static void main(String[] args) {
        SpelExpressionParser parser = new SpelExpressionParser();

        //知悉字符串
        String helloword = parser.parseExpression("'hello wprld'").getValue(String.class);

        //解析双精度浮点数
        double doubleNumber = parser.parseExpression("3.62323555555555223").getValue(Double.class);

        //解析整型数据
        int maxValue = parser.parseExpression("0x5656").getValue(Integer.class);

        //解析空值
        Object nullValue = parser.parseExpression("null").getValue();

        //解析布尔型数据
        boolean trueValue = parser.parseExpression("1==1").getValue(Boolean.class);

        System.out.println(helloword);
        System.out.println(doubleNumber);
        System.out.println(maxValue);
        System.out.println(nullValue);
        System.out.println(trueValue);
    }
}
