package ru.omgtu.scienceomgtu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import ru.omgtu.scienceomgtu.model.Publication;
import ru.omgtu.scienceomgtu.model.PublicationLink;
import ru.omgtu.scienceomgtu.model.PublicationLinkType;

import java.util.List;

@Repository
public interface PublicationLinkRepository extends JpaRepository<PublicationLink, Integer> {
    
    PublicationLink findPublicationLinkByPublicationAndLinkType(Publication publication, PublicationLinkType publicationLinkType);
}
