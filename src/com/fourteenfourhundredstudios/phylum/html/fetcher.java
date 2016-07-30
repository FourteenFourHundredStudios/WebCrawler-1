package com.fourteenfourhundredstudios.phylum.html;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;

public class fetcher {
	
	public String saveHtml(String urlName, int sourceCount,String subject){
		String totalHtml = "";
	    URL url;
	    InputStream is = null;
	    BufferedReader br;
	    String line;
	    //int sourceCount = 0;
	    PrintWriter writer = null;

	    try {
	    	/*
	        url = new URL(urlName);
	        is = url.openStream();  // throws an IOException
	        br = new BufferedReader(new InputStreamReader(is));

	        while ((line = br.readLine()) != null) {
	            //System.out.println(line);
	        	totalHtml = totalHtml+"\n"+line;
	        }*/
	    	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	  	   //get current date time with Date()
	  	   Date date = new Date();
	    	JSONObject data=null;
	    	try{
	    		data = new JSONObject("{'url':'"+urlName+"','topics':["+subject+"],'timestamp':'"+dateFormat.format(date)+"'}");
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    //	System.out.println(urlName);
	        Parser parser = new Parser(urlName);
	      //  Util util = new Util();
	        String saveData=data.toString()+"\n"+parser.removeHTML()+"\n";
	        //System.out.println(urlName);
	       	writer = new PrintWriter(Util.getPath()+Util.getHash(urlName)+".txt", "UTF-8");
	       	
	       	writer.println(saveData);

	       	writer.flush();
        	writer.close();
        	System.out.println(urlName+" just got saved");
        	System.out.println(sourceCount);
	        
	        //just exception handleing down there

	    } catch (IOException ioe) {
	         ioe.printStackTrace();
	    } 
	    return totalHtml;
	}
}
