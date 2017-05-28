package com.iqmsoft.boot.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.util.Arrays;


@SpringBootApplication
@EnableCaching
public class Application {


    @Bean
    public Cache cache() {
        return new Cache();
    }
    
    @Bean
    public EhCacheManagerFactoryBean cacheMangerFactory() {
        EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
        bean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        bean.setShared(true);
        return bean;
    }

    @Bean
    public CacheClient cacheClient(Cache cache) {
        return new CacheClient(cache);
    }


    @Bean
    public CacheManager cacheManager() {
        final SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(
                new ConcurrentMapCache("foo4"),
                new ConcurrentMapCache("foo1"),
                new ConcurrentMapCache("foo2"),
                new ConcurrentMapCache("foo3")
              ));
        return cacheManager;
        
        
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
