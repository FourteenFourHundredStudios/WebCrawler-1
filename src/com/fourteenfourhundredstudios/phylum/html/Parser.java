package com.fourteenfourhundredstudios.phylum.html;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser {
	Document doc;

	public Parser(String url){
		
		try{
		doc = Jsoup.connect(url).get();

		}catch(Exception e){
			
		}
	}
	
	public void getLinks(){
	    Elements links = doc.select("a[href]");
	    for(Element s : links){
	    	String link=s.attr("href");
	    	if(!link.startsWith("#")){
	    		System.out.println(link);
	    		//put link handling stuff here
	    	}
	    }
	}
	
	public String removeHTML(){
		 Document newDoc = Jsoup.parse(doc.html());
		 return (newDoc.text());
	}
	/*
	public static void main(String[] args){
		new Parser();
	}
	//*/
}
