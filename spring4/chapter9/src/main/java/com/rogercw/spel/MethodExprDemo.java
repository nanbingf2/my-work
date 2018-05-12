package com.rogercw.spel;

import com.rogercw.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Created by 1 on 2018/4/29.
 * 方法解析测试
 */
public class MethodExprDemo {

    public static void main(String[] args) {
        User user=new User();
        ExpressionParser parser=new SpelExpressionParser();
        EvaluationContext context=new StandardEvaluationContext(user);

        //调用String中的方法
        String subString=parser.parseExpression("'hello Spring'.substring(7)").getValue(String.class);
        String indexOf=parser.parseExpression("'Hello Spring'.indexOf('Spring')").getValue(String.class);

        //调用实例方法
        Boolean bool=parser.parseExpression("validatePassword(123456)").getValue(context,Boolean.class);

        //调用私有方法,将发生错误
        //Boolean bool2=parser.parseExpression("validatePassword2(123456)").getValue(context,Boolean.class);

        //调用静态方法
        Boolean bool3=parser.parseExpression("validatePassword3(123456)").getValue(context,Boolean.class);

        //调用实例方法,可变参数方法
        parser.parseExpression("addInterests('Spring','Hibernate')").getValue(context,Boolean.class);

        System.out.println(subString);
        System.out.println(indexOf);
        System.out.println(bool3);
        System.out.println(bool);
    }
}
