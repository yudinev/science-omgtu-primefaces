package ru.omgtu.scienceomgtu.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "publication_link")
@Data
public class PublicationLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "publication_id", nullable = false)
    private Publication publication;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "link_type_id", nullable = false)
    private PublicationLinkType linkType;

//    @Lob
    @Column(name = "link", nullable = false)
    private String link;
}