package com.example.sustigabi.service;

import com.example.sustigabi.dto.EmpresarioDTO;
import com.example.sustigabi.model.Empresario;
import com.example.sustigabi.repository.EmpresarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresarioServiceImpl implements EmpresarioService{

    @Autowired
    private EmpresarioRepository repository;

    @Override
    public List<EmpresarioDTO> listar() {
        List<EmpresarioDTO> listadto = new ArrayList<>();
        EmpresarioDTO dto = null;

        for (Empresario empresario : repository.findAll()) {
            dto = new EmpresarioDTO();
            dto.setIdEmpresario(empresario.getIdEmpresario());
            dto.setNombre(empresario.getNombre());
            dto.setApellido(empresario.getApellido());
            dto.setCelular(empresario.getCelular());

            listadto.add(dto);
        }

        return listadto;
    }

    @Override
    public EmpresarioDTO obtenerId(Integer id) {

        Empresario empresario = repository.findById(id).orElse(null);

        EmpresarioDTO dto = new EmpresarioDTO();
        dto.setIdEmpresario(empresario.getIdEmpresario());
        dto.setNombre(empresario.getNombre());
        dto.setApellido(empresario.getApellido());
        dto.setCelular(empresario.getCelular());

        return dto;
    }

    @Override
    public void guardar(EmpresarioDTO empresario) {

        Empresario empresario1 = new Empresario();

        empresario1.setIdEmpresario(empresario.getIdEmpresario());
        empresario1.setNombre(empresario.getNombre());
        empresario1.setApellido(empresario.getApellido());
        empresario1.setCelular(empresario.getCelular());

        repository.save(empresario1);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void actualizar(EmpresarioDTO empresario) {

        Empresario empresario2 = new Empresario();

        empresario2.setIdEmpresario(empresario.getIdEmpresario());
        empresario2.setNombre(empresario.getNombre());
        empresario2.setApellido(empresario.getApellido());
        empresario2.setCelular(empresario.getCelular());

        repository.saveAndFlush(empresario2);

    }
}
