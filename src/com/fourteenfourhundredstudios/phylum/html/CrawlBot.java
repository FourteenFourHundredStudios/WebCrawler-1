package com.fourteenfourhundredstudios.phylum.html;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.*;
 
public class CrawlBot {
	PrintWriter writer;
	fetcher f = new fetcher();
	int numOfSources = 0;
	int sourceCounter = 0;
	BufferedReader br = null;
 
    public CrawlBot(){
        //http://en.wikipedia.org/wiki/Java_(programming_language)
        //System.out.println(downloadWebsite("http://wikipedia.org/wiki/Java_(programming_language)"));
        //downloadWebsiteHTTPSOCK("en.wikipedia.org/wiki/Ada_(programming_language)",false);
      
    	
    //	saveAllLinksFrom("https://en.wikipedia.org/wiki/Java",true);
    	getNewLink();
    //	Util.getHash(",-");
    }

    
    public void getNewLink(){
    	String url ="";
    	try {
    		br = new BufferedReader(new FileReader("Links2Download.txt"));
    		while((url = br.readLine() )!=""){
    		//delete that url now here
    		Util.removeFirstLine("Links2Download.txt");
    		this.saveAllLinksFrom(url, true);
    		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
     
     
    public void saveAllLinksFrom(String url,boolean log){
        try{
        	System.out.println(url);
        	f.getHtml(url,sourceCounter);
        	Document doc = Jsoup.connect(url).get();
        	Elements links = doc.select("a[href]");
     	    for(Element s : links){
     	    	String link=s.attr("href");
     	    	System.out.println(link);
     	    	if(!link.startsWith("#")){
     	    		if(link.startsWith("/"))link=url+link;
     	    		System.out.println(link);
     	    		sourceCounter++;
                    //f.getHtml(link,sourceCounter);
     	    		String saveableLink=link+"\n";
                    Files.write(Paths.get("Links2Download.txt"), saveableLink.getBytes(), StandardOpenOption.APPEND);

     	    	}
     	    }
        	
        }catch(Exception e){
            e.printStackTrace();
            
        }
    }
     
    public  String removeHTML(String input) {
        return null;
    }
     //*
    public static void main(String[] args){
        new CrawlBot();
    }
     //*/
}