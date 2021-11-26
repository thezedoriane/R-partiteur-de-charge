package repartiteur;

import java.rmi.RemoteException;

public class Client {

 public Client(){
 }

 public void ecriture(AiguilleurImp a, String nomf, String data) throws RemoteException {
  a.ecriture(nomf, data);
 }

 public void lecture(AiguilleurImp a, String nomf) throws Exception {
  a.lecture(nomf);
 }

 

  

 

 


}