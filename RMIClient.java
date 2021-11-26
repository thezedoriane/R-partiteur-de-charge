package repartiteur;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) throws RemoteException, Exception {
        try {
        	//On appel le registre au port 8000
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 8000);  
            //On demande à avoir l'aiguilleur appelle "nom aiguilleur"
            Aiguilleur aiguilleur = (Aiguilleur) registry.lookup("nom aiguilleur"); 
            //Appel de la methode a distance
            String contenu=aiguilleur.lecture("nom fichier1"); 
            System.out.println(contenu);
            String data="texte a completer";
            Boolean ecrit=aiguilleur.ecriture("nom fichier2", data);
            if (ecrit) {
            	System.out.println("Le fichier a été modifié!");
            	contenu=aiguilleur.lecture("nom fichier2"); 
                System.out.println(contenu);
            }
            else {
            	System.out.println("Erreur d'écriture.");
            }
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
