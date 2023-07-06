package ru.omgtu.scienceomgtu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.omgtu.scienceomgtu.model.AuthorPublication;
import ru.omgtu.scienceomgtu.model.AuthorPublicationOrganization;

import java.util.List;

@Repository
public interface AuthorPublicationOrganizationRepository extends JpaRepository<AuthorPublicationOrganization, Integer> {
    List<AuthorPublicationOrganization> findAuthorPublicationOrganizationsByAuthorPublication(AuthorPublication authorPublication);
}
