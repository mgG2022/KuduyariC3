/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kuduyari.kuduyari.service.Implement;

import com.kuduyari.kuduyari.dao.administradorDao;
import com.kuduyari.kuduyari.model.administrador;
import com.kuduyari.kuduyari.service.administradorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Service

public class administradorServiceImplement implements administradorService{
    @Autowired
    private administradorDao administradorDao;
    
    @Override
    @Transactional(readOnly=false)
    public administrador save(administrador administrador){
        return administradorDao.save(administrador);
    }
    
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id){
        administradorDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly=true)
    public administrador findById(Integer id){
        return administradorDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<administrador> findAll(){
        return (List<administrador>) administradorDao.findAll();
    }
 
}
