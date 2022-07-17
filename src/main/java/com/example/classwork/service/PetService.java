package com.example.classwork.service;

import com.example.classwork.entity.Cat;
import com.example.classwork.entity.Dog;
import com.example.classwork.entity.Pet;
import com.example.classwork.entity.Snake;
import com.example.classwork.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;

    public List<Pet> getAllPets(){
        return petRepository.findAll();
    }

}
