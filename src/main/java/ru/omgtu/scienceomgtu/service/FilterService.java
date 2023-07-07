package ru.omgtu.scienceomgtu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.omgtu.scienceomgtu.model.Department;
import ru.omgtu.scienceomgtu.model.PublicationType;
import ru.omgtu.scienceomgtu.model.SourceRatingType;
import ru.omgtu.scienceomgtu.repository.DepartmentRepository;
import ru.omgtu.scienceomgtu.repository.PublicationTypeRepository;
import ru.omgtu.scienceomgtu.repository.SourceRatingTypeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilterService {

    @Autowired
    private SourceRatingTypeRepository sourceRatingTypeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private PublicationTypeRepository publicationTypeRepository;

    public List<String> getRatings() {
        List<SourceRatingType> sourceRatingTypes = sourceRatingTypeRepository.findAll();
        List<String> ratings = new ArrayList<>();

        for (SourceRatingType sourceRatingType : sourceRatingTypes) {
            if (!sourceRatingType.getName().equals("")) ratings.add(sourceRatingType.getName());
        }

        return ratings;
    }

    public List<String> getDepartments() {
        List<Department> departments = departmentRepository.findAll();
        List<String> department_strings = new ArrayList<>();

        for (Department department : departments) {
            if (!department.getName().equals(""))department_strings.add(department.getName());
        }

        return department_strings;
    }

    public List<String> getPublicationTypes() {
        List<PublicationType> publicationTypes = publicationTypeRepository.findAll();
        List<String> types = new ArrayList<>();

        for (PublicationType type : publicationTypes) {
            if (!type.getName().equals(""))types.add(type.getName());
        }

        return types;
    }
}
