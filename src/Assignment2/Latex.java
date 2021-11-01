package Assignment2;

import java.io.*;
import java.util.*;

public class Latex {
	
	private String filename;
	private Article[] article;
	
	public Latex(File f) throws FileNotFoundException {
		
		int n = 0;
		filename = f.getName();
		Scanner sc = new Scanner(f);
		while(sc.hasNext()) {
			String str = sc.nextLine();
			
			if(str.startsWith("@ARTICLE{")) {
				n++;
			}
		}

		article = new Article[n];
		sc.close();
	}
	
	public void setArticle(int i, Article article) {
		this.article[i] = article;
	}

	//Print the converted IEEE json format to text
	public void printIEEE() {
		
		String Json = filename.replaceFirst("bib", "json");
		String fileIEEE = "IEEE" + Json.substring(5);
		//System.out.println(fileIEEE);
		File file = new File(fileIEEE);

		try {
			
			if(!file.exists()) {
				file.createNewFile();
			}
			PrintWriter pw = new PrintWriter(file);
			
			for(int i = 0 ; i < this.article.length; i++) {
				
				pw.write(this.article[i].printIEEE());
				pw.write("\n\n");
				pw.flush();
			}
			pw.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find this file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("the IO operation of this file is failed");
		}
		
	}

	//Print the converted ACM json format to text
	public void printACM() {
		
		String Json = filename.replaceFirst("bib", "json");
		String fileACM = "ACM" + Json.substring(5);
		//System.out.println(fileACM);
		File file = new File(fileACM);

		try {
			
			if(!file.exists()) {
				file.createNewFile();
			}
			PrintWriter pw = new PrintWriter(file);
			
			for(int i = 0 ; i < this.article.length; i++) {
				
				pw.write("[" + (i+1) + "]" + "    " + this.article[i].printACM());
				pw.write("\n\n");
				pw.flush();
			}
			pw.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Error: Detected Empty Field! ");
			System.out.println("=============================");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("the IO operation of this file is failed");
		}
		
	}

	//Print the converted NJ json format to text
	public void printNJ() {
		
		String Json = filename.replaceFirst("bib", "json");
		String fileNJ = "NJ" + Json.substring(5);
		//System.out.println(fileNJ);
		File file = new File(fileNJ);

		try {
			
			if(!file.exists()) {
				file.createNewFile();
			}
			PrintWriter pw = new PrintWriter(file);
			
			for(int i = 0 ; i < this.article.length; i++) {
				
				pw.write(this.article[i].printNJ());
				pw.write("\n\n");
				pw.flush();
			}
			pw.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Error: Detected Empty Field !");
			System.out.println("=============================");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("the IO operation of this file is failed");
		}
		
	}
	
}
