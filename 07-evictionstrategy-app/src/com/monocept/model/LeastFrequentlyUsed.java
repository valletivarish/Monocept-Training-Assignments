package com.monocept.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class LeastFrequentlyUsed implements IEvictionStrategy {

	@Override
	public void operation(Map<String, Integer> memoryMap, LinkedList<String> readingOrder) {
        int minCount = memoryMap.get(readingOrder.getFirst());
        String keyToRemove = null;
		for (String key : readingOrder) {
			int count = memoryMap.get(key);
			if (count < minCount) {
				minCount = count;
				keyToRemove = key;
			}
		}
		memoryMap.remove(keyToRemove);
	}
}
