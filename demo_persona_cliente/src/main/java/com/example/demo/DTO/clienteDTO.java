package com.example.demo.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "cliente")
public class clienteDTO extends personaDTO{

    @Column(name = "identification")
    private String identification;

    @Column(name = "password")
    private String password;

    public clienteDTO() {
    }

    public clienteDTO(String identification, String password) {

        this.identification = identification;
        this.password = password;
    }

}
