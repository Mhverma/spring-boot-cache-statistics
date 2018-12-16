package com.manoj.training.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfiguration extends CachingConfigurerSupport{

	  @Bean
	    @Override
	    public CacheManager cacheManager() {
	        SimpleCacheManager cacheManager = new SimpleCacheManager();
	        cacheManager.setCaches(getCacheName().stream().map(ConcurrentMapCacheMetricsWrapper::new).collect(Collectors.toList()));
	        return cacheManager;
	    }
	  
	  public List<String> getCacheName()
	  {
		  List<String> cacheName = new ArrayList<>();
		  cacheName.add("book");
		  cacheName.add("movies");
		  return cacheName;
	  }
}
