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

public class TimeNow {
	static String setTimeStamp(){
		
	
	BufferedWriter timeStamp = null;
	File outFile = new File ("C:\\Users\\wheej\\Desktop", "test.txt");
	long currentTime = System.currentTimeMillis();
	SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	
	String timeNow = ("크롤링 실행 시각:" + dayTime.format(new Date(currentTime)));
	
	try{
		timeStamp = new BufferedWriter(new FileWriter(outFile, true));
	timeStamp.newLine();
	timeStamp.write(timeNow);
	timeStamp.close();
	}
	catch(IOException e){
		e.printStackTrace();
	}finally{
		if (timeStamp != null) try{timeStamp.close();}catch(IOException e){}
		
		
}
	return timeNow;
}
}
