import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Student {

	private String brojIndeksa;
	private int godUpisa;
	private String ime;
	private String prezime;
	private SimpleDateFormat datRod;
	
	public Student(String brojIndeksa, int godUpisa, String ime, String prezime, String datRod) {
		this.brojIndeksa = brojIndeksa;
		this.godUpisa = godUpisa;
		this.ime = ime;
		this.prezime = prezime;
		if(datRod.matches("^\\d{2}[/]{1}\\d{2}[/]{1}\\d{4}")) {
		this.datRod = new SimpleDateFormat(datRod);
		}
	}
	
	@Override
	public String toString() {
		return "Broj indeksa " + brojIndeksa + ", godina upisa: " + godUpisa + ", ime: " + ime + ", prezime: " + prezime + ", datum rodjenja: " + datRod.toPattern();
	}

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}

	public int getGodUpisa() {
		return godUpisa;
	}

	public void setGodUpisa(int godUpisa) {
		this.godUpisa = godUpisa;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public SimpleDateFormat getDatRod() {
		return datRod;
	}

	public void setDatRod(SimpleDateFormat datRod) {
		this.datRod = datRod;
	}
	
	
	
	
}
