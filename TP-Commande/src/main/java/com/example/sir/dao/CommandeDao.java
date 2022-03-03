package com.example.sir.dao;

import com.example.sir.bean.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //call spring data
public  interface CommandeDao extends  JpaRepository<Commande, Long> {

    Commande findByReference(String reference);
    int deleteByReference(String reference);
    List<Commande> findByTotalLessThan(double total);
}
