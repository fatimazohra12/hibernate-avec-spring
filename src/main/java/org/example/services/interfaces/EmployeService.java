package org.example.services.interfaces;

import org.example.classes.Employe;
import org.example.dao.IDao;

public interface EmployeService extends IDao<Employe>{
	void getProjets(Employe employe);
}
