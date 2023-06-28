package ru.omgtu.scienceomgtu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.omgtu.scienceomgtu.model.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

}
