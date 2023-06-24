package com.example.jokes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JokeDTO {

    @NotBlank(message = "Joke description cannot be blank")
    private String jokeDescription;
}
