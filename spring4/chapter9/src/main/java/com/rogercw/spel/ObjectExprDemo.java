package com.rogercw.spel;

import com.rogercw.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Created by 1 on 2018/4/29.
 * 赋值
 */
public class ObjectExprDemo {

    public static void main(String[] args) {
        User user=new User();
        user.setUserName("zhangsan");
        ExpressionParser parser=new SpelExpressionParser();
        EvaluationContext context=new StandardEvaluationContext(user);

        //通过setValue（）方法赋值
        parser.parseExpression("userName").setValue(context,"lisi");
        System.out.println(user.getUserName());

        //通过表达式赋值
        parser.parseExpression("userName='zhangsan'").getValue(context);
        System.out.println(user.getUserName());
    }
}
