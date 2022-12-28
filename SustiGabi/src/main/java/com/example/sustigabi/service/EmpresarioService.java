package com.example.sustigabi.service;

import com.example.sustigabi.dto.EmpresarioDTO;

import java.util.List;

public interface EmpresarioService {

    List<EmpresarioDTO> listar();
    EmpresarioDTO obtenerId(Integer id);
    void guardar(EmpresarioDTO empresario);
    void eliminar(Integer id);
    void actualizar(EmpresarioDTO empresario);
}
