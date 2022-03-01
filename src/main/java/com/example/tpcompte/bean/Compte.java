package com.example.tpcompte.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Compte {
     @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String rib;
    private double solde;
    private boolean ouvert;

    //--------- Constructors -------------------/
    public Compte() {
    }

    public Compte(String rib, double solde, boolean ouvert) {
        this.rib = rib;
        this.solde = solde;
        this.ouvert = ouvert;
    }

    //--------getters and setters ----------//
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public boolean isOuvert() {
        return ouvert;
    }

    public int setOuvert(boolean ouvert) {
        if(this.solde<0)
            return -1;
        else{
            this.ouvert = ouvert;
            return 0;
        }

    }
}
