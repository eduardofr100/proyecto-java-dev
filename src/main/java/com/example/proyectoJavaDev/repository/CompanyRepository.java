package com.example.proyectoJavaDev.repository;

import com.example.proyectoJavaDev.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {
    //CompanyEntity findByCompanyId(Integer companyId);

    Optional<CompanyEntity> findById(Integer integer);
}
