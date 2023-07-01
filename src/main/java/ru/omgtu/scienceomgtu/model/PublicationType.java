package ru.omgtu.scienceomgtu.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "publication_type")
@Data
public class PublicationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

//    @Lob
    @Column(name = "name", nullable = false)
    private String name;
}