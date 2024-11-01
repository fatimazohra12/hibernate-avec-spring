package org.example;

import org.example.classes.Employe;
import org.example.classes.EmployeTache;
import org.example.classes.Projet;
import org.example.classes.Tache;
import org.example.services.interfaces.EmployeService;
import org.example.services.interfaces.EmployeTacheService;
import org.example.services.interfaces.ProjetService;
import org.example.services.interfaces.TacheService;
import org.example.util.HibernateUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateUtil.class);
        ProjetService projetService = context.getBean("projetServiceImpl", ProjetService.class);
        TacheService tacheService = context.getBean("tacheServiceImpl", TacheService.class);
        EmployeService employeService = context.getBean("employeServiceImpl", EmployeService.class);
        EmployeTacheService employeTacheService = context.getBean("employeTacheServiceImpl", EmployeTacheService.class);
        
        Date startDate = new Date(); // Today's date as an example
        Date endDate = new Date(System.currentTimeMillis() + 86400000L);

        // Create Employe instances using constructor and setters
        Employe employe = new Employe();
        employe.setNom("dd");
        employe.setPrenom("jjj");
        employe.setTelephone("0525890555");
        employe.setProjets(new ArrayList<>());

        Employe employe1 = new Employe();
        employe1.setNom("dCS");
        employe1.setPrenom("SQC");
        employe1.setTelephone("0565258905");
        employe1.setProjets(new ArrayList<>());

        Employe chef = new Employe();
        chef.setNom("CSDCS");
        chef.setPrenom("sdvd");
        chef.setTelephone("5455410");
        chef.setProjets(new ArrayList<>());

        // Create Tache instances using constructor
        Tache tache = new Tache();
        tache.setNom("Design");
        tache.setDateDebut(startDate);
        tache.setDateFin(endDate);
        tache.setPrix(1000.0);

        Tache tache1 = new Tache();
        tache1.setNom("Development");
        tache1.setDateDebut(startDate);
        tache1.setDateFin(endDate);
        tache1.setPrix(2000.0);

        Tache tache2 = new Tache();
        tache2.setNom("Testing");
        tache2.setDateDebut(startDate);
        tache2.setDateFin(endDate);
        tache2.setPrix(1500.0);

        // Create Projet instance
        Projet projet = new Projet();
        projet.setNom("New Project");
        projet.setDateDebut(new Date());
        projet.setDateFin(endDate);
        projet.setEmploye(chef);
        projet.setTaches(new ArrayList<>(Arrays.asList(tache, tache1, tache2)));

        // Set projects for employees
        chef.setProjets(new ArrayList<>(Arrays.asList(projet)));
        employe.setProjets(new ArrayList<>(Arrays.asList(projet)));
        employe1.setProjets(new ArrayList<>(Arrays.asList(projet)));

        // Set project for tasks
        tache.setProjet(projet);
        tache1.setProjet(projet);
        tache2.setProjet(projet);

        // Create EmployeTache instances using constructor
        EmployeTache employeTache = new EmployeTache();
        employeTache.setDateDebutReelle(new Date());
        employeTache.setDateFinReelle(new Date());
        employeTache.setEmploye(employe1);
        employeTache.setTache(tache);

        EmployeTache employeTache2 = new EmployeTache();
        employeTache2.setDateDebutReelle(new Date());
        employeTache2.setDateFinReelle(new Date());
        employeTache2.setEmploye(employe);
        employeTache2.setTache(tache2);

        EmployeTache employeTache3 = new EmployeTache();
        employeTache3.setDateDebutReelle(new Date());
        employeTache3.setDateFinReelle(new Date());
        employeTache3.setEmploye(employe);
        employeTache3.setTache(tache1);

        // Persist entities
        if (employeService.create(employe)) {
            System.out.println("Employe Created: " + employe.getNom());
        }
        if (employeService.create(employe1)) {
            System.out.println("Employe Created: " + employe1.getNom());
        }
        if (employeService.create(chef)) {
            System.out.println("Chef Created: " + chef.getNom());
        }

        if (projetService.create(projet)) {
            System.out.println("Projet Created: " + projet.getNom());
        }
        if (tacheService.create(tache)) {
            System.out.println("Tache Created: " + tache.getNom());
        }
        if (tacheService.create(tache1)) {
            System.out.println("Tache Created: " + tache1.getNom());
        }
        if (tacheService.create(tache2)) {
            System.out.println("Tache Created: " + tache2.getNom());
        }
        if (employeTacheService.create(employeTache)) {
            System.out.println("EmployeTache Created: for employe " + employe1.getNom() + " on tache " + tache.getNom());
        }
        if (employeTacheService.create(employeTache2)) {
            System.out.println("EmployeTache Created: for employe " + employe.getNom() + " on tache " + tache2.getNom());
        }
        if (employeTacheService.create(employeTache3)) {
            System.out.println("EmployeTache Created: for employe " + employe.getNom() + " on tache " + tache1.getNom());
        }
        
        // Additional operations
        employeTacheService.getTaches(employe);
        employeService.getProjets(employe);
        projetService.getTachesPlanifie(projet);
        projetService.getTachesRealise(projet);
        tacheService.getByPriceSup();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start = sdf.parse("2024-10-01");
        Date end = sdf.parse("2024-11-11");
        tacheService.getBetweenDate(start, end);
    }
}
