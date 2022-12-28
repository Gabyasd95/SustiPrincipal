package com.example.sustigabi.repository;

import com.example.sustigabi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
	Usuario findByUsuario(String usuario);
	
}