package com.rogercw.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by 1 on 2018/4/25.
 * 该类是所有领域类的父类,用于提供统一的toString()方法
 */
public class BaseDomain implements Serializable{

    //领域类统一的toString()方法
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
