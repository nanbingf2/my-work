package com.rogercw.spel;

import com.rogercw.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Created by 1 on 2018/4/29.
 * 三元运算符解析
 */
public class IfThenElseExprDemo {
    public static void main(String[] args) {
        User user=new User();
        user.setUserName("zhangsan");
        user.setCredits(1000);

        ExpressionParser parser=new SpelExpressionParser();
        EvaluationContext context=new StandardEvaluationContext(user);
        Integer credits = parser.parseExpression("userName=='zhangsan' ? credits+50 : credits").getValue(context,Integer.class);
        System.out.println(credits);
    }
}
