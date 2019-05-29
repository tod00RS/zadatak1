import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ListaStudenata {

	private List<Student> studenti = new LinkedList<>();
	
	public void dodaj(Student student) {
		studenti.add(student);
	}
	
	public void ispis() {
		for (int i = 0; i < studenti.size(); i++) {
			System.out.println((i+1) + ". " + studenti.get(i));
		}System.out.println("");
	}
	
	public boolean sadrziBrIndeksa(String unos) {
		for(int i = 0; i < studenti.size(); i++) {
			if(unos.equals(studenti.get(i).getBrojIndeksa())) {
				return true;
			}
		}return false;
	}
	
	public void izborStudent(String unos) {
		for(int i = 0; i < studenti.size(); i++) {
			if(unos.equals(studenti.get(i).getBrojIndeksa())) {
				System.out.println("Izabrani student je: " + studenti.get(i));
				System.out.println("");
				break;
			}
		}
	}
	
	public void ispisPolozili(String unos) {
		for(int i = 0; i < studenti.size(); i++) {
			if(unos.equals(studenti.get(i).getBrojIndeksa())) {
				int k = 0;
				System.out.println("Broj indeksa: " + studenti.get(i).getBrojIndeksa() + ", ime: " + studenti.get(i).getIme() + ", prezime: " + studenti.get(i).getPrezime() );
			}
		}
		System.out.println("");
	}
	
	public void promenaStudent(String unos) {
		
		System.out.println("Izaberite opciju za promenu: ");
		System.out.println("1. Izmeni broj indeksa studenta");
		System.out.println("2. Izmeni godinu upisa studenta");
		System.out.println("3. Izmeni ime studenta");
		System.out.println("4. Izmeni prezime studenta");
		System.out.println("5. Izmeni datum rodjenja studenta");
		System.out.println("0. Povratak u glavni meni");
		
		Scanner izbor = new Scanner(System.in);
		int opcija = izbor.nextInt();
		
		switch(opcija) {
		
		case 1:
			for(int i = 0; i < studenti.size(); i++) {
				if(unos.equals(studenti.get(i).getBrojIndeksa())) {
					
					System.out.println("Uneti novi broj indeksa: ");
					Scanner izbor1 = new Scanner(System.in);
					String opcija2 = izbor1.nextLine();
					
					if(opcija2.matches("^\\d{2}[/]{1}\\d{2}")) { 
						studenti.add(i+1, new Student(opcija2, studenti.get(i).getGodUpisa(), studenti.get(i).getIme(), studenti.get(i).getPrezime(), studenti.get(i).getDatRod().toPattern()));
						studenti.remove(i);
						System.out.println("Uspesno ste promenili broj indeksa studenta!");
						System.out.println("Podaci o studentu posle izmene: ");
						System.out.println(studenti.get(i));
						System.out.println("");
						break;
				}else {
					System.out.println("Morate uneti broj indeksa u formi 'MM/yy'");
					System.out.println("");
					break;
				}
				}
			}break;
			
		case 2:
			for(int i = 0; i < studenti.size(); i++) {
				if(unos.equals(studenti.get(i).getBrojIndeksa())) {
					
					System.out.println("Uneti novu godinu upisa: ");
					Scanner izbor1 = new Scanner(System.in);
					int opcija2 = izbor1.nextInt();
					
					studenti.add(i+1, new Student(studenti.get(i).getBrojIndeksa(), opcija2, studenti.get(i).getIme(), studenti.get(i).getPrezime(), studenti.get(i).getDatRod().toPattern()));
					studenti.remove(i);
					System.out.println("Uspesno ste promenili godinu upisa studenta!");
					System.out.println("Podaci o studentu posle izmene: ");
					System.out.println(studenti.get(i));
					System.out.println("");
				}
			}break;
			
		case 3:
			for(int i = 0; i < studenti.size(); i++) {
				if(unos.equals(studenti.get(i).getBrojIndeksa())) {
					
					System.out.println("Uneti novo ime studenta: ");
					Scanner izbor1 = new Scanner(System.in);
					String opcija2 = izbor1.nextLine();
					
					studenti.add(i+1,new Student(studenti.get(i).getBrojIndeksa(), studenti.get(i).getGodUpisa(), opcija2, studenti.get(i).getPrezime(), studenti.get(i).getDatRod().toPattern()));
					studenti.remove(i);
					System.out.println("Uspesno ste promenili ime studenta!");
					System.out.println("Podaci o studentu posle izmene: ");
					System.out.println(studenti.get(i));
					System.out.println("");
				}
			}break;
			
		case 4:
			for(int i = 0; i < studenti.size(); i++) {
				if(unos.equals(studenti.get(i).getBrojIndeksa())) {
					
					System.out.println("Uneti novo prezime studenta: ");
					Scanner izbor1 = new Scanner(System.in);
					String opcija2 = izbor1.nextLine();
					
					studenti.add(i+1, new Student(studenti.get(i).getBrojIndeksa(), studenti.get(i).getGodUpisa(), studenti.get(i).getIme(), opcija2, studenti.get(i).getDatRod().toPattern()));
					studenti.remove(i);
					System.out.println("Uspesno ste promenili prezime studenta!");
					System.out.println("Podaci o studentu posle izmene: ");
					System.out.println(studenti.get(i));
					System.out.println("");
				}
			}break;
			
		case 5:
			for(int i = 0; i < studenti.size(); i++) {
				if(unos.equals(studenti.get(i).getBrojIndeksa())) {
					
					System.out.println("Uneti novi datum rodjenja: ");
					
					Scanner izbor1 = new Scanner(System.in);
					String opcija2 = izbor1.nextLine();
					
					if(opcija2.matches("^\\d{2}[/]{1}\\d{2}[/]{1}\\d{4}")) {
					
					SimpleDateFormat sdf = new SimpleDateFormat(opcija2);
					studenti.get(i).setDatRod(sdf);
					
					studenti.add(i+1, new Student(studenti.get(i).getBrojIndeksa(), studenti.get(i).getGodUpisa(), studenti.get(i).getIme(), studenti.get(i).getPrezime(), studenti.get(i).getDatRod().toPattern()));
					studenti.remove(i);
					System.out.println("Uspesno ste promenili datum rodjenja studenta!");
					System.out.println("Podaci o studentu posle izmene: ");
					System.out.println(studenti.get(i));
					System.out.println("");
					
					}else {
						System.out.println("Datum rodjenja morate uneti u formatu 'dd/MM/yyyy'");
						System.out.println("");
						
					}
				}
			}break;
			
		case 0:
			break;
			
		}
		
	}

}