package com.chris.test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class TestCollections {
    //region List
    List<String> linkedList = new LinkedList<>();
    List<String>  vector = new Vector<>();
    List<String> stringList = new ArrayList<>();
    List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    //endregion List

    //region Set
    Set<String> hashSet = new HashSet<>();
    Set<String> linkedHashSet = new LinkedHashSet<>();
    Set<String> treeSet = new TreeSet<>();
    Set<String> concurrentSkipListSet = new ConcurrentSkipListSet<>();
    Set<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
    //endregion Set

    //region Map
    Map<Integer, String> hashMap = new HashMap<>();
    Map<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
    Map<Integer, String> hashtable = new Hashtable<>();
    Map<Integer, String> treeMap = new TreeMap<>();
    Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
    //endregion Map

    List<String> synchronizedList = Collections.synchronizedList(linkedList);
    Set<String> synchronizedSet = Collections.synchronizedSet(hashSet);
    Map<Integer, String> synchronizedMap = Collections.synchronizedMap(hashMap);
}
