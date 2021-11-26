package repartiteur;

import java.rmi.RemoteException;
import java.io.*;

public class MachineImp implements Machine{
	
	public MachineImp() {
	}

	@Override
	public String lecture(String nomf) throws RemoteException, Exception{
		//On prend le nom du fichier (avec le chemin si il n'est pas a cote du programme)
		File doc = new File(nomf);
		BufferedReader obj = new BufferedReader(new FileReader(doc));
		String data="";
		String ligne;
		//On recupere les donnees du fichier ligne par ligne 
		while ((ligne = obj.readLine()) != null) {
		    data += ligne + "\n";
		}
		//On renvoie les donnees du fichier demande
		System.out.println(data);
		return data;
	}

	@Override
	public boolean ecriture(String nomf, String data) throws RemoteException {
		//On prend le nom du fichier (avec le chemin si il n'est pas a cote du programme) et le fichier entier modifie 
		//Si le fichier existe:
		try {  
			//On prend le fichier deja existant et on ecrase ses donnees avec celles donnees
		    FileWriter outFile = new FileWriter(nomf);  
		    PrintWriter out = new PrintWriter(outFile);  
		    out.println(data);  
		    out.close();  
		    //Si tout se passe bien on renvoie true
		    return true;
		//En cas d'erreur on retourne false
		} catch (IOException e) {  
		    e.printStackTrace();  
		    return false;
		}
		
	}

}
