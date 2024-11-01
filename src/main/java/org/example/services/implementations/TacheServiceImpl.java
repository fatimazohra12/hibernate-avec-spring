package org.example.services.implementations;

import org.example.classes.Tache;
import org.example.dao.IDao;
import org.example.services.interfaces.TacheService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class TacheServiceImpl implements TacheService{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean create(Tache tache){
		Session session = sessionFactory.getCurrentSession();
		session.save(tache);
		return true;
	}

	@Override
	public Tache getById(Long id){
		Session session = sessionFactory.getCurrentSession();
		Tache tache = session.find(Tache.class,id);
		return tache;
	}

	@Override
	public List<Tache> getAll(){
		Session session = sessionFactory.getCurrentSession();
		List<Tache> taches = session.createQuery("from Tache ", Tache.class).list();
		return taches;
	}
	@Transactional
	@Override
	public void getByPriceSup(){
		Session session = sessionFactory.getCurrentSession();
		List<Tache> taches = session.createNamedQuery("getByPriceSup", Tache.class)
				.setParameter("sup", (double)1000.0)
				.getResultList();
		System.out.println("Num"+"\t\t Nom"+"\t\t Date Début Réelle"+"\t\t Date Fin Réelle");
		for(Tache p : taches){
			System.out.println(p.getId()+"\t\t"+p.getNom()+"\t\t"+ p.getDateDebut().toString() +"\t\t"+p.getDateFin());
		}

	}
	@Override
	@Transactional
	public void getBetweenDate(Date startDate , Date endDate) {
		Session session = sessionFactory.getCurrentSession();

		List<Tache> taches = session.createQuery("from Tache l where l.dateDebut <=:startDate and l.dateFin>=:endDate", Tache.class)
				.setParameter("startDate", startDate)
				.setParameter("endDate", endDate)
				.getResultList();
		System.out.println("taches entre deux date :");
		System.out.println("Num"+"\t\t Nom"+"\t\t Date Début Réelle"+"\t\t Date Fin Réelle");
		for(Tache p : taches){
			System.out.println(p.getId()+"\t\t"+p.getNom()+"\t\t"+ p.getDateDebut().toString() +"\t\t"+p.getDateFin());
		}

	}
}
