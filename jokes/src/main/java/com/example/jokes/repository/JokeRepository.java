package com.example.jokes.repository;

import com.example.jokes.entities.Joke;
import com.example.jokes.entities.JokeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JokeRepository extends JpaRepository<Joke, Long> {

    JokeInfo findJokeById(Long id);

    Joke findFirstByOrderByIdDesc();
}
