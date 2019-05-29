import java.util.LinkedList;
import java.util.List;

public class ListaPredmeta extends Predmet{

	private List<Predmet> predmeti = new LinkedList<>();
	
	public void dodaj(Predmet predmet) {
		predmeti.add(predmet);
	}
	
	public void ispis() {
		for (int i = 0; i < predmeti.size(); i++) {
			System.out.println((i+1) + ". " + predmeti.get(i));
		}
		System.out.println("");
	}
	
	
	
	
	public boolean sadrziSifPred(int unos) {
		for(int i = 0; i < predmeti.size(); i++) {
			if(unos == predmeti.get(i).getSifraPredmeta()) {
				return true;
			}
		}
		return false;
	}
	
	
}
