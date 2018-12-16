package com.manoj.training.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manoj.training.cache.ConcurrentMapCacheMetricsWrapper;
import com.manoj.training.model.CacheStatistics;

@RestController
public class CacheController {
	Logger LOGGER = LoggerFactory.getLogger(CacheController.class);
	@Autowired
	private CacheManager cacheManager;
	@GetMapping("/cachenames")
	public Collection<String> getAllCache()
	{
		return cacheManager.getCacheNames();
	}
	
	@GetMapping("/cache-statistics")
	public List<CacheStatistics> getCacheStatics()
	{
		List<CacheStatistics> statistics = new ArrayList<>();
		for (String cacheName : cacheManager.getCacheNames()) {
			ConcurrentMapCacheMetricsWrapper cache =	(ConcurrentMapCacheMetricsWrapper) cacheManager.getCache(cacheName);
			CacheStatistics cs = new CacheStatistics();
			cs.setCacheName(cacheName);
			cs.setHitCount(cache.getHitCount());
			cs.setMissCount(cache.getMissCount());
			cs.setPutCount(cache.getPutCount());
			cs.setEvictCount(cs.getEvictCount());
			cs.setSize(cache.getNativeCache().size());
			statistics.add(cs);
			LOGGER.info("cache- {}", cache);
		}
		
		return statistics;
	}
	
	@GetMapping("/clearcache")
	@CacheEvict(allEntries= true, cacheNames={"book", "movies"})
	public void clearCache(){
		
	}
}
