package com.example.classwork.service;

import com.example.classwork.entity.Pet;
import com.example.classwork.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;

    public List<Pet> getAllPets(){
        return petRepository.findAll();
    }

    public List<Pet> getFriends(Long id){
        Optional<Pet> byId = petRepository.findById(id);
        if (byId.isPresent())
            return byId.get().getFriendList();
        return null;
    }

    public boolean isTheoreticFriedns(Long id, Long anthId, Long hands) {
        Optional<Pet> pet=petRepository.findById(id);
        Optional<Pet> anthPet=petRepository.findById(anthId);
        if (pet.isEmpty() || anthPet.isEmpty())
            return false;
        else{
            return findInGraph(pet.get(),anthPet.get().getId(),hands);
        }
    }

    //в лоб
    private boolean findInGraph(Pet pet, Long id,Long hands) {
        if (pet.getFriendList().size()==0)
            return false;
        Stream<Pet> petStream=null;
       for (int i=0; i<hands; i++){
           petStream=petStream==null?pet.getFriendList().stream():petStream.flatMap(x->{
              if (x.getFriendList().size()!=0)
                return x.getFriendList().stream();
              else
                  return Stream.empty();
           });
           Optional<Pet> first = petStream.filter(p -> p.getId() == id).findFirst();
           if (first.isPresent())
               return true;
       }
       return false;
    }
}
