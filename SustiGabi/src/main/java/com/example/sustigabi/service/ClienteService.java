package com.example.sustigabi.service;


import com.example.sustigabi.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {

    List<ClienteDTO>listar();
    ClienteDTO obtenerId(Integer id);
    void guardar(ClienteDTO cliente);
    void eliminar(Integer id);
    void actualizar(ClienteDTO cliente);
}
