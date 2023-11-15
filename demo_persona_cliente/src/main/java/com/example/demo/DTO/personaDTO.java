package com.example.demo.DTO;

import com.example.demo.Constants.statusCliente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "Persona")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class personaDTO {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "direction")
    private String direction;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "status")
    private String status;
}
