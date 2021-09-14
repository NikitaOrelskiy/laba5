package com.company;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Map;

public class FileManager {
    private ObjectMapper objectMapper;

    public FileManager() {
        this.objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }


    void write(Map<Long, City> map, String filename){ // "car.json"
        try {
            FileOutputStream fouts = new FileOutputStream(filename);
            objectMapper.writeValue(fouts, map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Map<Long, City> read(String filename) throws ParseJsonException {
        try {
            FileInputStream fis = new FileInputStream(filename);

            BufferedInputStream bis = new BufferedInputStream(fis);
            return objectMapper.readValue(bis, new TypeReference<Map<Long, City>>(){});
        } catch (IOException e) {
            e.printStackTrace();
            throw new ParseJsonException("Cannot parse " + filename);
        }
    }
}
