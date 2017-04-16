package batch1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class TXTExport {
	void exportTextFile(String article) throws IOException{
		File outFile = new File ("C:\\Users\\wheej\\Desktop", "test.txt");
		BufferedWriter bw = null;
		try{
			bw = new BufferedWriter(new FileWriter (outFile));
			bw.append(article);
			
			bw.newLine();
			bw.flush();
		
	}
		catch(IOException e){
			e.printStackTrace();
		}finally{
			if (bw != null) try{bw.close();}catch(IOException e){}
		}
	}

}
