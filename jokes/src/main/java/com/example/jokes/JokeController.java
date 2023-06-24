package com.example.jokes;

import com.example.jokes.dto.JokeDTO;
import com.example.jokes.entities.Joke;
import com.example.jokes.entities.JokeInfo;
import com.example.jokes.repository.JokeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/jokes")
public class JokeController implements IJokeController{

    private final JokeRepository jokeRepository;

    JokeController(JokeRepository jokeRepository) {
        this.jokeRepository = jokeRepository;
    }


    @Override
    public ResponseEntity<JokeInfo> getRandomJoke() {

        Long id = Math.round(Math.random() * jokeRepository.count());
        //find one random joke
        if (existsById(id)) {
            return ResponseEntity.ok(jokeRepository.findJokeById(id));
        } else {
            return getRandomJoke();
        }
    }

    private boolean existsById(Long id) {
        return jokeRepository.existsById(id);
    }

    @Override
    public ResponseEntity<Joke> createJoke(JokeDTO joke) {
        Joke newJoke = new Joke();
        BeanUtils.copyProperties(joke, newJoke);
        return ResponseEntity.ok(jokeRepository.save(newJoke));
    }
}
