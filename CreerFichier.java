package repartiteur;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CreerFichier {
	public static void main(String[] args) {
		try{
		Scanner inputReader = new Scanner(System.in);
		//On demande à l'utilisateur le nom du nouveau fichier
		System.out.println("Entree le nom du fichier avec .txt à la fin: ");
		String txt = inputReader.next();
	    String fileName = txt;
	    String encoding = "UTF-8";
	    
	    	//On demande le nombre de ligne dans le fichier que l'on veut ecrire
	        System.out.println("Entree le nombre de ligne: ");
	        int number = inputReader.nextInt();
	        //On creer un fichier
	        FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            //On entre demande a l utilisateur d ecrire chacune des lignes
	        for (int i=0; i<number; i+=1) {
	        	System.out.println("Entree le contenu de votre ligne: ");
	        	String l = inputReader.next();
	            bw.write(l);
	        	bw.newLine();
	        }
	        bw.close();
	        fw.close();
	    }
	    catch (IOException e){
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }
}
