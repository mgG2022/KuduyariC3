/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kuduyari.kuduyari.controller;

import com.kuduyari.kuduyari.model.administrador;
import com.kuduyari.kuduyari.service.administradorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/administrador")

public class administradorController {
    @Autowired
    private administradorService administradorservice;
    
    @PostMapping(value="/")
    public ResponseEntity<administrador> agregar(@RequestBody administrador administrador){
        administrador obj = administradorservice.save(administrador);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<administrador> eliminar(@PathVariable Integer id){
        administrador obj = administradorservice.findById(id);
        if(obj!=null)
            administradorservice.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<administrador> editar(@RequestBody administrador administrador){
        administrador obj = administradorservice.findById(administrador.getCodigoAdministrador());
        if(obj!=null){
            obj.setDocumento(administrador.getDocumento());
            obj.setNombre(administrador.getNombre());
            obj.setApellido(administrador.getApellido());
            obj.setTelefono(administrador.getTelefono());
            obj.setCorreoElectronico(administrador.getCorreoElectronico());
            administradorservice.save(obj);
        }
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<administrador> consultarTodo(){
        return administradorservice.findAll();
    }
    
    @GetMapping("/list/{id}")
    public administrador consultarPorId(@PathVariable Integer id){
        return administradorservice.findById(id);
    }
    
}
