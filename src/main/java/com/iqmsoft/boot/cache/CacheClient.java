package com.iqmsoft.boot.cache;


import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;



public class CacheClient  implements CommandLineRunner {

   // private static final Logger log = LoggerFactory.getLogger(CacheClient.class);

    private Cache cache;

    public CacheClient(final Cache cache) {
        this.cache = cache;
    }


    @Override
    public void run(String... strings) throws Exception {
        
    	 List<String> l = new LinkedList<>();
         l.add("test1");
         l.add("test2");
         l.add("test3");
         
         Map<String, String> m = new LinkedHashMap<>();
         m.put("test1", "test1");
         m.put("test2", "test2");
         m.put("test3", "test3");
    	
    	this.cache.set("1");
    	this.cache.set("2");
    	this.cache.get("1");
        this.cache.get("2");


        this.cache.setCollect(l);
        this.cache.delCollect(l);
        this.cache.getCollect(l);
        this.cache.setCollect(m.values());
        this.cache.getCollect(m.keySet());

    }
}
