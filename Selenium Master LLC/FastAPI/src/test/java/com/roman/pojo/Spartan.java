package com.roman.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(value="id",allowSetters = true)
@Getter
@Setter
@ToString

public class Spartan {

    private int id;
    private String name;
    private String gender;
    private long phone;


}
