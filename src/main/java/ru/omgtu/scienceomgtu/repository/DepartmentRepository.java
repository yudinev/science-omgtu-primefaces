package ru.omgtu.scienceomgtu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.omgtu.scienceomgtu.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
