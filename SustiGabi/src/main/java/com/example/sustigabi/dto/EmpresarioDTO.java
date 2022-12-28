package com.example.sustigabi.dto;

import lombok.Data;

import javax.persistence.*;

@Data
public class EmpresarioDTO {

    private Integer idEmpresario;
    private String nombre;
    private String apellido;
    private Integer celular;
}
