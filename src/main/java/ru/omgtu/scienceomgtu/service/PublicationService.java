package ru.omgtu.scienceomgtu.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.omgtu.scienceomgtu.model.Publication;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicationService {

    public Publication getPublicationById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();

        Gson gson = new Gson();
        String str = gson.fromJson("https://science.omgtu.ru/api/publication/" + id, String.class);
        Publication publication = gson.fromJson(str, Publication.class);

//        Publication publication =
//                (Publication) restTemplate.getForObject("https://science.omgtu.ru/api/publication/" + id, List.class).get(0);
        return publication;
    }
}
