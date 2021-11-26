package repartiteur;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.concurrent.CountDownLatch;

public class Registry {
    public static void main(String[] args) throws InterruptedException{
        try {
        	//Il se place sur le port 8000
            LocateRegistry.createRegistry(8000); 
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        CountDownLatch latch=new CountDownLatch(1);
        //Lancer le thread principal sinon rmi exit
        System.out.println("Lancement du thread...");
        latch.await(); 
    }
}