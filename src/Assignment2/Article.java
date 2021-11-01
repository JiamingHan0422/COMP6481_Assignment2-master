package Assignment2;

import java.util.*;
import java.io.*;
/**
@ARTICLE{
6871672, 
author={F. Safaei and P. Pourashraf and D. Franklin}, 
journal={IEEE Communications Magazine}, 
title={Large-scale immersive video conferencing by altering video quality and distribution based on the virtual context}, 
year={2014}, 
volume={52}, 
number={8}, 
pages={66-72}, 
keywords={multimedia communication;teleconferencing;video communication;video signal processing;IVC system;large-scale immersive video conferencing;multimedia dissemination;multiuser virtual environments;video distribution;video quality;virtual context;visibility status;Avatars;Context awareness;Discrete cosine transforms;Large-scale systems;Quality assessment;Streaming media;Video recording;Virtual environments}, 
doi={10.1109/MCOM.2014.6871672}, 
ISSN={0163-6804}, 
month={Aug},
}
 **/

public class Article {
	
	//private long id;
	private String author;
	private String journal;
	private String title;
	private String year;
	private String volume;
	private String number;
	private String pages;
	private String keywords;
	private String doi;
	private String ISSN;
	private String month;
	
	public Article(String author, String journal, String title, String year, String volume,
				   String number, String pages, String keywords, String doi, String ISSN, String month) {
		
		//this.id = id;
		this.author = author;
		this.journal = journal;
		this.title = title;
		this.year = year;
		this.volume = volume;
		this.number = number;
		this.pages = pages;
		this.keywords = keywords;
		this.doi = doi;
		this.ISSN = ISSN;
		this.month = month;
	
	}
	
	public Article() {
		//this.id = -1;
		this.author = "";
		this.journal = "";
		this.title = "";
		this.year = "";
		this.volume = "";
		this.number = "";
		this.pages = "";
		this.keywords = "";
		this.doi = "";
		this.ISSN = "";
		this.month = "";
	}
	
	
	/*
	public long getId() {
        return id;
    }
    */
	//Accessor
    public String getAuthor() {
        return author;
    }

    public String getJournal() {
        return journal;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getVolume() {
        return volume;
    }

    public String getNumber() {
        return number;
    }

    public String getPages() {
        return pages;
    }

    public String getKeywords() {
        return keywords;
    }
    
    public String getDoi() {
        return doi;
    }
    
    public String getISSN() {
        return ISSN;
    }

    public String getMonth() {
        return month;
    }
    /*
    public void setId(long id) {
        this.id = id;
    }
	*/
    // mutator
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    
    public void setDoi(String doi) {
        this.doi = doi;
    }
    
    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    //Type the collected variables in IEEE format
    public  String printIEEE(){
    	
    	if(this.author.equals("")) {
    		//throw new FileInvalidException("");
    	}
    	StringBuilder bIEEE = new StringBuilder();
    	//Change all the and in the text to the prescribed ，
    	bIEEE.append(this.author.replaceAll(" and", ","));
    	bIEEE.append(". \"");
    	bIEEE.append(this.title + " \", ");
    	bIEEE.append(this.journal + ", ");
    	bIEEE.append("vol. " + this.volume + ", ");
    	bIEEE.append("no. " + this.number + ", ");
    	bIEEE.append("p. " + this.pages + ", ");
    	bIEEE.append(this.month + " " + this.year + ".");
    	
    	String IEEE = bIEEE.toString();
		//System.out.println(IEEE);
    	return IEEE;
    }

    //Type the collected variables in NJ format
	public  String printNJ() {
	
		StringBuilder bNJ = new StringBuilder();
		//Change all the and in the text to the prescribed &
		String author = this.author.replaceAll("and", "&");
		bNJ.append(author);
		bNJ.append(". ");
		bNJ.append(this.title + ". ");
		bNJ.append(this.journal + ". ");
		bNJ.append(this.volume + ", ");
		bNJ.append(this.pages);
		bNJ.append("(" + this.year + ").");
	
		String NJ = bNJ.toString();
		//System.out.println(NJ);
		return NJ;
	}

	//Type the collected variables in ACM format
	public  String printACM() {
		
		StringBuilder bACM = new StringBuilder();
	
		String[] author = this.author.split("and");
		//System.out.println(author[0]);
		bACM.append(author[0].trim() + " et al. ");
		bACM.append(this.year +". ");
		bACM.append(this.title + ". ");
		bACM.append(this.journal + ". ");
		bACM.append(this.volume + ", ");
		bACM.append(this.number + " ");
		bACM.append( "(" + this.year + "), ");
		bACM.append(this.pages + ". ");
		bACM.append( "DOI:https://doi.org/" + this.doi + ".");

	
		String ACM = bACM.toString();
		//System.out.println(ACM);
		return ACM;
	}

}
