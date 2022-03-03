package com.example.sir.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Commande {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)

                        //--------   Variables      ------//

    private long id;
    private String reference;
    private double total;
    private double totalpaye;

                        //--------   Constructors ------//


    public Commande(String ref, double total) {
        this.reference = ref;
        this.total = total;
    }

    public Commande(long id) {
        this.id = id;
    }

    public Commande() {
    }


                     //--------   getters and setters ------//


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalpaye() {
        return totalpaye;
    }

    public void setTotalpaye(double totalpaye) {
        this.totalpaye = totalpaye;
    }
}
