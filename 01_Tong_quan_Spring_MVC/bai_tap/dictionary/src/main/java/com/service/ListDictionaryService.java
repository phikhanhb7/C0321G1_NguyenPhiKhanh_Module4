package com.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class ListDictionaryService implements IListDictionaryService {

    Map<String, String> map;

    {
        map = new HashMap<>();
        map.put("hello", "Xin chào");
        map.put("pen", "Bút");
        map.put("table", "Bàn");
        map.put("bye", "Tạm biệt");
        map.put("love", "Tình Yêu");
        map.put("money", "Tiền");
    }

    public String find(String name) {
        String result = this.map.get(name);
        if (result == null) {
            result = "Không có từ này ";
        }
        return result;
    }
}
