package com.rogercw.cache.initcache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Created by 1 on 2018/4/18.
 */
@Configuration
@ComponentScan(basePackages = "com.rogercw.cache.initcache")
@EnableCaching
public class ApplicationConfig {

    @Bean
    public CacheManager cacheManager(){
        SimpleCacheManager simpleCacheManager=new SimpleCacheManager();
        simpleCacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("users")));
        return simpleCacheManager;
    }
}
