package com.example.sustigabi.repository;

import com.example.sustigabi.model.Empresario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresarioRepository extends JpaRepository<Empresario, Integer> {
}
