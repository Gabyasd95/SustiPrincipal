package com.example.sustigabi.service;

import com.example.sustigabi.dto.EmpresaDTO;

import java.util.List;

public interface EmpresaService {

    List<EmpresaDTO> listar();
    EmpresaDTO obtenerId(Integer id);
    void guardar(EmpresaDTO empresa);
    void eliminar(Integer id);
    void actualizar(EmpresaDTO empresa);
}
