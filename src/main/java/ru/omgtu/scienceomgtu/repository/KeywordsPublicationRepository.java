package ru.omgtu.scienceomgtu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.omgtu.scienceomgtu.model.KeywordsPublication;
import ru.omgtu.scienceomgtu.model.Publication;

import java.util.List;

@Repository
public interface KeywordsPublicationRepository extends JpaRepository<KeywordsPublication, Integer> {
    List<KeywordsPublication> findKeywordsPublicationsByPublication(Publication publication);
}
