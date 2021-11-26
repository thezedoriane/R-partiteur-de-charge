package repartiteur;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RMIAiguilleur {

    public static void main(String[] args) {
    	ArrayList<Machine> listeM = new ArrayList<Machine>();
        Aiguilleur aiguilleur = new AiguilleurImp(listeM);
        try {
        	//Pour importer le serveur on utilise le port 4000
            Aiguilleur stub = (Aiguilleur) UnicastRemoteObject.exportObject(aiguilleur, 4000); 
            //Appel de la methode getRegistry sur le port 8000 définie
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 8000); 
            //On attribue le nom "hello" à l'aiguilleur dans le registre
            registry.bind("hello", stub); 
            System.out.println("Aiguilleur enregistrer dans le registre");
        } catch (AlreadyBoundException | IOException e) {
            e.printStackTrace();
        }

    }
}