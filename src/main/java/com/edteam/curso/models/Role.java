package com.edteam.curso.models;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends BaseEntity{

    @Getter @Setter @Column(name = "nombre")
    private String nombre;
    @Getter @Setter @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, mappedBy = "role")
    private Set<Permiso> permisos;

}
