package ru.omgtu.scienceomgtu.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.omgtu.scienceomgtu.model.Publication;
import ru.omgtu.scienceomgtu.service.PublicationService;

@Controller
public class PublicationController {

    @Autowired
    private PublicationService publicationService;

    @GetMapping("/publications")
    public ModelAndView getAllPublications(ModelAndView modelAndView) {

        return modelAndView;
    }

    @GetMapping("/publication/{id}")
    public ModelAndView getPublication(ModelAndView modelAndView, @PathVariable Integer id) {
        modelAndView.addObject("publication", publicationService.getPublicationById(id));
        modelAndView.setViewName("publication");

        return modelAndView;
    }
}
