package fr.epita.app;

import java.io.IOException;

import fr.epita.helper.FileHelper;
import fr.epita.producer.CiqualProducer;

public class App {


	public static void main(String[] args) {
		String src="C:\\Users\\phili\\Downloads\\CIQUAL\\in\\CIQUAL.xls";
		String dest="C:\\Users\\phili\\Downloads\\CIQUAL\\out\\CIQUAL.xls";
		String path="C:\\Users\\phili\\Downloads\\CIQUAL\\out\\CIQUAL.csv";
		FileHelper fh=new FileHelper();
		CiqualProducer producer=new CiqualProducer();
		
		String message="file : "+path+ " sended";
		
		boolean result;
		try {
			result = fh.moveFile(src, dest);
			if(result) {
				producer.sendCiqualMessage(message);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
