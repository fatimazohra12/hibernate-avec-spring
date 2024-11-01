package org.example.services.implementations;

import org.example.classes.Employe;
import org.example.classes.EmployeTache;
import org.example.classes.Projet;
import org.example.classes.Tache;
import org.example.dao.IDao;
import org.example.services.interfaces.EmployeTacheService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class EmployeTacheServiceImpl implements EmployeTacheService{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean create(EmployeTache employeTache){
		Session session = sessionFactory.getCurrentSession();
		session.save(employeTache);
		return true;
	}

	@Override
	public EmployeTache getById(Long id){
		Session session = sessionFactory.getCurrentSession();
		EmployeTache employeTache = session.find(EmployeTache.class,id);
		return employeTache;
	}

	@Override
	public List<EmployeTache> getAll(){
		Session session = sessionFactory.getCurrentSession();
		List<EmployeTache> employeTaches = session.createQuery("from EmployeTache ", EmployeTache.class).list();
		return employeTaches;
	}

	@Transactional
	@Override
	public void getTaches(Employe employe) {
		Session session = sessionFactory.getCurrentSession();
		List<Tache> taches =  session.createQuery("select tache from EmployeTache e where e.employe.id = :employe", Tache.class)
				.setParameter("employe", employe.getId()) // Use the category ID
				.getResultList();
		System.out.println("\nNum"+"\t\t Nom"+"\t\t Date Début Réelle"+"\t\t Date Fin Réelle");
		for(Tache p : taches){
			System.out.println(p.getId()+"\t\t"+p.getNom()+"\t\t"+ p.getDateDebut().toString() +"\t\t"+p.getDateFin());
		}
	}

}
