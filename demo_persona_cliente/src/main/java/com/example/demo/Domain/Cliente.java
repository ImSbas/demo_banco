package com.example.demo.Domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
public class Cliente extends Persona{

    @Column(name = "identification")
    private String identification;

    @Column(name = "password")
    private String password;

    public Cliente() {
    }

    public Cliente(String identification, String password) {

        this.identification = identification;
        this.password = password;
    }
}
