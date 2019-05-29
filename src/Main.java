import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ListaStudenata studenti = new ListaStudenata();
		
		studenti.dodaj(new Student("01/98", 1998, "Jovan", "Jovanovic", "02/10/1998"));
		studenti.dodaj(new Student("02/98", 1998, "Zoran", "Nikolic", "28/09/1986"));
		studenti.dodaj(new Student("03/98", 1998, "Petar", "Lazic", "18/11/1988"));
		studenti.dodaj(new Student("04/98", 1998, "Milan", "Mirkovic", "03/02/1999"));
		studenti.dodaj(new Student("05/98", 1998, "Janko", "Popovic", "13/12/2000"));
		studenti.dodaj(new Student("06/98", 1998, "Jakov", "Petrovic", "24/04/1988"));
		
		ListaPredmeta predmeti = new ListaPredmeta();
		
		predmeti.dodaj(new Predmet(100, "Matematika"));
		predmeti.dodaj(new Predmet(200, "Fizika"));
		predmeti.dodaj(new Predmet(300, "Engleski jezik"));
		predmeti.dodaj(new Predmet(400, "Sociologija"));
		predmeti.dodaj(new Predmet(500, "Informatika"));
		predmeti.dodaj(new Predmet(600, "Nacrtna geometrija"));
		
		ListaPrijava prijave = new ListaPrijava();
		
		int opcija = 0;
		
		do {
			
			try {
			
			System.out.println("Izaberite neku od opcija: ");
			System.out.println("1. Pregled");
			System.out.println("2. Unos nove prijave");
			System.out.println("3. Izmena");
			System.out.println("0. Kraj programa");
			
			
			Scanner izbor = new Scanner(System.in);
			opcija = izbor.nextInt();
			
			switch(opcija) {
				case 1:
					System.out.println("Izaberite opciju:");
					System.out.println("1. Prikaz svih predmeta");
					System.out.println("2. Prikaz svih studenata");
					System.out.println("3. Prikaz svih prijava za trazenog studenta");
					System.out.println("4. Prikaz svih studenata koji su polozili odabrani predmet");
					System.out.println("0. Povratak u glavni meni");
					
					int opcija1;
					
					Scanner izbor1 = new Scanner(System.in);
					opcija1 = izbor1.nextInt();
					
					switch(opcija1) {
					case 1:
						predmeti.ispis();
						break;
						
					case 2:
						studenti.ispis();
						break;
						
					case 3:
						if(!prijave.praznaLista()) {
						System.out.println("Unesite broj indeksa studenta cije prijave zelite da vidite: ");
						
						String opcija8;
						
						Scanner izbor8 = new Scanner(System.in);
						opcija8 = izbor8.nextLine();
						
						
						if(studenti.sadrziBrIndeksa(opcija8)) {
							prijave.spisakPrijavaStudenta(opcija8);
							break;
						}else {
							System.out.println("Uneti broj indeksa ne postoji u sistemu.");
							System.out.println("Pokusajte ponovo.");
							System.out.println("");
							break;
						}
						}else {
							System.out.println("Lista prijava je prazna!");
							System.out.println("");
							break;
						}
						
					case 4:
						System.out.println("Unesite sifru zeljenog predmeta:");
						
						int opcija9;
						Scanner izbor9 = new Scanner(System.in);
						opcija9 = izbor9.nextInt();
						
						if(!prijave.predmetNemaOcena(opcija9)) {
							if(prijave.pozOcena(opcija9)) {
								prijave.polozili(opcija9,studenti);
							}else {
								System.out.println("Nema studenata sa pozitivnom ocenom iz biranog predmeta.");
								System.out.println("");
							}
						}else {
							System.out.println("Nema studenata koji su polozili, niti prijava sa ocenom 5 za trazeni predmet!");
							System.out.println("");
						}
					
					case 0:
						break;
						
					default:
						System.out.println("Neispravan unos. Pokusajte ponovo");
						System.out.println("");
						break;
					}break;
					
				case 2:
					
					int unos;
					String unos2;
					String unos3;
					int unos4;
					
					System.out.println("Unesite sifru predmeta: ");
					
					Scanner izbor2 = new Scanner(System.in);
					unos = izbor2.nextInt();
					
					if(predmeti.sadrziSifPred(unos)) {
						
						System.out.println("Unesite broj indeksa studenta: ");
						
						Scanner izbor3 =new Scanner(System.in);
						unos2 = izbor3.nextLine();
						
						if (!(prijave.polozioJe(unos, unos2))) {
							if (studenti.sadrziBrIndeksa(unos2)) {
								System.out.println("Unesite datum polaganja: ");
	
								Scanner izbor4 = new Scanner(System.in);
								unos3 = izbor4.nextLine();
								
								if(unos3.matches("^\\d{2}[/]{1}\\d{2}[/]{1}\\d{4}")) {
									System.out.println("Unesite ocenu: ");
	
									Scanner izbor5 = new Scanner(System.in);
									unos4 = izbor5.nextInt();
									if (unos4 < 5 || unos4 > 10) {
										System.out.println("Ocena moze biti u intervalu  od 5 do 10.");
										System.out.println("");
										break;
									}
									if (prijave.polozioJe(unos, unos2)) {
										break;
									} else {
										Prijava prijava = new Prijava(unos2, unos, unos3, unos4);
										prijave.dodaj(prijava);
										System.out.println("Uspesno ste uneli novu prijavu!");
										System.out.println("");
										break;
									}
								}else {
									System.out.println("Datum polaganja morate uneti u formi: 'dd/MM/yyyy'");
									System.out.println("");
									break;
								}
								
	
							} else {
								System.out.println("Uneti broj indeksa ne postoji!");
								System.out.println("");
								break;
							} 
						}else {
							break;
						}
						
					}else {
						System.out.println("Uneta sifra predmeta ne postoji!");
						System.out.println("");
						break;
						
					}
				
						
				
				case 3:
					System.out.println("Izaberite opciju:");
					System.out.println("1. Promena podataka studenta");
					System.out.println("0. Povratak u glavni meni");
					
					int opcija6;
					
					Scanner izbor6 = new Scanner(System.in);
					opcija6 = izbor6.nextInt();
					
					switch(opcija6) {
					case 1:
						System.out.println("Upisite broj indeksa studenta cije podatke zelite da promenite: ");
						
						String opcija7;
						
						Scanner izbor7 = new Scanner(System.in);
						opcija7 = izbor7.nextLine();
						
						if(opcija7.matches("^\\d{2}[/]{1}\\d{2}")){ 
						if(studenti.sadrziBrIndeksa(opcija7)) {
						studenti.izborStudent(opcija7);
						studenti.promenaStudent(opcija7);
						break;
						}else {
							System.out.println("Ne postoji student sa unetim brojem indeksa!");
							System.out.println("");
							break;
						}
						}else {
							System.out.println("Morate uneti broj indeksa u formi 'MM/yy'");
							System.out.println("");
							break;
						}
					case 0: 
						break;
					}break;
					
				case 0:
					break;
					
				default:
						System.out.println("Neispravan unos. Pokusajte ponovo!");
						System.out.println("");
						break;
					
			}
			}catch (InputMismatchException iMe) {
				System.out.println("Neispravan unos. Pokusajte ponovo!");
				System.out.println("");
				opcija++;
			}
		}while (opcija!=0);
	
		}
}
