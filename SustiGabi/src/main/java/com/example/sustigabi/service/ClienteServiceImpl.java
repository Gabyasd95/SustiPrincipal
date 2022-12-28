package com.example.sustigabi.service;

import com.example.sustigabi.dto.ClienteDTO;
import com.example.sustigabi.model.Cliente;
import com.example.sustigabi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<ClienteDTO> listar() {

        List<ClienteDTO> listadto = new ArrayList<>();
        ClienteDTO dto = null;

        for (Cliente cliente : repository.findAll()) {
            dto = new ClienteDTO();
            dto.setIdCliente(cliente.getIdCliente());
            dto.setNombre(cliente.getNombre());
            dto.setApellido(cliente.getApellido());
            listadto.add(dto);
        }

        return listadto;
    }

    @Override
    public ClienteDTO obtenerId(Integer id) {

        Cliente cliente = repository.findById(id).orElse(null);

        ClienteDTO dto = new ClienteDTO();
        dto.setIdCliente(cliente.getIdCliente());
        dto.setNombre(cliente.getNombre());
        dto.setApellido(cliente.getApellido());
        return dto;
    }

    @Override
    public void guardar(ClienteDTO cliente) {

        Cliente cli = new Cliente();
        cli.setIdCliente(cliente.getIdCliente());
        cli.setNombre(cliente.getNombre());
        cli.setApellido(cliente.getApellido());

        repository.save(cli);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void actualizar(ClienteDTO cliente) {

        Cliente cli = new Cliente();
        cli.setIdCliente(cliente.getIdCliente());
        cli.setNombre(cliente.getNombre());
        cli.setApellido(cliente.getApellido());

        repository.saveAndFlush(cli);
    }
}
