package com.example.classwork.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Cat.class)
public class Cat_ extends Pet_{
    public static volatile SingularAttribute<Cat, String> hair;
    public static volatile SingularAttribute<Cat, String> color;
}
