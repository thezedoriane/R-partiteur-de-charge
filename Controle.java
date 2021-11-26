package repartiteur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Controle extends Remote{
	boolean ajouterM(Machine m) throws RemoteException;
	Machine retirerM() throws RemoteException;
}
