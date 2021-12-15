package com.example.proyectoJavaDev.repository;

import com.example.proyectoJavaDev.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

    EmployeeEntity findByEmployeeId(Integer employeeId);

    List<EmployeeEntity> findByStatus(String status);

}
