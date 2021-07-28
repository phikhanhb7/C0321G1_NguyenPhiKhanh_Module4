package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter

public class Counter {
    private int count;

    public int increment() {
        return count++;
    }

    public Counter() {
    }

}
