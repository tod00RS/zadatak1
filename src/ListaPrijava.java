import java.util.LinkedList;
import java.util.List;

public class ListaPrijava {

	private List<Prijava> prijave = new LinkedList<>();
	
	public void dodaj(Prijava prijava) {
		prijave.add(prijava);
	}
	
	public void ispis() {
		if(prijave.size() > 0) {
			for (int i = 0; i < prijave.size(); i++) {
				System.out.println((i+1) + ". " + prijave.get(i));
			}
		}else {
			System.out.println("U sistemu nema prijava.");
		}
	}
	
	public boolean praznaLista() {
		if(prijave.size() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public void spisakPrijavaStudenta(String unos) {
		if(prijave.size()>0) {
		for(int i = 0; i < prijave.size(); i++) {
			if(unos.equals(prijave.get(i).getBrInd())) {
				System.out.println(prijave.get(i));
			}
		}
		System.out.println("");
		}else {
			System.out.println("U sistemu nema unetih prijava.");
			System.out.println("");
		}
	}
	
	public boolean polozioJe(int unos2, String unos3) {
			for(int i = 0; i < prijave.size(); i++) {
				if(unos2 == prijave.get(i).getSifPred()) {
					if(unos3.equals(prijave.get(i).getBrInd())) {
						if(!(prijave.get(i).getOcena() < 6)) {
							System.out.println("Student je vec polozio ovaj predmet!");
							System.out.println("");
							return true;
						}
				}
			}
		}return false;
	}
	
	public boolean pozOcena(int unos) {
		for(int i = 0; i < prijave.size(); i++) {
			if(unos == prijave.get(i).getSifPred()) {
				if(prijave.get(i).getOcena()>5) {
					return true;
				}
			}
		}return false;
	}
	
	public void polozili(int unos, ListaStudenata studenti) {
		for(int i = 0; i < prijave.size(); i++) {
			if(unos == prijave.get(i).getSifPred()) {
				if(prijave.get(i).getOcena() > 5) {
					String brInd = prijave.get(i).getBrInd();
					studenti.ispisPolozili(brInd);
				}
			}
		}
	}
	
	public boolean predmetNemaOcena(int sifraPredmeta) {
		for(int i = 0; i < prijave.size(); i++) {
			if(prijave.get(i).getSifPred() == sifraPredmeta) {
				return false;
			}
		}return true;
	}
	
}
