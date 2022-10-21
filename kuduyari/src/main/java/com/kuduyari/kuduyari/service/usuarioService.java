/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kuduyari.kuduyari.service;

import com.kuduyari.kuduyari.model.usuario;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface usuarioService {
    
    public usuario save(usuario usuario);
    public void delete(Integer id);
    public usuario findById(Integer id);
    public List<usuario>findAll();
}