package Assignment2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.util.*;
import java.io.*;

public class BibCreator {

	
	public static void main(String args[]) throws IOException {
		System.out.println("Welcome to BibCreator!\n");
		File f = null;
		try {

			for(int i = 1; i <= 10; i++) {
				String filename = "Latex" + String.valueOf(i);
				f = new File("./files/" + filename +".bib");
				Latex latex = new Latex(f);
				Scanner sc = new Scanner(f, "ISO-8859-1");
				try {

						getArtcile(sc, f, latex);
						sc.close();
				}
				catch(FileInvalidException e) {
					String error = e.getMessage();
					System.out.println(error);
				}
			}

			int failedCout = 0;
			int j =1;
			while(j <= 10){
				String IEEEFile = "IEEE" + String.valueOf(j-1);
				String NJFile = "NJ" + String.valueOf(j-1);
				String ACMFile = "ACM" + String.valueOf(j-1);
				String filename = "Latex" + String.valueOf(j);

				Scanner kb = new Scanner(f, "ISO-8859-1");

				File IEEEJson = new File( IEEEFile +".json");
				File NJJson = new File( NJFile +".json");
				File ACMJson = new File( ACMFile +".json");
				f = new File("./files/" + filename +".bib");

				boolean checkValid = processFilesForValidation(kb,f,j);
				if (! checkValid) {
					failedCout++;

					deleteCorresPJson(IEEEJson);
					deleteCorresPJson(NJJson);
					deleteCorresPJson(ACMJson);
				}
				j++;
			}

				if (failedCout == 0)
					System.out.println("All files have been created.");
				else
					System.out.println("A total of " + failedCout +" files were invalid,and could not be processed.All other "
							+ (10 - failedCout) + " valid files have been created.");


		}
		catch(IOException e) {
			System.out.println("Could not open input file "+ f.getName() +" for reading. "
					+ "\n\nPlease check if file exists! "
					+ "Program will terminate after closing any opened files.");
		}
		
		int i = 3;
		while(i != 0) {

			//if user enters correct file name, then they are allow to keep search corresponding file.
			System.out.println("Please enter the name of one of the files that you need to review:");
			Scanner sc = new Scanner(System.in);
			String filename = sc.nextLine();
			File file = new File(filename);
			
			if(file.exists()) {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				
				String str = br.readLine();
				while(str != null) {
					System.out.println(str);
					str = br.readLine();
				}
				br.close();
				fr.close();

			}
			//if user enters incorrect file name, then they are allow to have one last chance to search file,
			// and the program will exit whatever the entered file name correct or not.
			if(file.exists() && i == 2) {
				break;
			}

			else {
				System.out.println("Could not open input file. File does not exist; possiblu it could not be created!");
				i--;
				if(i == 1) {
					System.out.println("Sorry! I an unable to display your desired files! Program will exit!");
					break;
				}
				System.out.println("\nHowever, you will be allowed another chance to enter another file name");

			}

		}

		System.out.println("Goodbye! Hope you have enjoyed creating the needed files using BibCreator.");
	}

	   public static void deleteCorresPJson(File file) {
			if (file != null && file.exists()) {

				try {
					Files.delete(Paths.get(file.getPath()));
				}
				catch (IOException e) {
					System.out.println("file not found");
				}
			}
		}




