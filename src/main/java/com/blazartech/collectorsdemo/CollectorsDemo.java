/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.blazartech.collectorsdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author aar1069
 */
public class CollectorsDemo {

    private static void logCollection(String name, Collection<Integer> data) {
        System.out.println();
        System.out.println("name -> " + name);
        
        int sum = data.stream()
                .peek(i -> System.out.println("element " + i))
                .collect(Collectors.summingInt(Integer::intValue));

        System.out.println("total = " + sum);
    }

    public static void main(String[] args) {

        Integer[] data = {1, 2, 3, 4, 5, 6};

        List<Integer> dataCollection = Arrays.asList(data);

        List<Integer> dataCopy = dataCollection
                .stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
        logCollection("dataCopy", dataCopy);

        Collection<List<Integer>> multiData = List.of(dataCollection, Arrays.asList(9, 8, 7, 6), dataCopy);

        // combine down to a single list, easy way
        List<Integer> combinedMulti = new ArrayList<>();
        multiData.stream()
                .forEach(c -> combinedMulti.addAll(c));
        logCollection("combinedMulti", combinedMulti);

        // do same, with reducer
        List<Integer> combinedMultiReduce = multiData.stream()
                .reduce(new ArrayList<>(), (accum, a) -> {
                    accum.addAll(a);
                    return accum;
                });
        logCollection("combinedMultiReduce", combinedMultiReduce);

        // use collector? https://stackoverflow.com/questions/43625683/how-to-do-add-all-with-java-streams
        // flatMap combines the different collections into a single stream.
        List<Integer> combinedMultiCollect = multiData.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        logCollection("combinedMultiCollect", combinedMultiCollect);
        
        // vectors
        List<Vector2D> vectorList = Arrays.asList(new Vector2D(1, 1), new Vector2D(0, -1), new Vector2D(-2, 2));
        Vector2D vectorSum = vectorList.stream().reduce(new Vector2D(), (accum, v) -> accum.plus(v));
        System.out.println();
        System.out.println("vectorSum = " + vectorSum);
    }
}
