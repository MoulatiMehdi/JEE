package com.example.tpcompte.webservice;

import com.example.tpcompte.bean.Compte;
import com.example.tpcompte.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController // pour un Web Service
@RequestMapping("/api/v1/compte/")
public class CompteWS {
    @PostMapping("/")
    public int save(@RequestBody Compte compte) {
        return compteService.save(compte);
    }
    @PutMapping("/rib/{rib}/montant/{montant}")
    public int debiter(@PathVariable String rib,@PathVariable double montant) {
        return compteService.debiter(rib, montant);
    }
    @PutMapping("/ribSrc/{ribSrc}/ribDest/{ribDest}/montant/{montant}")
    public int transfer(@PathVariable String ribSrc, @PathVariable String ribDest, @PathVariable double montant) {
        return compteService.transfer(ribSrc, ribDest, montant);
    }

    @GetMapping("/rib/{rib}")
    public Compte findByRib(@PathVariable String rib) {
        return compteService.findByRib(rib);
    }

    @GetMapping("/solde/{solde}")
    public List<Compte> findBySoldeLessThan(@PathVariable double solde) {
        return compteService.findBySoldeLessThan(solde);
    }

    @DeleteMapping("/rib/{rib}")
    @Transactional
    public int deleteByRib(@PathVariable String rib) {
        return compteService.deleteByRib(rib);
    }

    @DeleteMapping("/ouvert/{ouvert}")
    @Transactional
    public int deleteByOuvert(@PathVariable boolean ouvert) {
        return compteService.deleteByOuvert(ouvert);
    }
    @GetMapping("/")
    public List<Compte> findAll() {
        return compteService.findAll();
    }

    @Autowired
    private CompteService compteService;
}
