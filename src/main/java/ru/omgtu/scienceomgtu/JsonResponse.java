package ru.omgtu.scienceomgtu;

import lombok.Data;
import org.springframework.stereotype.Component;
import ru.omgtu.scienceomgtu.model.*;

@Component
@Data
public class JsonResponse {
    private Publication publication;

    private PublicationAuthors[] publicationAuthors;

    private Keyword[] keywords;

    private PublicationLink[] publicationLinks;

}
