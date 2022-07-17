package com.example.classwork.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("snake")
public class Snake extends Pet{
    private int length;
}
