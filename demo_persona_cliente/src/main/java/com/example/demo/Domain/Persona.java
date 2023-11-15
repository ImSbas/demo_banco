package com.example.demo.Domain;


import com.example.demo.Constants.statusCliente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Persona {
    private Integer id;
    private String name;
    private String gender;
    private String dateOfBirth;
    private String direction;
    private String telephone;
    private statusCliente status;

}
