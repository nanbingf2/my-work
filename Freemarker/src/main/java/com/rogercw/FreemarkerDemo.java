package com.rogercw;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

/**
 * @Author: rogercw
 * @Date: 2018/8/16 19:56
 * @Version 1.0
 */
public class FreemarkerDemo {

    public static void main(String[] args) throws Exception {
        //创建Configuration对象，参数为freemarker的版本号
        Configuration configuration=new Configuration(Configuration.getVersion());
        //设置模板文件的路径
        configuration.setDirectoryForTemplateLoading(new File("C:\\Users\\Administrator\\Desktop\\IDEA\\my-work\\Freemarker\\src\\main\\resources"));
        //设置模板文件使用的字符集
        configuration.setDefaultEncoding("UTF-8");
        //加载模板
        Template template = configuration.getTemplate("test.ftl");
        //创建模型数据
        Map map=new HashMap();
        map.put("name","张三");
        map.put("message","这里是Freemarker的世界");
        map.put("success",false);

        List goodsList=new ArrayList();
        Map goods1=new HashMap();
        goods1.put("name","西瓜");
        goods1.put("price",10);
        Map goods2=new HashMap();
        goods2.put("name","苹果");
        goods2.put("price",18);
        Map goods3=new HashMap();
        goods3.put("name","香蕉");
        goods3.put("price",15);
        goodsList.add(goods1);
        goodsList.add(goods2);
        goodsList.add(goods3);
        map.put("goodsList",goodsList);

        map.put("date",new Date());
        map.put("point",112568741);
        //创建输出流对象
        Writer out=new FileWriter("C:\\Users\\Administrator\\Desktop\\test.html");
        //输出
        template.process(map,out);
        //关闭输出流
        out.close();
    }
}
