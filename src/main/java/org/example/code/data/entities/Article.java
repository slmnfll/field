package org.example.code.data.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Article {
    private static int counter;
    private int id;
    private String label;
    private int stock;
    private final List<Detail> detailList = new ArrayList<>();

    public Article() {
        id = ++counter;
    }

    public void addDetail(Detail detail) {
        detailList.add(detail);
    }
}