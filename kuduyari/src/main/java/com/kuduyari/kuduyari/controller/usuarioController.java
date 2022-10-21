/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kuduyari.kuduyari.controller;

import com.kuduyari.kuduyari.model.usuario;
import com.kuduyari.kuduyari.service.usuarioService;
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
@RequestMapping("/usuario")

public class usuarioController {
@Autowired
    private usuarioService usuarioservice;
    
    @PostMapping(value="/")
    public ResponseEntity<usuario> agregar(@RequestBody usuario receta){
        usuario obj = usuarioservice.save(receta);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<usuario> eliminar(@PathVariable Integer id){
        usuario obj = usuarioservice.findById(id);
        if(obj!=null)
           usuarioservice.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<usuario> editar(@RequestBody usuario usuario){
        usuario obj = usuarioservice.findById(usuario.getCodigoUsuario());
        if(obj!=null){
            obj.setDocumento(usuario.getDocumento());
            obj.setNombre(usuario.getNombre());
            obj.setApellido(usuario.getApellido());
            obj.setCiudad(usuario.getCiudad());
            obj.setTelefono(usuario.getTelefono());
            usuarioservice.save(obj);
        }
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<usuario> consultarTodo(){
        return usuarioservice.findAll();
    }
    
    @GetMapping("/list/{id}")
    public usuario consultarPorId(@PathVariable Integer id){
        return usuarioservice.findById(id);
    }
       
}
