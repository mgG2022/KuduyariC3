/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kuduyari.kuduyari.service.Implement;

import com.kuduyari.kuduyari.dao.usuarioDao;
import com.kuduyari.kuduyari.model.usuario;
import com.kuduyari.kuduyari.service.usuarioService;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service

public class usuarioServiceImplement implements usuarioService{
    @Autowired
    private usuarioDao usuarioDao;
    
    @Override
    @Transactional(readOnly=false)
    public usuario save(usuario usuario){
        return usuarioDao.save(usuario);
    }
    
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id){
        usuarioDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly=true)
    public usuario findById(Integer id){
        return usuarioDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<usuario> findAll(){
        return (List<usuario>) usuarioDao.findAll();
    }
 
}
