package com.monocept.test;

import com.monocept.model.FirstInFirstOut;
import com.monocept.model.LeastFrequentlyUsed;
import com.monocept.model.LeastRecentlyUsed;
import com.monocept.model.MemoryMap;

public class EvictionStrategyTest {

	public static void main(String[] args) {
		MemoryMap memoryMap = new MemoryMap(new FirstInFirstOut());
		memoryMap.put("a",0);
		memoryMap.put("b",0);
		memoryMap.put("c",0);
		memoryMap.get("b");
		memoryMap.get("b");
		memoryMap.get("a");
		memoryMap.get("a");
		memoryMap.get("c");
		memoryMap.get("a");
		memoryMap.put("d", 0);
		
		System.out.println(memoryMap);
		
		memoryMap = new MemoryMap(new LeastRecentlyUsed());
		memoryMap.put("a",0);
		memoryMap.put("b",0);
		memoryMap.put("c", 0);
		memoryMap.get("b");
		memoryMap.get("b");
		memoryMap.get("a");
		memoryMap.get("a");
		memoryMap.get("c");
		memoryMap.get("a");
		memoryMap.put("d", 0);
		
		System.out.println(memoryMap);
		
		memoryMap = new MemoryMap(new LeastFrequentlyUsed());
		memoryMap.put("a",0);
		memoryMap.put("b",0);
		memoryMap.put("c", 0);
		memoryMap.get("b");
		memoryMap.get("b");
		memoryMap.get("a");
		memoryMap.get("a");
		memoryMap.get("c");
		memoryMap.get("a");
		memoryMap.put("d", 0);
		
		System.out.println(memoryMap);

	}

}
