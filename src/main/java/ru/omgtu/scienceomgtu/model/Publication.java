package ru.omgtu.scienceomgtu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "publication")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonProperty("id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "type_id", nullable = false)
    @JsonProperty("publication_type")
    private PublicationType type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "source_id", nullable = false)
    @JsonProperty("source")
    private Source source;

//    @Lob
    @Column(name = "title", nullable = false)
    @JsonProperty("title")
    private String title;

//    @Lob
    @Column(name = "abstract")
    @JsonProperty("abstract")
    private String abstractField;

    @Column(name = "publication_date", nullable = false)
    @JsonProperty("publication_date")
    private LocalDate publicationDate;

    @Column(name = "accepted", nullable = false)
    @JsonProperty("accepted")
    private Boolean accepted = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PublicationType getType() {
        return type;
    }

    public void setType(PublicationType type) {
        this.type = type;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstractField() {
        return abstractField;
    }

    public void setAbstractField(String abstractField) {
        this.abstractField = abstractField;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "id=" + id +
                ", type=" + type +
                ", source=" + source +
                ", title='" + title + '\'' +
                ", abstractField='" + abstractField + '\'' +
                ", publicationDate=" + publicationDate +
                ", accepted=" + accepted +
                '}';
    }
}