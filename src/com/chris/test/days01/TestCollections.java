package com.chris.test.days01;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class TestCollections {
    public static void main(String[] args) {
//        testList();
//        testSet();
        testMap();
    }

    private static void testMap() {
        //region Map
        HashMap<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        Map<Integer, String> hashtable = new Hashtable<>();
        Map<Integer, String> treeMap = new TreeMap<>();
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, String> synchronizedMap = Collections.synchronizedMap(hashMap);
        //endregion Map

        BiConsumer<? super Integer, ? super String> action = new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer k, String v) {
                System.out.println("    Map<"+k+", "+v+">");
            }
        };

        Integer key = 1;
        String value = "Value_";
        //region Add
        hashMap.put(key, value + "1");
        hashMap.put(2, value + "2");
        hashMap.put(3, value + "3");
        //endregion Add

        System.out.println("After add:");
        hashMap.forEach(action);

        //region Remove
        System.out.println("remove <" + key +", "+ hashMap.remove(key) + ">");
        System.out.println("remove <" + key +", "+ (value+key) + ">, result=" + hashMap.remove(key,value+key));
        System.out.println("After remove:");
        hashMap.forEach(action);
//        hashMap.clear();
//        System.out.println("After clear:");
//        hashMap.forEach(action);
        //endregion Remove

        //region Query
        hashMap.size();
        hashMap.isEmpty();
        hashMap.containsKey(key);
        hashMap.containsValue(value);
        //endregion Query

        //region Modify
        hashMap.replace(2, "New Value");
        //endregion Modify
        System.out.println("After modify:");
        hashMap.forEach(action);

        for (Integer k:hashMap.keySet()) {
            System.out.println("key_" + k);
        }

        for (String v:hashMap.values()) {
            System.out.println("value=" + v);
        }

    }

    private static void testSet() {
        //region Set
        HashSet<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();
        Set<String> concurrentSkipListSet = new ConcurrentSkipListSet<>();
        Set<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        Set<String> synchronizedSet = Collections.synchronizedSet(hashSet);
        //endregion Set

        Consumer<? super String> action = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("    Set["+s+"]");
            }
        };

        //region Add
        hashSet.add("h1");
        hashSet.add("h2");
        hashSet.add("h3");
        //endregion Add
        System.out.println("After add: ");
        hashSet.forEach(action);

        //region Remove
        hashSet.remove("h1");
        System.out.println("After remove: ");
        hashSet.forEach(action);
        hashSet.clear();
        System.out.println("After clear: ");
        hashSet.forEach(action);
        //endregion Remove

        //region Query
        hashSet.size();
        hashSet.contains("h1");
        hashSet.isEmpty();
        //endregion Query

        //region Modify
        //endregion Modify
    }

    private static void testList() {
        //region List
        LinkedList<String> linkedList = new LinkedList<>();
        List<String>  vector = new Vector<>();
        List<String> stringList = new ArrayList<>();
        List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        List<String> synchronizedList = Collections.synchronizedList(linkedList);
        //endregion List

        Consumer<? super String> action = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("   List[" + s +"]");
            }
        };

        //region Add
        //Inserts the specified element at the beginning of this list.
        linkedList.addFirst("addFirst");
        //Appends the specified element to the end of this list.
        linkedList.addLast("addLast");
        System.out.println("After addFirstAndLast");
        linkedList.forEach(action);
        // Appends the specified element to the end of this list.
        linkedList.add("d1");
        linkedList.add("d2");
        linkedList.add("d3");
        System.out.println("After add");
        linkedList.forEach(action);
        //Adds the specified element as the tail (last element) of this list.
        //add
        linkedList.offer("o1");
        System.out.println("After offer");
        linkedList.forEach(action);
        //Inserts the specified element at the front of this list.
        //addFirst
        linkedList.offerFirst("offerFirst");
        //Inserts the specified element at the end of this list.
        //addLast
        linkedList.offerLast("offerLast");
        System.out.println("After offerFirstAndLast");
        linkedList.forEach(action);
        //Pushes an element onto the stack represented by this list.
        // In other words, inserts the element at the front of this list.
        linkedList.push("p1");
        System.out.println("After push");
        linkedList.forEach(action);
        //endregion Add

        //region Remove
        //Retrieves and removes the head (first element) of this list.
        linkedList.remove();
        System.out.println("After remove");
        linkedList.forEach(action);
        //Removes and returns the first element from this list.
        linkedList.removeFirst();
        System.out.println("After removeFirst");
        linkedList.forEach(action);
        //Removes and returns the last element from this list.
        linkedList.removeLast();
        System.out.println("After removeLast");
        linkedList.forEach(action);

        //Pops an element from the stack represented by this list.
        // In other words, removes and returns the first element of this list.
        System.out.println("pop # " + linkedList.pop());
        System.out.println("After pop");
        linkedList.forEach(action);
        //Retrieves and removes the head (first element) of this list.
        System.out.println("poll # " + linkedList.poll());
        System.out.println("After poll");
        linkedList.forEach(action);
        //Retrieves and removes the first element of this list, or returns null if this list is empty.
        System.out.println("pollFirst # " + linkedList.pollFirst());
        System.out.println("After pollFirst");
        linkedList.forEach(action);
        //Retrieves and removes the last element of this list, or returns null if this list is empty.
        System.out.println("pollLast # " + linkedList.pollLast());
        System.out.println("After pollLast");
        linkedList.forEach(action);
        //endregion Remove

        //region Get
        //Returns the element at the specified position in this list.
        System.out.println("get # " + linkedList.get(0));
        //Returns the first element in this list.
        System.out.println("getFirst # " + linkedList.getFirst());
        //Returns the last element in this list.
        System.out.println("getLast # " + linkedList.getLast());

        //Retrieves, but does not remove, the head (first element) of this list.
        System.out.println("peek # " + linkedList.peek());
        //Retrieves, but does not remove, the first element of this list, or returns null if this list is empty.
        System.out.println("peekFirst # " + linkedList.peekFirst());
        //Retrieves, but does not remove, the last element of this list, or returns null if this list is empty.
        System.out.println("peekLast # " + linkedList.peekLast());
        //endregion Get

        linkedList.size();
        linkedList.clear();
        System.out.println("After clear");
        linkedList.forEach(action);
        if(linkedList.contains("o1")){
            System.out.println("contains o1");
        } else {
            System.out.println("not contains o1");
        }
    }

}
