package com.chris.testalgorithm;

import java.text.DateFormat;
import java.util.Locale;

public class TestAlgorithm {
    public static void main(String[] args) {
        int[] sourceArray = new int[] {
                5, 7, 6, 4, 2, 1, 10, 3
                ,15, 27, 36, 44, 52, 61, 10, 73, 86, 98, 100, 1000, 10000
        };
        long startTime = System.currentTimeMillis();
//        SortAlgorithm.bubbleSort(sourceArray);
//        SortAlgorithm.bubbleSort1(sourceArray);
//        SortAlgorithm.selectSort(sourceArray);
//        SortAlgorithm.selectSort1(sourceArray);
//        SortAlgorithm.insertSort(sourceArray);
//        SortAlgorithm.shellSort(sourceArray);
//        SortAlgorithm.mergeSort(sourceArray);
//        SortAlgorithm.quickSort(sourceArray);
//        SortAlgorithm.heapSort(sourceArray);
//        SortAlgorithm.countingSort(sourceArray);
//        SortAlgorithm.bucketSort(sourceArray);
        SortAlgorithm.radixSort(sourceArray);

        long stopTime = System.currentTimeMillis();
        System.out.println("spend "+(stopTime-startTime)+" ms");
    }
}
