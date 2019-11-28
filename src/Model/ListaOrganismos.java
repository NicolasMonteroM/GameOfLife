package Model;

import java.util.LinkedList;

public class ListaOrganismos {
	
	private LinkedList<Organismo> listaOriginal;
	
	public ListaOrganismos() {
		listaOriginal = new LinkedList<Organismo>();
	}
	
	public void adicionar(Organismo organismo) {
		listaOriginal.add(organismo);
	}

	public LinkedList<Organismo> getListaOriginal() {
		return listaOriginal;
	}

	public void setListaOriginal(LinkedList<Organismo> listaOriginal) {
		this.listaOriginal = listaOriginal;
	}
}
