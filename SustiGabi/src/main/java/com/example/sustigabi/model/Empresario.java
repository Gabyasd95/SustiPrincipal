package com.example.sustigabi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "empresarios")
public class Empresario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpresario;
    private String nombre;
    private String apellido;
    private Integer celular;

    @ManyToMany(mappedBy = "empresarios")
    private List<Empresa> empresa = new ArrayList<>();

}
