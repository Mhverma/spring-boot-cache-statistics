package com.manoj.training.model;

import lombok.Data;

@Data
public class CacheStatistics {

	private String cacheName;
	
	private long hitCount;
	
	private long size;
	
	private long missCount;
	
	private long putCount;
	
	private long evictCount;
}
