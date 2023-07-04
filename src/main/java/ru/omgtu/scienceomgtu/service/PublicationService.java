package ru.omgtu.scienceomgtu.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.omgtu.scienceomgtu.model.*;
import ru.omgtu.scienceomgtu.repository.AuthorPublicationRepository;
import ru.omgtu.scienceomgtu.repository.PublicationLinkRepository;
import ru.omgtu.scienceomgtu.repository.PublicationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;

    @Autowired
    private AuthorPublicationRepository authorPublicationRepository;

    @Autowired
    private PublicationLinkRepository publicationLinkRepository;

    public Publication getPublicationById(Integer id) {
        Publication publication = publicationRepository.findPublicationById(id);

        String doi = getLink(publication, new PublicationLinkType(1, "DOI"));
        String scopus = getLink(publication, new PublicationLinkType(2, "Scopus"));
        String elibrary = getLink(publication, new PublicationLinkType(3, "Elibrary"));

        if (doi != null) publication.setDoi(doi);
        if (scopus != null) publication.setScopusLink(scopus);
        if (elibrary != null) publication.setElibrary(elibrary);

        return publication;
    }

    public List<Publication> getTop20Publications() {
        List<Publication> publications = publicationRepository.findTop20ByOrderByPublicationDateDesc();

        for (int i = 0; i < publications.size(); i++) {
            Publication publication = publications.get(i);
            List<Author> authors = new ArrayList<>();
            List<AuthorPublication> authorPublications = new ArrayList<>(authorPublicationRepository.findAuthorPublicationsByPublication(publication));

            for (AuthorPublication authorPublication : authorPublications)
                authors.add(authorPublication.getAuthor());
            publications.get(i).setAuthorList(authors);
        }
        return publications;
    }

    private String getLink(Publication publication, PublicationLinkType publicationLinkType) {
        String str = null;
        try {
            str = publicationLinkRepository.findPublicationLinkByPublicationAndLinkType(publication, publicationLinkType).getLink();
        } catch (NullPointerException e) {}

        return str;
    }
}
