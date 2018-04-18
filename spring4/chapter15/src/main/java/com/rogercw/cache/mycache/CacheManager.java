package com.rogercw.cache.mycache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1 on 2018/4/16.
 * 自定义缓存管理器
 */
public class CacheManager<T> {
    //定义一个Map用来实现缓存
    private Map<String,T> cache=new HashMap<String,T>();

    public T getValue(String key){
        return cache.get(key);
    }

    /**
     * 向缓存里添加数据
     * @param key
     * @param value
     */
    public void addOrUpdateCache(String key,T value){
        cache.put(key,value);
    }

    /**
     * 根据key来删除缓存里的数据
     * @param key
     */
    public void evictCache(String key){
        if(cache.containsKey(key)){
            //当前缓存中存在指定的key就将其移除
            cache.remove(key);
        }
    }

    /**
     * 删除缓存里的全部纪录
     */
    public void evictAll(){
        cache.clear();
    }

}
