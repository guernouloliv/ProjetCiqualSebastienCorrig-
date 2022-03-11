package fr.epita.TP_CIQUAL.exposition;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.epita.TP_CIQUAL.domaine.Aliment;
import fr.epita.TP_CIQUAL.helper.CSVHelper;

@RestController
@RequestMapping("/aliment")
public class AlimentController {
	
	@GetMapping("/{index}")
	public Aliment getAliment(@PathVariable("index") int index) {
		
		String path= "C:\\Users\\phili\\Downloads\\CIQUAL\\out\\CIQUAL.csv";
		CSVHelper helper=new CSVHelper();
		Aliment a = null;
		try {
			a=helper.parse(path).get(index);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

}
