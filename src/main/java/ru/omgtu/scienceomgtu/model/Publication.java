package ru.omgtu.scienceomgtu.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "publication")
@Data
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "type_id", nullable = false)
    private PublicationType type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "source_id", nullable = false)
    private Source source;

//    @Lob
    @Column(name = "title", nullable = false)
    private String title;

//    @Lob
    @Column(name = "abstract")
    private String abstractField;

    @Column(name = "publication_date", nullable = false)
    private LocalDate publicationDate;

    @Column(name = "accepted", nullable = false)
    private Boolean accepted = false;

    @Transient
    private List<Author> authorList;

    @Transient
    private String scopusLink;

    @Transient
    private String doi;

    @Transient
    private String elibrary;
}