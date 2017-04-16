package batch1;
import java.util.*;
import java.io.*;


public class Main {
	
	public static void main (String args[]) throws Exception{
		ArrayList <String> fetchedURL = new ArrayList<>();
		
		String result = Query.getSearchResult("πÆ¿Á¿Œ");
		fetchedURL = getPageURL.getURL(result);
		/*for (int i = 0; i < fetchedURL.size(); i++){
			System.out.println(fetchedURL.get(i));
		}*/
		Parse.parseArticle(fetchedURL);
	}
	
}
