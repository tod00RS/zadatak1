
public class Predmet {

	private int sifraPredmeta;
	private String nazivPredmeta;
	
	public Predmet() {
		
	}
	
	public Predmet(int sifraPredmeta, String nazivPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
	}
	
	@Override
	public String toString() {
		return " Sifra predmeta: " + sifraPredmeta + ", naziv: " + nazivPredmeta + ".";
	}
	
	public int getSifraPredmeta() {
		return sifraPredmeta;
	}
	public void setSifraPredmeta(int sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}
	public String getNazivPredmeta() {
		return nazivPredmeta;
	}
	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}
	
	
}
