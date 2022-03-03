package com.example.tpcompte.service;

import com.example.tpcompte.bean.Compte;
import com.example.tpcompte.dao.CompteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteService {
    public int save(Compte compte){
        if(compte.getSolde()<100) return -1;
        else if (findByRib(compte.getRib())!=null) return -2;

        compte.setOuvert(true);
        compteDao.save(compte);

        return 1;
    }

    public int debiter(String rib,double montant){
        Compte compte=findByRib(rib);
        if(montant< 10)
            return -1;
        else if(compte==null)
            return -2;
        else if(compte.getSolde()<montant)
            return -3;
        else
        {
            compte.setSolde(compte.getSolde()-montant);
            compteDao.save(compte);
            return 0;
        }
    }

    public int transfer(String ribSrc,String ribDest,double montant){
        Compte compteSrc=findByRib(ribSrc);
        Compte compteDest=findByRib(ribDest);

        if(montant<100) return -1;
        else if( compteSrc==null) return -1;
        else if (compteDest==null) return -2;
        else if(compteSrc.getSolde()<montant) return -3;
        else if(!compteSrc.isOuvert()) return -4;
        else{
            compteSrc.setSolde(compteSrc.getSolde()-montant);
            compteDest.setSolde(compteDest.getSolde()+montant);
            compteDao.save(compteSrc);
            compteDao.save(compteDest);
            return 0;
        }


    }
    public Compte findByRib(String rib) {
        return compteDao.findByRib(rib);
    }

    public List<Compte> findBySoldeLessThan(double solde) {
        return compteDao.findBySoldeLessThan(solde);
    }



    public int deleteByRib(String rib) {
        return compteDao.deleteByRib(rib);
    }

    public int deleteByOuvert(boolean ouvert) {
        return compteDao.deleteByOuvert(ouvert);
    }

    public List<Compte> findAll() {
        return compteDao.findAll();
    }

    @Autowired
    private CompteDao compteDao;

}
