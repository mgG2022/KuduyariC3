/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kuduyari.kuduyari.service.Implement;

import com.kuduyari.kuduyari.dao.recetaDao;
import com.kuduyari.kuduyari.model.receta;
import com.kuduyari.kuduyari.service.recetaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Service

public class recetaServiceImplement implements recetaService{
    @Autowired
    private recetaDao recetaDao;
    
    @Override
    @Transactional(readOnly=false)
    public receta save(receta receta){
        return recetaDao.save(receta);
    }
    
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id){
        recetaDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly=true)
    public receta findById(Integer id){
        return recetaDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<receta> findAll(){
        return (List<receta>) recetaDao.findAll();
    }
 
    
}
