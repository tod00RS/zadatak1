import java.text.SimpleDateFormat;
import java.util.Date;

public class Prijava {

	private String brInd;
	private int sifPred;
	private SimpleDateFormat datPol;
	private int ocena;
	
	public Prijava(String brInd, int sifPred,  String datPol, int ocena) {
		this.brInd = brInd;
		this.sifPred = sifPred;
		this.datPol = new SimpleDateFormat(datPol);
		this.ocena = ocena;
	}
	
	@Override
	public String toString() {
		return "Broj indeksa: " + brInd + ", sifra predmeta: " + sifPred + ", datum polaganja: " + datPol.toPattern() + ", ocena: " + ocena;
	}

	public String getBrInd() {
		return brInd;
	}

	public void setBrInd(String brInd) {
		this.brInd = brInd;
	}

	public int getSifPred() {
		return sifPred;
	}

	public void setSifPred(int sifPred) {
		this.sifPred = sifPred;
	}

	public SimpleDateFormat getDatPol() {
		return datPol;
	}

	public void setDatPol(SimpleDateFormat datPol) {
		this.datPol = datPol;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

}