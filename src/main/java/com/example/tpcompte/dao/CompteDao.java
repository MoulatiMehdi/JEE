package com.example.tpcompte.dao;

import com.example.tpcompte.bean.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompteDao extends JpaRepository<Compte,String> {

    Compte findByRib(String rib);
    List<Compte> findBySoldeLessThan(double solde);
    int deleteByRib(String rib);
    int deleteByOuvert(boolean ouvert);
}
