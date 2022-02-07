package ru.gb.spring1.classwork.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Product {

    int id;

    String name;

    double price;


}
