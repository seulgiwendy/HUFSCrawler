package batch1;
import java.io.*;
import java.util.ArrayList;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import org.jsoup.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Parse {
	static void parseArticle(ArrayList <String> URLlist) throws Exception{
		int parsedArticleCount = 0;
		int nonNaverArticle = 0;
		
		File outFile = new File ("C:\\Users\\wheej\\Desktop", "test.txt");
		for (int index = 0; index < URLlist.size(); index++){
			BufferedWriter bw = null;
			bw = new BufferedWriter(new FileWriter (outFile, true));
			String result;
			String time;
			if(URLlist.get(index).contains("naver")){
				parsedArticleCount += 1;
				String articleURL = URLlist.get(index);
				Document doc = Jsoup.connect(articleURL).get();
				Elements articleBody = doc.select("div#articleBodyContents");
				Elements timestamp = doc.select("span.t11");
				result = articleBody.text();
				time = timestamp.text();
				System.out.println(time);
				System.out.println(result);
				try{
					/*bw.newLine();
					bw.write(TimeNow.setTimeStamp());*/
					bw.newLine();
					bw.write(time);
					bw.newLine();
					bw.write(articleURL);
					bw.newLine();
					bw.write(result);
					
				
			}
				catch(IOException e){
					e.printStackTrace();
				}finally{
					if (bw != null) try{bw.close();}catch(IOException e){}
				}
				
			}
			
		}
		System.out.println("수집된 기사 갯수: " + parsedArticleCount);
		nonNaverArticle = URLlist.size() - parsedArticleCount;
		System.out.println("네이버 링크가 제공되지 않은 기사가 " + nonNaverArticle + "개 있습니다.");
		System.out.println("아래에 링크를 제공해 드립니다.");
		System.out.println("===============================");
		for (int index = 0; index < URLlist.size(); index++){
			if(URLlist.get(index).contains("naver") == false){
				System.out.println(URLlist.get(index));
			}
		}
		
	}

}
	

