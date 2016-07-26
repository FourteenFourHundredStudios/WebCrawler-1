package com.fourteenfourhundredstudios.phylum.html;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser {

	public Parser(){
		
		try{
		Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/Java_(programming_language)").get();
	    Elements links = doc.select("a[href]");
	    for(Element s : links){
	    	String link=s.attr("href");
	    	if(!link.startsWith("#")){
	    		//put link handling stuff here
	    	}
	    }
		}catch(Exception e){
			
		}
	}
	
	public static void main(String[] args){
		new Parser();
	}
	
}
