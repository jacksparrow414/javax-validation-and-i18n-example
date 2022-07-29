package com.example.validation.vo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class Person {

    @NotBlank
    private String userName;

    @Range(max = 15, min = 5)
    private Integer userAge;
}
