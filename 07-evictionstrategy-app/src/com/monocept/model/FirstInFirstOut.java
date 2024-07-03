package com.monocept.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class FirstInFirstOut implements IEvictionStrategy {

	@Override
	public void operation(Map<String, Integer> memoryMap, LinkedList<String> readingOrder) {
		Iterator<String> keyIterator = memoryMap.keySet().iterator();
        if (keyIterator.hasNext()) {
            memoryMap.remove(keyIterator.next());
        }
	}
}
