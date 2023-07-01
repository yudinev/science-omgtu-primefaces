package ru.omgtu.scienceomgtu.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "organization")
@Data
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

//    @Lob
    @Column(name = "name", nullable = false)
    private String name;

//    @Lob
    @Column(name = "country")
    private String country;

//    @Lob
    @Column(name = "city")
    private String city;
}