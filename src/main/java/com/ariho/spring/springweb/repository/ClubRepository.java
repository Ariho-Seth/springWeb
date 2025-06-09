package com.ariho.spring.springweb.repository;

import com.ariho.spring.springweb.models.Club;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClubRepository extends CrudRepository<Club, Long> {
    Optional<Club> findByTitle(String url);

}
