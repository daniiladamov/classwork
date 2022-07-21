package com.example.classwork.service;

import com.example.classwork.entity.Cat;
import com.example.classwork.entity.Cat_;
import com.example.classwork.entity.Pet;
import com.example.classwork.entity.Pet_;
import com.example.classwork.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PetService {
    @PersistenceContext
    private final EntityManager entityManager;
    private final PetRepository petRepository;

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public List<Pet> getFriends(Long id) {
        Optional<Pet> byId = petRepository.findById(id);
        if (byId.isPresent())
            return byId.get().getFriendList();
        return null;
    }

//    public boolean isTheoreticFriedns(Long id, Long anthId, Long hands) {
//
//    }

    public List<String> findCatByColor(Long count) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createTupleQuery();
        Root<Cat> pet = cq.from(Cat.class);
        cq.select(cb.tuple(pet.get("color"),cb.count(pet)));
        cq.groupBy(pet.get(Cat_.color));
        cq.having(cb.greaterThan(cb.count(pet),count));
        cq.orderBy(cb.desc(cb.count(pet)));
        List<Tuple> resultQuerry=entityManager.createQuery(cq).getResultList();
        List<String>result=new ArrayList<>();
        for (Tuple tuple:resultQuerry){
            result.add(tuple.get(0)+":"+tuple.get(1));
        }
        return result;
    }

    public Pet maxFriends() {
        Pet p=null;
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createTupleQuery();
        Root<Pet> pet = cq.from(Pet.class);
        Join<Pet, List<Pet>> friends= pet.join(Pet_.friendList, JoinType.LEFT);
        cq.select(cb.tuple(pet,cb.count(friends)));
        cq.orderBy(cb.desc(cb.count(friends)));
        Tuple singleResult = entityManager.createQuery(cq).getSingleResult();
        p= (Pet) singleResult.get(0);
        return p;
    }
}
