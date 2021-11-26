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
            //On demande à avoir l'aiguilleur appelle "hello"
            Aiguilleur aiguilleur = (Aiguilleur) registry.lookup("hello"); 
            //Appel de la methode a distance
            String contenu=aiguilleur.lecture("f2.txt"); 
            System.out.println(contenu);
            String data="Bonjour\nJe m'appelle Doriane. \nEt je travaille avec Xin qui est trop choupi!";
            Boolean ecrit=aiguilleur.ecriture("f1.txt", data);
            if (ecrit) {
            	System.out.println("Le fichier a été modifié!");
            	contenu=aiguilleur.lecture("f1.txt"); 
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