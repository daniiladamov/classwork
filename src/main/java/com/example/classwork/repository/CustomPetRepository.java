package com.example.classwork.repository;

import com.example.classwork.entity.Pet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomPetRepository{
    @PersistenceContext
    private final EntityManager entityManager;

    public List<Pet> findAllFriends(Pet pet){
        List<Pet> petList=new ArrayList<>();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery(Pet.class);
        Root root = query.from(Pet.class);

        return petList;
    }
}
