package com.example.classwork.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Inheritance
@Table(name = "pet")
@DiscriminatorColumn(name = "pet_type")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @ManyToMany(fetch = FetchType.LAZY)
            @JoinTable(
                    name = "friends",
                    joinColumns = @JoinColumn(name = "id"),
                    inverseJoinColumns = @JoinColumn(name = "friend_id")
            )
    List<Pet> friendList;

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" "+name+" id#"+id;

    }
}
