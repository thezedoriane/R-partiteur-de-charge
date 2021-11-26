package repartiteur;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIMachine {
    public static void main(String[] args) throws Exception {
        try {
        	//On appel le registre au port 8000
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 8000);  
            //On demande a avoir l'aiguilleur appelle "nom aiguilleur"
            Aiguilleur aiguilleur = (Aiguilleur) registry.lookup("nom aiguilleur");
            System.out.println("Aiguilleur trouve");
            //On cree une machine que l'on exporte, pour l'ajouter a la liste des machines de l'aiguilleur
            MachineImp machinesup = new MachineImp();
            Machine ms = (Machine) UnicastRemoteObject.exportObject(machinesup, 0);
            System.out.println("Machine creer et exporter.");
            //Appel de la methode à distance
            System.out.println("Ajout de la machine a la liste de laiguilleur...");
            Boolean fait = aiguilleur.ajouterM(ms); 
            System.out.println("Machine ajoutee");
            //System.out.println(aiguilleur.lecture("f2.txt"));
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
