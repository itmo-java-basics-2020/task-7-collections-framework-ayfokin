package ru.ifmo.collections;

import java.util.LinkedHashMap;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {
    private final LinkedHashMap <Integer, Boolean> data; // <Value, isUnique>

    public FirstUnique(int[] numbers) {
        data = new LinkedHashMap<>();
        for (int i: numbers) {
            add(i);
        }
    }

    public int showFirstUnique() {
        for (Integer entry: data.keySet()) {
            if (data.get(entry)) {
                return entry;
            }
        }
        return -1;
    }

    public void add(int value) {
        if (data.containsKey(value)) {
            data.put(value, false);
        } else {
            data.put(value, true);
        }
    }
}
