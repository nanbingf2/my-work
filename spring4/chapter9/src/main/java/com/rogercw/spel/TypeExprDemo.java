package com.rogercw.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * Created by 1 on 2018/4/29.
 * 类型
 */
public class TypeExprDemo {

    public static void main(String[] args) {
        ExpressionParser parser=new SpelExpressionParser();

        //加载String类型
        Class string = parser.parseExpression("T(java.lang.String)").getValue(Class.class);
        System.out.println(string);

        //加载User类型
        Class userClass = parser.parseExpression("T(com.rogercw.User)").getValue(Class.class);
        System.out.println(userClass);
    }
}
