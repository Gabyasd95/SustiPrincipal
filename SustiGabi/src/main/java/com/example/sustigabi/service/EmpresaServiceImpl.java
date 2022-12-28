package com.example.sustigabi.service;

import com.example.sustigabi.dto.EmpresaDTO;
import com.example.sustigabi.model.Empresa;
import com.example.sustigabi.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaServiceImpl implements EmpresaService{

    @Autowired
    private EmpresaRepository repository;

    @Override
    public List<EmpresaDTO> listar() {

        List<EmpresaDTO> listadto = new ArrayList<>();
        EmpresaDTO dto = null;

        for (Empresa empresa : repository.findAll()) {
            dto = new EmpresaDTO();
            dto.setIdEmpresa(empresa.getIdEmpresa());
            dto.setRazonSocial(empresa.getRazonSocial());
            dto.setRUC(empresa.getRUC());
            dto.setDireccion(empresa.getDireccion());

            listadto.add(dto);
        }

        return listadto;
    }

    @Override
    public EmpresaDTO obtenerId(Integer id) {

        Empresa empresa = repository.findById(id).orElse(null);

        EmpresaDTO dto = new EmpresaDTO();

        dto.setIdEmpresa(empresa.getIdEmpresa());
        dto.setRazonSocial(empresa.getRazonSocial());
        dto.setRUC(empresa.getRUC());
        dto.setDireccion(empresa.getDireccion());

        return dto;
    }

    @Override
    public void guardar(EmpresaDTO empresa) {

        Empresa empresa1 = new Empresa();
        empresa1.setIdEmpresa(empresa.getIdEmpresa());
        empresa1.setRazonSocial(empresa.getRazonSocial());
        empresa1.setRUC(empresa.getRUC());
        empresa1.setDireccion(empresa.getDireccion());

        repository.save(empresa1);

    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void actualizar(EmpresaDTO empresa) {
        Empresa empresa2 = new Empresa();
        empresa2.setIdEmpresa(empresa.getIdEmpresa());
        empresa2.setRazonSocial(empresa.getRazonSocial());
        empresa2.setRUC(empresa.getRUC());
        empresa2.setDireccion(empresa.getDireccion());

        repository.save(empresa2);

    }
}
