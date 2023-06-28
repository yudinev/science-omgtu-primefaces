package ru.omgtu.scienceomgtu.model;

import javax.persistence.*;

@Entity
@Table(name = "publication_link")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public PublicationLinkType getLinkType() {
        return linkType;
    }

    public void setLinkType(PublicationLinkType linkType) {
        this.linkType = linkType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}