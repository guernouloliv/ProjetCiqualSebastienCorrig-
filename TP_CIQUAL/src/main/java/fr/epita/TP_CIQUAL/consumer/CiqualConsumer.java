package fr.epita.TP_CIQUAL.consumer;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import fr.epita.TP_CIQUAL.helper.CSVHelper;
import fr.epita.TP_CIQUAL.service.IAlimentService;

@Component
public class CiqualConsumer {

	@Autowired
	IAlimentService service;
	
	@JmsListener( destination = "queue_CIQUAL")
	public void consume(String message) {
		int indexEnd=message.indexOf(" sended");
		String dest=message.substring(7,indexEnd);
		System.out.println(dest);
		CSVHelper helper=new CSVHelper();
		try {
			helper.parse(dest).forEach(a->service.createAliment(a));
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
