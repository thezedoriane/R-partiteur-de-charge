package repartiteur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Notification extends Remote{
	public void charge(Machine m,int load) throws RemoteException;
}
