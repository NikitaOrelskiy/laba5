package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class CityStorage {
    private Map<Long, City> storage;
    private FileManager fileManager;
    private Long counter;

    public CityStorage() {
        fileManager = new FileManager();
    }

    void init(){
        try {
            storage = fileManager.read("car.json");
            Set<Long> ids = storage.keySet();
            if(!ids.isEmpty()) {
                Long maxKey = Collections.max(ids);
                counter = maxKey + 1;
            }
        } catch (ParseJsonException e) {
            storage = new HashMap<>();
        }
    }

    public int size() {
        return this.storage.size();
    }

    public City cityById(Long id) {
        return storage.get(id);
    }


    public void removeKey(Long id){
        storage.remove(id);
    }

    public void createNew(
            String name, Coordinates coordinates, Date creationDate, long area, Integer population, long metersAboveSeaLevel, Date establishmentDate, Double agglomeration, Climate climate, Human governor
    ){
        counter++;
        City city = new City(
                counter,
                name,
                coordinates,
                creationDate,
                area,
                population,
                metersAboveSeaLevel,
                establishmentDate,
                agglomeration,
                climate,
                governor
        );


        storage.put(counter, city);
    }

    public void clear(){
        storage.clear();
    }

    public boolean findId(String id){
        return true;
    }


    public void printAll(){
        for(Map.Entry<Long, City> city: storage.entrySet()){
            System.out.println(city);
        }
    }

    public void removeGreaterKey(Long id) {
        storage.entrySet().removeIf(kv -> kv.getKey().compareTo(id) > 0);
    }

    public void removeLowerKey(Long id) {
        storage.entrySet().removeIf(kv -> kv.getKey().compareTo(id) < 0);
    }

    public void updateByKey(Long id, String cityName) {
        if (!storage.containsKey(id)) {
            throw new RuntimeException("no city id in storage");
        }
        City city = storage.get(id);
        city.setName(cityName);
    }

    public void removeCity(City city){
        storage.remove(city.getId());
    }

    public void removeGreater(Long id) {
        City city = storage.get(id);
//        for(Map.Entry<Long, City> cityCompare : storage.entrySet()){
//            City c = cityCompare.getValue();
//            if(c.compareTo(city) > 0){
//                removeCity(c);
//            }
//        }

        storage.entrySet().removeIf(kv -> kv.getValue().compareTo(city) > 0);

    }

    public void saveToFile() {
        fileManager.write(storage, "car.json");
    }

    public void removeByGovernor(Human governor) {
        storage.entrySet().removeIf(kv -> kv.getValue().equals(governor));
    }

    public void sortById() {
//        Long [] masID = new Long[0];
//        int counter = 0;
//        for(Map.Entry<Long, City> city: storage.entrySet()){
//            masID[counter] = city.getKey();
//            counter++;
//        }
//
//        Arrays.sort(masID);
//        counter = 0;
//        for(Map.Entry<Long, City> city: storage.entrySet()){
//            System.out.println(storage.get(masID[counter]));
//            counter++;
//        }

        storage.values()
                .stream()
                .sorted(Comparator.comparing(City::getId))
                .forEach(System.out::println);
//                .collect(Collectors.toList());
    }

    public void printAgglomiration() {
//        Double [] masAg = new Double[0];
//        int counter = 0;
//
//        for(Map.Entry<Long, City> city: storage.entrySet()){
//            Double agglomiration = cityById(city.getKey()).getAg();
//            masAg[counter] = storage.get(agglomiration);
//            counter++;
//        }
//
//
//
//        Arrays.sort(masAg, Collections.reverseOrder());;
//        counter = 0;
//        for(Map.Entry<Long, City> city: storage.entrySet()){
//            System.out.println(storage.get(masAg[counter]));
//            counter++;
//        }

        storage.values().stream().sorted(Comparator.comparing(City::getAg).reversed()).forEach(System.out::println);


    }
}
