package ru.omgtu.scienceomgtu.model;

import ru.omgtu.scienceomgtu.model.AuthorPublication;
import ru.omgtu.scienceomgtu.model.Organization;

import javax.persistence.*;

@Entity
@Table(name = "author_publication_organization")
public class AuthorPublicationOrganization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_publication_id", nullable = false)
    private AuthorPublication authorPublication;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AuthorPublication getAuthorPublication() {
        return authorPublication;
    }

    public void setAuthorPublication(AuthorPublication authorPublication) {
        this.authorPublication = authorPublication;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

}