package com.example.classwork;

import com.example.classwork.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pets")
public class PetController {
    private final PetService petService;

    @GetMapping
    public String getPets(){
        return petService.getAllPets().toString();
    }

    /**
     *
     * @param id первичный ключ объекта из таблицы Pet
     * @return список друзей объекта Pet
     */
    @GetMapping("/{id}/friends")
    public String getFriends(@PathVariable Long id){
        return petService.getFriends(id).toString();
    }

    @GetMapping("/hands")
    public boolean isTheorticFriends(@RequestParam(name = "frnd1") Long id,@RequestParam(name="frnd2") Long anthId,
                                    @RequestParam(name="hands") Long hands){
        return petService.isTheoreticFriedns(id,anthId,hands);
    }

}
