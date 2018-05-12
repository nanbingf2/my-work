package com.rogercw.concept;

/**
 * Created by 1 on 2018/4/30.
 */
public class MainClass {

    public static void main(String[] args) {
        ForumService service = new ForumService();
        service.create(new Forum());
        service.removeTopic(111);
    }
}
