package com.fourteenfourhundredstudios.phylum.html;

public class HTMLElement {

	String type;
	String value;
	
	public HTMLElement(String type,String value){
		this.type=type;
		this.value=value;
	}

	public String toString(){
		return "[" + type + "," + value + "]";
	}
	
}
