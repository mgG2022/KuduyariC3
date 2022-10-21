/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kuduyari.kuduyari.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Table // le digo al sistema que se va a pegar a una base de datos
@Entity(name = "receta") //

public class receta implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "codigoReceta")
    private Integer codigoReceta;
    
    @ManyToOne
    @JoinColumn(name="codigoMultimedia")
    private Integer codigoMultimedia;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "ingredientes")
    private String ingredientes;
    
    @Column(name = "preparacion")
    private String preparacion;
    
    @Column(name = "pueblo")
    private String pueblo;
    
    @Column(name = "comunidad")
    private String comunidad;

    public Integer getCodigoReceta() {
        return codigoReceta;
    }

    public void setCodigoReceta(Integer codigoReceta) {
        this.codigoReceta = codigoReceta;
    }

    public Integer getCodigoMultimedia() {
        return codigoMultimedia;
    }

    public void setCodigoMultimedia(Integer codigoMultimedia) {
        this.codigoMultimedia = codigoMultimedia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public String getPueblo() {
        return pueblo;
    }

    public void setPueblo(String pueblo) {
        this.pueblo = pueblo;
    }

    public String getComunidad() {
        return comunidad;
    }

    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }
    
    
    
   }
