package com.monocept.model;

import java.util.LinkedList;
import java.util.Map;

public class LeastFrequentlyUsed implements IEvictionStrategy {

	@Override
	public void operation(Map<String, Integer> memoryMap, LinkedList<String> readingOrder) {
		int minCount = Integer.MAX_VALUE;
		String keyToRemove = null;

		for (String key : readingOrder) {
			int count = memoryMap.getOrDefault(key, 0);
			if (count < minCount) {
				minCount = count;
				keyToRemove = key;
			}
		}

		if (keyToRemove == null && !readingOrder.isEmpty()) {
			keyToRemove = readingOrder.getFirst();
		}

		if (keyToRemove != null) {
			memoryMap.remove(keyToRemove);
			readingOrder.remove(keyToRemove);
		}
	}
}
