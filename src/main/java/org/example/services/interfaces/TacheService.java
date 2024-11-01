package org.example.services.interfaces;

import org.example.classes.Tache;
import org.example.dao.IDao;

import java.util.Date;

public interface TacheService extends IDao<Tache>{
	void getByPriceSup();
	void getBetweenDate(Date startDate , Date endDate);
}
