package batch1;
import java.net.*;
import java.net.URL;
import java.net.URLEncoder;
import java.io.*;
import javax.xml.*;

public class Query extends Preferences{
	
	static String getSearchResult(String Query){
		String resultXml = null;
		try{
			
			String query = URLEncoder.encode(Query, "UTF-8");
			URL targetURL = new URL(apiURL + query + "&display=100");
			HttpURLConnection connect = (HttpURLConnection)targetURL.openConnection();
			connect.setRequestMethod("GET");
            connect.setRequestProperty("X-Naver-Client-Id", clientID);
            connect.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = connect.getResponseCode();
			BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(connect.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            resultXml = response.toString();
            //System.out.println(response.toString());
            
			
		}
		catch (Exception e){
			System.out.println(e);
		}
		
		return resultXml;
	}

}
