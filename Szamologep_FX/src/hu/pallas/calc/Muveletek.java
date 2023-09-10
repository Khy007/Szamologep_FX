package hu.pallas.calc;

public class Muveletek {
	
	private float szam_1;
	private float szam_2;
	private float resz_osszeg;
	private float osszeg;
	private float mem_osszeg;
	private char muv_jel;
	private boolean kerekites;
	private String uzenet;
	
	public float getSzam_1() {
		return szam_1;
	}
	public void setSzam_1(float szam_1) {
		this.szam_1 = szam_1;
	}
	public float getSzam_2() {
		return szam_2;
	}
	public void setSzam_2(float szam_2) {
		this.szam_2 = szam_2;
	}
	public float getResz_osszeg() {
		return resz_osszeg;
	}
	public void setResz_osszeg(float resz_osszeg) {
		this.resz_osszeg = resz_osszeg;
	}
	public float getOsszeg() {
		return osszeg;
	}
	public void setOsszeg(float osszeg) {
		this.osszeg = osszeg;
	}
	public float getMem_osszeg() {
		return mem_osszeg;
	}
	public void setMem_osszeg(float mem_osszeg) {
		this.mem_osszeg = mem_osszeg;
	}		
	public char getMuv_jel() {
		return muv_jel;
	}
	public void setMuv_jel(char muv_jel) {
		this.muv_jel = muv_jel;
	}
	public boolean isKerekites() {
		return kerekites;
	}
	public void setKerekites(boolean kerekites) {
		this.kerekites = kerekites;
	}
	public String getUzenet() {
		return uzenet;
	}
	public void setUzenet(String uzenet) {
		this.uzenet = uzenet;
	}
	public void szamNullazo() {
		setSzam_1(0);
		setSzam_2(0);
		setMuv_jel('0');
	}

	public void muveletProc() {
			
		System.out.println("Szamolas elott szam1: "  + szam_1);
		System.out.println("Szamolas elott muv_jel: "  + muv_jel);
		System.out.println("Szamolas elott szam2: "  + szam_2);
		
		switch (muv_jel) {
			
			case '+': //Összeadás
				
				if (isKerekites()) {
					resz_osszeg = Math.round(szam_1 + szam_2);						
				}else {
					resz_osszeg = szam_1 + szam_2;
				}
				szamNullazo();
				break;
			
			case '-': //Kivonás
				
				if (isKerekites()) {
					resz_osszeg = Math.round(szam_1 - szam_2);						
				}else {
					resz_osszeg = szam_1 - szam_2;
				}
				szamNullazo();
				break;
				
			case '*': //Szorzás
				
				if (isKerekites()) {
					resz_osszeg = Math.round(szam_1 * szam_2);						
				}else {
					resz_osszeg = szam_1 * szam_2;
				}
				szamNullazo();
				break;
				
			case '/': //Osztás
				
				if (szam_2 == 0.0f) {
					setUzenet("0-val osztas NEM LEHETSEGES");;
					
				}else if (isKerekites()) {
					resz_osszeg = Math.round(szam_1 / szam_2);						
				}else {
						resz_osszeg = szam_1 / szam_2;
				}			
				szamNullazo();
				break;
				
			case 5:
				break;
		
			default:
				System.out.println("Nincs muveleti jel ertelmezve, vagy szambevitel tortent!");
				break;
		}
		
		System.out.println("Szamolas utan szam1: "  + szam_1);
		System.out.println("Szamolas utan muv_jel: "  + muv_jel);
		System.out.println("Szamolas utan szam2: "  + szam_2);
		System.out.println("A szamolas eddig = " + getResz_osszeg());
		
	}
	

}
