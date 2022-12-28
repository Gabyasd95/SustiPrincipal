package com.example.sustigabi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "empresas")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpresa;
    private String razonSocial;
    private String RUC;
    private String direccion;

    @ManyToMany ( cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name="intermedio",
            joinColumns = @JoinColumn(
                    name="id_empresa",
                    nullable = false,
                    unique = true,
                    foreignKey =  @ForeignKey(foreignKeyDefinition = "foreign key (id_empresa) references empresas(id_empresa)")
            ),

            inverseJoinColumns = @JoinColumn(
                    name="id_empresario",
                    nullable = false,
                    unique = true,
                    foreignKey =  @ForeignKey(foreignKeyDefinition = "foreign key (id_empresario) references empresarios(id_empresario)")
            )
    )

    private List<Empresario> empresarios = new ArrayList<>();

    @ManyToMany(mappedBy = "empresas")
    private List<Cliente> cliente = new ArrayList<>();
}
