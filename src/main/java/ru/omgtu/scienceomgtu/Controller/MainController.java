package ru.omgtu.scienceomgtu.Controller;


import com.google.gson.Gson;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.omgtu.scienceomgtu.JsonResponse;
import ru.omgtu.scienceomgtu.model.Author;
import ru.omgtu.scienceomgtu.model.Organization;
import ru.omgtu.scienceomgtu.repository.AuthorRepository;
import ru.omgtu.scienceomgtu.repository.OrganizationRepository;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private OrganizationRepository organizationRepository;

    @GetMapping("/authors")
    public List<Author> authors() {
        return authorRepository.findAll();
    }

    @GetMapping("/author/{id}")
    public String authorById(@PathVariable Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        String jsonString = restTemplate.getForObject("https://science.omgtu.ru/api/author/" + id, String.class);

        Gson gson = new Gson();
        JsonResponse jsonResponse = gson.fromJson(jsonString, JsonResponse.class);

        return jsonString;
    }

    @GetMapping("/organizations")
    public List<Organization> organizations() {
        return organizationRepository.findAll();
    }
}
