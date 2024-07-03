package com.monocept.model;

import java.util.LinkedList;
import java.util.Map;

public class LeastRecentlyUsed implements IEvictionStrategy {

	@Override
	public void operation(Map<String, Integer> memoryMap, LinkedList<String> readingOrder) {
		memoryMap.remove(readingOrder.peekFirst());
		
	}

}
