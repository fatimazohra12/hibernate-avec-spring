package org.example.services.implementations;

import org.example.classes.Employe;
import org.example.classes.EmployeTache;
import org.example.classes.Projet;
import org.example.classes.Tache;
import org.example.dao.IDao;
import org.example.services.interfaces.ProjetService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProjetServiceImpl implements ProjetService{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean create(Projet projet){
		Session session = sessionFactory.getCurrentSession();
		session.save(projet);
		return true;
	}

	@Override
	public Projet getById(Long id){
		Session session = sessionFactory.getCurrentSession();
		Projet projet = session.find(Projet.class,id);
		return projet;
	}

	@Override
	public List<Projet> getAll(){
		Session session = sessionFactory.getCurrentSession();
		List<Projet> projets = session.createQuery("from Projet ", Projet.class).list();
		return projets;
	}

	@Transactional
	@Override
	public void getTachesPlanifie(Projet projet){
		Session session = sessionFactory.getCurrentSession();
		for(Tache p : projet.getTaches()){
			System.out.println("Tache : "+p.getId()+"\t\t Nom : "+p.getNom()+"\t\t Prix : "+p.getPrix()+"\t\t Date début : "+p.getDateDebut()+"\t\t Date fin : "+p.getDateFin());
		}
	}
	@Transactional
	@Override
	public void getTachesRealise(Projet projet){
		Session session = sessionFactory.getCurrentSession();

		System.out.println("\nProjet : "+projet.getId()+"\t\t Nom : "+projet.getNom()+"\t\t Date début : "+projet.getDateDebut());
		System.out.println("Liste des taches :");
		System.out.println("Num"+"\t\t Nom"+"\t\t Date Début Réelle"+"\t\t Date Fin Réelle");
		for(Tache p : projet.getTaches()){
			System.out.println(p.getId()+"\t\t"+p.getNom()+"\t\t"+ p.getDateDebut().toString() +"\t\t"+p.getDateFin());
		}
	}
}
