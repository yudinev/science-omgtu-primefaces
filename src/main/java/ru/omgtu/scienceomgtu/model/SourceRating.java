package ru.omgtu.scienceomgtu.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "source_rating")
@Data
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
}