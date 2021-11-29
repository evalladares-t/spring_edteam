package com.edteam.curso.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(columnDefinition = "DATE", updatable = false, nullable = false)
    protected Date createdDate;

    @Column(columnDefinition = "DATE", updatable = false, nullable = false)
    protected Date updatedDate;

    @PrePersist
    protected void onCreate(){
        updatedDate = new Date();
        if (createdDate == null){
            createdDate = new Date();
        }
    }
}
