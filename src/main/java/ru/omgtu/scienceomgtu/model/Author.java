package ru.omgtu.scienceomgtu.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "author")
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

//    @Lob
    @Column(name = "name", nullable = false)
    private String name;

//    @Lob
    @Column(name = "surname", nullable = false)
    private String surname;

//    @Lob
    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "confirmed", nullable = false)
    private Boolean confirmed = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "birthday")
    private LocalDate birthday;
}