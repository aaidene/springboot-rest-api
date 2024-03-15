package com.greta.taskmanagement.controller;

import com.greta.taskmanagement.bean.Etudiant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("etudiants")
public class EtudiantController {

    // http://localhost:8080/etudiant
    @GetMapping("etudiant")
    public Etudiant getEtudiant() {
        Etudiant etudiant = new Etudiant(
                1,        // Id
                "aidene", // Nom
                "hakim"   // Prenom
        );
        return etudiant;
    }
    @GetMapping
    public List<Etudiant> getEtudiants(){

        List<Etudiant> etudiants = new ArrayList();

        etudiants.add(new Etudiant(1,"nom0","prenom0"));
        etudiants.add(new Etudiant(2,"nom1","prenom1"));
        etudiants.add(new Etudiant(3,"nom2","prenom2"));
        etudiants.add(new Etudiant(4,"nom3","prenom3"));

     return  etudiants;

    }

    @GetMapping("{id}/{nom}/{prenom}")
    public ResponseEntity<Etudiant> studentPathVariable(@PathVariable("id") int etudiantId,
                                                        @PathVariable("nom") String nom,
                                                        @PathVariable("prenom") String prenom){
        Etudiant student = new Etudiant(etudiantId, nom, prenom);
        return ResponseEntity.ok(student);
    }

    @PostMapping("create")
    public ResponseEntity<Etudiant> createEtudiant(@RequestBody Etudiant etudiant){
        System.out.println(etudiant.getId());
        System.out.println(etudiant.getNom());
        System.out.println(etudiant.getPrenom());

        return new ResponseEntity<>(etudiant, HttpStatus.CREATED);
    }

    @PutMapping("{id}/update")
    public ResponseEntity<Etudiant> updateEtudiant(@RequestBody Etudiant etudiant, @PathVariable("id") int etudiantId){
        System.out.println(etudiant.getNom());
        System.out.println(etudiant.getPrenom());

        return ResponseEntity.ok(etudiant);
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteEtudiant(@PathVariable("id") int etudiantId){
        System.out.println(etudiantId);

        return ResponseEntity.ok("Étudiant supprimé avec succès !");
    }

}
