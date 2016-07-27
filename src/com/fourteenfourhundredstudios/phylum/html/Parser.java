package com.fourteenfourhundredstudios.phylum.html;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser {
	public Document doc;

	public Parser(String url){
		
		try{
		doc = Jsoup.connect(url).get();

		}catch(Exception e){
			
		}
	}
	
	public void getLinks(){

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
