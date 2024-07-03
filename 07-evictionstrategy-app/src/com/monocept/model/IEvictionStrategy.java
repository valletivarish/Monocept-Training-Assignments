package com.monocept.model;

import java.util.LinkedList;
import java.util.Map;

public interface IEvictionStrategy {
	void operation(Map<String, Integer> memoryMap, LinkedList<String> readingOrder);
}
