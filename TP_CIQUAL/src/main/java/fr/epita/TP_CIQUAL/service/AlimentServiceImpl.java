package fr.epita.TP_CIQUAL.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.epita.TP_CIQUAL.domaine.Aliment;
import fr.epita.TP_CIQUAL.infrastructure.AlimentDao;

@Service
public class AlimentServiceImpl implements IAlimentService {

	@Autowired
	AlimentDao dao;
	
	@Override
	public void createAliment(Aliment a) {
		dao.save(a);

	}

}
