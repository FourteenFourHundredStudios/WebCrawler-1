

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.*;
 
public class CrawlBot {
	PrintWriter writer;
	fetcher f = new fetcher();
	int numOfSources = 0;
	int sourceCounter = 0;
 
    public CrawlBot(){
        //http://en.wikipedia.org/wiki/Java_(programming_language)
        //System.out.println(downloadWebsite("http://wikipedia.org/wiki/Java_(programming_language)"));
        //downloadWebsiteHTTPSOCK("en.wikipedia.org/wiki/Ada_(programming_language)",false);
        saveAllLinksFrom("http://rcmania.com/",true);
    }
     

    public static int nthOc(String str, char c, int n) {
        int pos = str.indexOf(c, 0);
        while (n-- > 0 && pos != -1)
            pos = str.indexOf(c, pos+1);
        return pos;
    }
     
     
    public void saveAllLinksFrom(String url,boolean log){
        try{
            //String site=downloadWebsiteHTTPSOCK(url,true);

        	String site = f.getHtml(url,sourceCounter);
            site=site.replace(">","<");
            String[] lines=site.split("<");
            for(int i=0;i<lines.length;i++){
                String[] lineParts=lines[i].split(" ");
                if(lineParts[0].equals("a")){
                    for(int j=0;j<lineParts.length;j++){
                        if(lineParts[j].startsWith("href")){
                            String link=lineParts[j].substring(6,lineParts[j].length()-1);
                            if(link.startsWith("/")){
                                link=url.substring(0,nthOc(url, '/', 2))+link;
                            }
                            //downloadWebsiteHTTPSOCK(link,true);
                            sourceCounter++;
                            f.getHtml(link,sourceCounter);
                        }
                    }
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
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