package batch1;
import java.io.*;
import java.util.ArrayList;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import org.jsoup.*;

public class Parse {
	
	static void parseArticle(ArrayList <String> URLlist) throws Exception{
		for (int index = 0; index < URLlist.size(); index++){
			if(URLlist.get(index).contains("naver")){
				String articleURL = URLlist.get(index);
				Document doc = Jsoup.connect(articleURL).get();
				Elements articleBody = doc.select("div#articleBodyContents");
				Elements timestamp = doc.select("span.t11");
				String result = articleBody.text();
				String time = timestamp.text();
				System.out.println(time);
				System.out.println(result);
			}
		}
	}

}