	public static void getArtcile(Scanner sc, File f, Latex latex) throws FileInvalidException{
		
		String str = "";
		int i = 0;
		while(sc.hasNext()) {
			
			str = sc.nextLine();
			
			if(str.startsWith("@ARTICLE{")) {
				
				Article article = new Article();
				
				while(!(str = sc.nextLine()).startsWith("}")) {
					
					if( str.startsWith("author")) {
						
						int right = str.indexOf("{");
						int left = str.indexOf("}");

						String author = str.substring(right+1, left).trim();
						
						article.setAuthor(author);
						//System.out.println(author);
					}
					else if( str.startsWith("journal")) {
						
						int right = str.indexOf("{");
						int left = str.indexOf("}");
						String journal = str.substring(right+1, left).trim();

						article.setJournal(journal);
						//System.out.println(journal);
					}
					else if( str.startsWith("title")) {
						
						int right = str.indexOf("{");
						int left = str.indexOf("}");
						String title = str.substring(right+1, left).trim();

						article.setTitle(title);
						//System.out.println(title);
					}
					else if( str.startsWith("year")) {
						
						int right = str.indexOf("{");
						int left = str.indexOf("}");
						String year = str.substring(right+1, left).trim();

						article.setYear(year);
						//System.out.println(year);
					}
					else if( str.startsWith("volume")) {
						
						int right = str.indexOf("{");
						int left = str.indexOf("}");
						String volume = str.substring(right+1, left).trim();

						article.setVolume(volume);
						//System.out.println(volume);
					}
					else if( str.startsWith("number")) {
						
						int right = str.indexOf("{");
						int left = str.indexOf("}");
						String number = str.substring(right+1, left).trim();
						
						article.setNumber(number);
						//System.out.println(number);
					}
					else if( str.startsWith("pages")) {
						
						int right = str.indexOf("{");
						int left = str.indexOf("}");
						String pages = str.substring(right+1, left).trim();
						article.setPages(pages);
						//System.out.println(pages);
					}
					
					else if( str.startsWith("keywords")) {
						/*
						int right = str.indexOf("{");
						int left = str.indexOf("}");
						String keywords = str.substring(right+1, left).trim();
						article.setKeywords(keywords);
						System.out.println(keywords);
						*/
					}
					
					else if( str.startsWith("doi")) {
						
						int right = str.indexOf("{");
						int left = str.indexOf("}");
						String doi = str.substring(right+1, left).trim();

						article.setDoi(doi);
						//System.out.println(doi);
					}
					else if( str.startsWith("ISSN")) {
						
						int right = str.indexOf("{");
						int left = str.indexOf("}");
						String ISSN = str.substring(right+1, left).trim();

						article.setISSN(ISSN);
						//System.out.println(ISSN);
					}
					else if( str.startsWith("month")) {
						
						int right = str.indexOf("{");
						int left = str.indexOf("}");
						String month = str.substring(right+1, left).trim();

						article.setMonth(month);
						//System.out.println(month);
					}
					else
						continue;
				}
				latex.setArticle(i, article);
				i++;
			}
		}
		latex.printIEEE();
		latex.printNJ();
		latex.printACM();
		
	}

	public static boolean processFilesForValidation( Scanner kb, File file, int j) {

		//Create a hashmap, the first string takes the field and the next string takes the content
		Map<String, String> articleMap = new HashMap<>();

		int ContentStart;
		String textContent;
		boolean checkValid = true;

		try {
			while (kb.hasNext()) {
				//textContent
				textContent = kb.nextLine().trim();
				if (textContent.startsWith("@ARTICLE") && !articleMap.isEmpty()) {

					checkValid = true;
				}
				// Separate the input String, and the field before the equal sign is the content. If there is content after String =, it will be printed in three formats.
				// If not, the file is judged to be invalid, and all formats of the file are refused to be printed
				else if ((ContentStart = textContent.indexOf("=")) >= 0) {
					String field = textContent.substring(0, ContentStart);
					String content = textContent.substring(ContentStart + 2, textContent.length() - 2);

					if (content.length() == 0)
						throw new FileInvalidException("File is Invalid: Field " + field
								+ " is Empty. Processing stoped at this point. Other empty fields may be present as well!");
					articleMap.put(field, content);
				}
			}
			if (articleMap.size() != 0)
				articleMap.clear();

		}
		catch (FileInvalidException e) {
			System.out.println("Error: Detected Empty Field!");
			System.out.println("============================ \n");
			System.out.println("Problem detected with input file: Latex"+ (j-1) +".bib");
			System.out.println(e.getMessage() + "\n");
			checkValid = false;
		}
		return checkValid;
	}
}
