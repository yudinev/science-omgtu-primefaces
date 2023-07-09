package ru.omgtu.scienceomgtu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.omgtu.scienceomgtu.model.*;
import ru.omgtu.scienceomgtu.repository.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;

    @Autowired
    private AuthorPublicationRepository authorPublicationRepository;

    @Autowired
    private PublicationLinkRepository publicationLinkRepository;

    @Autowired
    private AuthorPublicationOrganizationRepository authorPublicationOrganizationRepository;

    @Autowired
    private KeywordsPublicationRepository keywordsPublicationRepository;

    public Page<Publication> findPublicationsWithPagination(int offset, int pageSize) {
        Page<Publication> publicationsPage = publicationRepository.findAll(PageRequest.of(offset - 1, pageSize));

        for (int i = 0; i < publicationsPage.getSize(); i++) {
            List<Author> authors = getAuthorList(publicationsPage.getContent().get(i));
            publicationsPage.getContent().get(i).setAuthorList(authors);
        }

        return publicationsPage;
    }

    public Publication getPublicationById(Integer id) {
        Publication publication = publicationRepository.findPublicationById(id);

        publication.setAuthorList(getAuthorList(publication));
        publication.setKeywords(getKeywords(publication));

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
            List<Author> authors = getAuthorList(publications.get(i));
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

    private List<Author> getAuthorList(Publication publication) {
        List<Author> authors = new ArrayList<>();
        List<AuthorPublication> authorPublications = new ArrayList<>(authorPublicationRepository.findAuthorPublicationsByPublication(publication));

        for (AuthorPublication authorPublication : authorPublications) {
            Author author = authorPublication.getAuthor();
            List<AuthorPublicationOrganization> authorPublicationOrganizations
                    = authorPublicationOrganizationRepository.findAuthorPublicationOrganizationsByAuthorPublication(authorPublication);

            List<Organization> organizations = new ArrayList<>();
            for (AuthorPublicationOrganization authorPublicationOrganization : authorPublicationOrganizations)
                organizations.add(authorPublicationOrganization.getOrganization());

            author.setOrganizations(organizations);

            StringBuilder orgs = new StringBuilder();
            for (Organization organization : organizations) {
                orgs.append("(").append(organization.getName()).append(") ");
            }
            author.setOrganizations_text(orgs.toString());
            authors.add(author);
        }

        return authors;
    }

    private String getKeywords(Publication publication) {
        List<KeywordsPublication> keywordsPublications = keywordsPublicationRepository.findKeywordsPublicationsByPublication(publication);
        List<Keyword> keywordsList = new ArrayList<>();

        for (KeywordsPublication keywordsPublication : keywordsPublications) {
            keywordsList.add(keywordsPublication.getKeyword());
        }

        StringBuilder keywords = new StringBuilder();

        for (int i = 0; i < keywordsList.size(); i++) {
            if (i == keywordsList.size() - 1) {
                keywords.append(keywordsList.get(i).getKeyword());
            } else {
                keywords.append(keywordsList.get(i).getKeyword()).append(", ");
            }
        }

        return keywords.toString();
    }
}
