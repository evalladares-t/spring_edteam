package com.edteam.curso.models;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "permisos")

public class Permiso extends BaseEntity{

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("role_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter @Setter @JoinColumn(name = "role_id")
    private Role role;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Override
    public String toString() {
        return "Permiso{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

}
