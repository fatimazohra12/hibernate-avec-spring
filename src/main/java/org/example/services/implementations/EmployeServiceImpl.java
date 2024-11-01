package org.example.services.implementations;

import org.example.classes.Employe;
import org.example.classes.Projet;
import org.example.classes.Tache;
import org.example.services.interfaces.EmployeService;
import org.example.services.interfaces.EmployeTacheService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmployeServiceImpl implements EmployeService{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean create(Employe employe){
		Session session = sessionFactory.getCurrentSession();
		session.save(employe);
		return true;
	}

	@Override
	public Employe getById(Long id){
		Session session = sessionFactory.getCurrentSession();
		Employe Produit = session.find(Employe.class,id);
		return Produit;
	}

	@Override
	public List<Employe> getAll(){
		Session session = sessionFactory.getCurrentSession();
		List<Employe> commandes = session.createQuery("from Employe ", Employe.class).list();
		return commandes;
	}

	@Transactional
	@Override
	public void getProjets(Employe employe) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("\nListe des projets de employe : "+employe.getId());
		for(Projet p : employe.getProjets()){
			System.out.println("Projet : "+p.getId()+"\t\t Nom : "+p.getNom()+"\t\t Date début : "+p.getDateDebut());
		}
	}
}

