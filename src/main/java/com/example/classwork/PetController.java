package com.example.classwork;

import com.example.classwork.entity.Pet;
import com.example.classwork.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Tuple;
import java.util.List;
import java.util.stream.Collectors;

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

//    @GetMapping("/hands")
//    public boolean isTheorticFriends(@RequestParam(name = "frnd1") Long id,@RequestParam(name="frnd2") Long anthId,
//                                    @RequestParam(name="hands") Long hands){
//        return petService.isTheoreticFriedns(id,anthId,hands);
//    }

    /**
     * Ендпоинт вывода кошек по цветам
     * @param count ограничение по сортировке (считаются только цвета, которых больше count)
     * @return список кошек, сгрупированный по цветам, отсортированный в порядке убывания
     */
    @GetMapping("/cats")
    public String getCats(@RequestParam(name = "sort") Long count){
        return petService.findCatByColor(count).stream().collect(Collectors.joining("\n"));
    }

    @GetMapping("/max-friends")
    public Pet getPetWithMaxFriends(){
        return petService.maxFriends();
    }

}
