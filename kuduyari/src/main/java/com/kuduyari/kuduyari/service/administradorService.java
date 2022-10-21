/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kuduyari.kuduyari.service;

import com.kuduyari.kuduyari.model.administrador;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface administradorService {
    
    public administrador save(administrador administrador);
    public void delete(Integer id);
    public administrador findById(Integer id);
    public List<administrador>findAll();
}
