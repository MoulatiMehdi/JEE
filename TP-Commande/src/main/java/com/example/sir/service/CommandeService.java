package com.example.sir.service;

import com.example.sir.bean.Commande;
import com.example.sir.dao.CommandeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeDao commandeDao;

    public Commande findByReference(String reference) {
        return commandeDao.findByReference(reference);
    }

    @Transactional
    public int deleteByReference(String reference) {
        return commandeDao.deleteByReference(reference);
    }

    public List<Commande> findByTotalLessThan(double total) {
        return commandeDao.findByTotalLessThan(total);
    }

    public List<Commande> findAll() {
        return commandeDao.findAll();
    }

    public int  save(Commande entity) {

        if (findByReference(entity.getReference()) != null) {
            return -1;
        }
        commandeDao.save(entity);
        return 1;
    }
    public int payer(String reference,double montant){
        Commande commande=findByReference(reference);


        if (commande== null)       return -1;
        if(commande.getTotal()<commande.getTotalpaye()+montant) return -2;
        double nvTotalPayer=commande.getTotalpaye()+montant;
        commande.setTotalpaye(nvTotalPayer);
        commandeDao.save(commande);
        return 1;
    }
}
