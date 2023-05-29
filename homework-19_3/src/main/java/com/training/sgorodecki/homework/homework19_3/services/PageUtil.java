package com.training.sgorodecki.homework.homework19_3.services;

import com.training.sgorodecki.homework.homework19_3.entity.Good;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PageUtil {

    private PageUtil() {
    }

    public static String makeNumberedList(List<Good> list) {
        return list.stream()
                .map(good -> "<li>" + good.toString() + "</li>")
                .collect(Collectors.joining());
    }

    public static String makeDropDownList(Map<Integer, Good> goods) {
        return goods.entrySet().stream()
                .map(entry -> "<option name=\"id\" value=" + entry.getKey() + ">" + entry.getValue().toString() + "</option>")
                .collect(Collectors.joining());
    }
}
