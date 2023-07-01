package ru.omgtu.scienceomgtu.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "source_rating_type")
@Data
public class SourceRatingType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

//    @Lob
    @Column(name = "name", nullable = false)
    private String name;
}