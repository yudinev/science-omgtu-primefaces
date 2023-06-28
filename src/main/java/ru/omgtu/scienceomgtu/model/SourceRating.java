package ru.omgtu.scienceomgtu.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "source_rating")
public class SourceRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "source_id", nullable = false)
    private Source source;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "source_rating_type_id", nullable = false)
    private SourceRatingType sourceRatingType;

//    @Lob
    @Column(name = "rating", nullable = false)
    private String rating;

    @Column(name = "rating_date", nullable = false)
    private LocalDate ratingDate;

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

    public SourceRatingType getSourceRatingType() {
        return sourceRatingType;
    }

    public void setSourceRatingType(SourceRatingType sourceRatingType) {
        this.sourceRatingType = sourceRatingType;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public LocalDate getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(LocalDate ratingDate) {
        this.ratingDate = ratingDate;
    }

}