package com.company;

import com.fasterxml.jackson.core.JsonParser;
import commands.*;
import managers.ConsoleCommandManager;
import managers.ExecutorManager;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Map<Long, City> map = new HashMap<>();
//        map.put(10L, new City(10L, "SPB", new Coordinates(5, 7), new Date(), 4, 3, 1, new Date(), 3D, SUBARCTIC, new Human("Victor", 40, 180, new Date())));
//        map.put(11L, new City(11L, "SPB", new Coordinates(5, 7), new Date(), 4, 3, 1, new Date(), 3D, SUBARCTIC, new Human("Victor", 40, 180, new Date())));

        CityStorage cityStorage = new CityStorage();
        cityStorage.init();
        ExecutorManager executorManager = new ExecutorManager(cityStorage, System.in);
        executorManager.execute();
    }
}
