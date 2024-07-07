package com.monocept.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MemoryMap implements IEvictionStrategy{
	LinkedList<String> readingOrder;
	Map<String,Integer> memoryMap;
	IEvictionStrategy evictionStrategy;
	public MemoryMap(IEvictionStrategy evictionStrategy) {
		this.readingOrder=new LinkedList<String>();
		this.memoryMap=new LinkedHashMap<String,Integer>();
		this.evictionStrategy=evictionStrategy;
	}
	
	public void get(String key) {
		if(memoryMap.containsKey(key)) {
			memoryMap.put(key, memoryMap.get(key)+1);
			readingOrder.add(key);
		}
	}
	public void put(String key, int value) {
		if(memoryMap.size()>=3) {
			operation(memoryMap,readingOrder);
		}
		memoryMap.put(key, value); 
	}
	@Override
	public String toString() {
		return "MemoryMap [readingOrder = " + readingOrder.toString() + ", memoryMap = " + memoryMap.toString() + ", evictionStrategy = "
				+ evictionStrategy.getClass().getSimpleName() + "]";
	}

	@Override
	public void operation(Map<String, Integer> memoryMap, LinkedList<String> readingOrder) {
		evictionStrategy.operation(memoryMap, readingOrder);
		
	}
}
