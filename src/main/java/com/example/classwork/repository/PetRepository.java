package com.example.classwork.repository;

import com.example.classwork.entity.Pet;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {

    @Override
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
            attributePaths ={"friendList"} )
    Optional<Pet> findById(Long aLong);

}
