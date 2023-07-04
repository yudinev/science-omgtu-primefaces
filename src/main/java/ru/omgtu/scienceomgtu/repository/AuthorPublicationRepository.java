package ru.omgtu.scienceomgtu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.omgtu.scienceomgtu.model.AuthorPublication;
import ru.omgtu.scienceomgtu.model.Publication;

import java.util.List;

@Repository
public interface AuthorPublicationRepository extends JpaRepository<AuthorPublication, Integer> {
    List<AuthorPublication> findAuthorPublicationsByPublication(Publication publication);
}
