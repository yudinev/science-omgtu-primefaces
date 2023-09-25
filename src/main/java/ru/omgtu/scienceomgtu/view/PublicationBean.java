package ru.omgtu.scienceomgtu.view;

import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Faces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import ru.omgtu.scienceomgtu.model.Publication;
import ru.omgtu.scienceomgtu.service.PublicationService;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.io.Serializable;
@Named(value = "publicationBean")
@Scope("view")
@Getter
@Setter
public class PublicationBean implements Serializable {
    @Autowired
    private PublicationService publicationService;

    private Publication publication;
    @PostConstruct
    public void init() {
        Integer id = idFromParam();
        publication=publicationService.getPublicationById(id);

    }

    private Integer idFromParam() {
        String longStr = Faces.getExternalContext().getRequestParameterMap().get("Id");
        try {
            return Integer.parseInt(longStr);
        } catch (Exception e) {
            throw new NullPointerException("Параметр не найден");
        }
    }
}
