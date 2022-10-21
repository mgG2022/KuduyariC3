/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kuduyari.kuduyari.service;

import com.kuduyari.kuduyari.model.receta;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface recetaService {
    public receta save(receta receta);
    public void delete(Integer id);
    public receta findById(Integer id);
    public List<receta>findAll();
}
