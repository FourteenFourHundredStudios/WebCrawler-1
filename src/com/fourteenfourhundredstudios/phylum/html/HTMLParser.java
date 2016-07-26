package com.fourteenfourhundredstudios.phylum.html;

import java.util.ArrayList;

public class HTMLParser {

	public ArrayList<HTMLElement> elements = new ArrayList<HTMLElement>();
	String html;
	
	public HTMLParser(String html){
		this.html=html;
	    String str="";
		int count=0;
		for(int i=0;i<html.length();i++){		
			String c = html.substring(i,i+1);			
			if(c.equals("<")){	
				if(str.length()>0){
					elements.add(new HTMLElement("text",str));
					str="";
				}
				count++;
				continue;
			}else if(c.equals(">")){
				count --;
				if(count == 0 ){  
					elements.add(new HTMLElement("tag",str.toLowerCase()));
					str="";
					continue;
				}
			}
			str+=c;
		}
	}

	/*Make dynamic way to block more tags than script*/
	public String getText(String... ignore){

		String s = "";
		boolean inScript = false;
		for(HTMLElement i: elements){
			if(i.type.equals("text")){
				if(!inScript){
					s+=i.value;
				}
			}else if (i.type.equals("tag")){
				for(String e:ignore){
					if(i.value.startsWith(e)){
						inScript=true;
					}else if(i.value.startsWith("/"+e)){
						inScript=false;
					}
				}
			}
		}
		return s;
	}
	

}
