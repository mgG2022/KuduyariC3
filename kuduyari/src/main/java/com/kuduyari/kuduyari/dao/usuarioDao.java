/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kuduyari.kuduyari.dao;

import com.kuduyari.kuduyari.model.usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Admin
 */
public interface usuarioDao extends CrudRepository<usuario, Integer>{
    
}
