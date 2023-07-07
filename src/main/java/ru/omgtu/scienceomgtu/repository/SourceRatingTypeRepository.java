package ru.omgtu.scienceomgtu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.omgtu.scienceomgtu.model.SourceRatingType;

@Repository
public interface SourceRatingTypeRepository extends JpaRepository<SourceRatingType, Integer> {

}
