package ru.omgtu.scienceomgtu.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "feedback")
@Data
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

//    @Lob
    @Column(name = "name", nullable = false)
    private String name;

//    @Lob
    @Column(name = "mail", nullable = false)
    private String mail;

//    @Lob
    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "solved", nullable = false)
    private Boolean solved = false;
}