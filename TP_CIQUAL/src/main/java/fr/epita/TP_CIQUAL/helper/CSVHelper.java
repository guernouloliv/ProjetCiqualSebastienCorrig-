package fr.epita.TP_CIQUAL.helper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import fr.epita.TP_CIQUAL.domaine.Aliment;
import fr.epita.TP_CIQUAL.domaine.ValeurNutritionnelle;

public class CSVHelper {

	public static final int JONES_KJ_INDEX = 11;
	public static final int UE_KJ_INDEX = 9;
	public static final int JONES_KCAL_INDEX = 12;
	public static final int UE_KCAL_INDEX = 10;

	public List<Aliment> parse(String filePath) throws IOException {
		Reader in;
		List<Aliment> aliments = new ArrayList();
		List<ValeurNutritionnelle> valeurNutritionelles = null;

		in = new FileReader(filePath);
		CSVFormat format=CSVFormat.Builder.create()
				.setDelimiter(";")
				//.setIgnoreHeaderCase(true)
				.build();
		Iterable<CSVRecord> records = format.parse(in);
		List<String> headers =new ArrayList<String>();
		int compteur=0;
		Aliment aliment = null;
		for (CSVRecord record : records) { // Chaque ligne donc chaque aliment
			
			if(compteur==0) {
				for (int h = 0; h< 76; h++) {
					headers.add(record.get(h));
				}
				
			}else {
				aliment= new Aliment();
				aliment.setCode(record.get(6));
				aliment.setNom(record.get(7));
				aliment.setUeKJ(record.get(UE_KJ_INDEX));
				aliment.setUeKCal(record.get(UE_KCAL_INDEX));
				aliment.setJonesKJ(record.get(JONES_KJ_INDEX));
				aliment.setJonesKCal(record.get(JONES_KCAL_INDEX));

				valeurNutritionelles = new ArrayList(); // Chaque aliment a sa liste de valeur nutritionnelle

				for (int i = 13; i < 76; i++) { // Pour la ligne record (pour un aliment donné) on va récupérer
												// les valeurs nutritionnelle qui commencent à l'index 13 dans le CSV
					ValeurNutritionnelle vn = new ValeurNutritionnelle();
					vn.setValeur(record.get(i));
					vn.setLibelle(headers.get(i));
					valeurNutritionelles.add(vn);
				}
				aliment.setValeurNutritionelles(valeurNutritionelles);
				aliments.add(aliment);
			}
			

			
			compteur++;
		} // Fin de la ligne
		return aliments;
	}
}
