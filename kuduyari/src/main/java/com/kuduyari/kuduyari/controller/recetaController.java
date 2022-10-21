/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kuduyari.kuduyari.controller;


import com.kuduyari.kuduyari.model.receta;
import com.kuduyari.kuduyari.service.recetaService;
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
@RequestMapping("/receta")

public class recetaController {
    @Autowired
    private recetaService recetaservice;
    
    @PostMapping(value="/")
    public ResponseEntity<receta> agregar(@RequestBody receta receta){
        receta obj = recetaservice.save(receta);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<receta> eliminar(@PathVariable Integer id){
        receta obj = recetaservice.findById(id);
        if(obj!=null)
           recetaservice.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<receta> editar(@RequestBody receta receta){
        receta obj = recetaservice.findById(receta.getCodigoReceta());
        if(obj!=null){
            obj.setCodigoMultimedia(receta.getCodigoMultimedia());
            obj.setNombre(receta.getNombre());
            obj.setIngredientes(receta.getIngredientes());
            obj.setPreparacion(receta.getPreparacion());
            obj.setPueblo(receta.getPueblo());
            obj.setComunidad(receta.getComunidad());
            recetaservice.save(obj);
        }
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<receta> consultarTodo(){
        return recetaservice.findAll();
    }
    
    @GetMapping("/list/{id}")
    public receta consultarPorId(@PathVariable Integer id){
        return recetaservice.findById(id);
    }
   
}
