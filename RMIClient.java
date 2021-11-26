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
            String contenu=aiguilleur.lecture("nom du fichier a lire"); 
            System.out.println(contenu);
            String data="Texte souhaité";
            Boolean ecrit=aiguilleur.ecriture("nom du fichier a editer", data);
            if (ecrit) {
            	System.out.println("Le fichier a ete modifie!");
            	contenu=aiguilleur.lecture("nom du fichier edite"); 
                System.out.println(contenu);
            }
            else {
            	System.out.println("Erreur d'ecriture.");
            }
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
