package org.example.services.interfaces;

import org.example.classes.Employe;
import org.example.classes.Projet;
import org.example.dao.IDao;

public interface ProjetService extends IDao<Projet>{
	void getTachesPlanifie(Projet projet);
	void getTachesRealise(Projet projet);
}
