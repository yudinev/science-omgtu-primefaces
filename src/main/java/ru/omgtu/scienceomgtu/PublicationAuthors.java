package ru.omgtu.scienceomgtu;

import lombok.Data;
import org.springframework.stereotype.Component;
import ru.omgtu.scienceomgtu.model.Author;
import ru.omgtu.scienceomgtu.model.Organization;

@Component
@Data
public class PublicationAuthors {

    private Author authors;

    private Organization organization;

}
