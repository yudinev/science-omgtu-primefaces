package ru.omgtu.scienceomgtu.model;

import javax.persistence.*;

@Entity
@Table(name = "source_link")
public class SourceLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "source_id", nullable = false)
    private Source source;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "source_link_type_id", nullable = false)
    private SourceLinkType sourceLinkType;

//    @Lob
    @Column(name = "link", nullable = false)
    private String link;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public SourceLinkType getSourceLinkType() {
        return sourceLinkType;
    }

    public void setSourceLinkType(SourceLinkType sourceLinkType) {
        this.sourceLinkType = sourceLinkType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}