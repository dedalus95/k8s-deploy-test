package com.example.jokes;

import com.example.jokes.dto.JokeDTO;
import com.example.jokes.entities.Joke;
import com.example.jokes.entities.JokeInfo;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IJokeController {
    @GetMapping("/random")
    ResponseEntity<JokeInfo> getRandomJoke();

    @PostMapping("")
    ResponseEntity<Joke> createJoke(
            @RequestBody @Valid JokeDTO joke);

}
