package com.example.sustigabi.model;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    private String nombre;
    private String apellido;

    @ManyToMany ( cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name="cliente_empresa",
            joinColumns = @JoinColumn(
                    name="id_empresa",
                    nullable = false,
                    unique = true,
                    foreignKey =  @ForeignKey(foreignKeyDefinition = "foreign key (id_empresa) references empresas(id_empresa)")
            ),

            inverseJoinColumns = @JoinColumn(
                    name="id_cliente",
                    nullable = false,
                    unique = true,
                    foreignKey =  @ForeignKey(foreignKeyDefinition = "foreign key (id_cliente) references clientes(id_cliente)")
            )
    )

    private List<Empresa> empresas = new ArrayList<>();

}
