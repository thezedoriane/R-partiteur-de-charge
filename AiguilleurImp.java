package repartiteur;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class AiguilleurImp implements Aiguilleur{
	
	public ArrayList<Machine> listeM;
	
	public AiguilleurImp(ArrayList<Machine> lm) {
		this.listeM=lm;
	}

	@Override
	public String lecture(String nomf) throws RemoteException, Exception {
		String contenu = "";
		//on demande a une machine de lire le fichier et de renvoyer le contenu
		Machine m = retirerM();
		System.out.println(m);
		contenu = m.lecture(nomf);
		ajouterM(m);
		return contenu;
	}

	@Override
	public boolean ecriture(String nomf, String data) throws RemoteException {
		//on demande à une machine de reecrire le fichier et de renvoyer si c est fait avec un boolean
		boolean fait = false;
		Machine m = retirerM();
		System.out.println(m);
		fait = m.ecriture(nomf,data);
		ajouterM(m);
		return fait;
	}

	@Override
	public boolean ajouterM(Machine m) throws RemoteException {
		//On ajoute la machine à la fin de la liste et on renvoie si l'action a reussi avec un boolean
		if (listeM.add(m)) {
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public Machine retirerM() throws RemoteException {
		//On recupere la premiere machine de la liste en la retirant de la liste
		Machine m =listeM.remove(0);
		return m;
	}

}
