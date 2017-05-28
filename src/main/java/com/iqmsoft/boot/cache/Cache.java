package com.iqmsoft.boot.cache;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;



public class Cache {

    private static final Logger log = LoggerFactory.getLogger(Cache.class);

    @Cacheable("foo1")
    public String get(String s) {
        log.info("real get:{}", s);
        return "echo " + s;
    }
    
    @CachePut("foo2")
    public void set(String s) {
        log.info("real set:{}", s);
        
    }
    
    @CachePut("foo3")
    public void setCollect(Collection<?> l) {
        log.info("real collect set:{}", l.toString());
        
    }
    
    @CacheEvict("foo3")
    public void delCollect(Collection<?> l) {
    	
    	l.clear();
    	
        log.info("real collect remove:{}", l.toString());
        
    }
    
    @Cacheable("foo4")
    public void getCollect(Collection<?> l) {
        log.info("real collect get:{}", l.toString());
        
    }
    

}
