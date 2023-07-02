package ru.omgtu.scienceomgtu.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.omgtu.scienceomgtu.model.Publication;
import ru.omgtu.scienceomgtu.repository.PublicationRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;

    public Publication getPublicationById(Integer id) {
        return publicationRepository.findPublicationById(id);
    }

    public List<Publication> getTop20Publications() {
        return publicationRepository.findTop20ByOrderByPublicationDate();
    }
}
