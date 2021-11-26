package repartiteur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Machine extends Remote{
	 String lecture(String nomf) throws RemoteException, Exception;
	 boolean ecriture(String nomf, String data) throws RemoteException;
}
