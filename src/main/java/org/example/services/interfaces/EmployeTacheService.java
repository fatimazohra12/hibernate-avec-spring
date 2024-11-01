package org.example.services.interfaces;

import org.example.classes.Employe;
import org.example.classes.EmployeTache;
import org.example.dao.IDao;

public interface EmployeTacheService extends IDao<EmployeTache>{
	void getTaches(Employe employe);
}
