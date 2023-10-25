package com.example.demo.Domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "Persona")
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Persona {

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
    private Integer status;

}
