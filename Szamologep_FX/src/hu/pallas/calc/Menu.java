package hu.pallas.calc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class Menu implements ActionListener {

	JFrame frame;
	
	JLabel szamoltOsszeg = new JLabel();
	
	static JTextField kiiratas = new JTextField(10);
	
	JButton muveletElvegzo = new JButton("=");
	JButton osszeadoGomb = new JButton("+");
	JButton kivonoGomb = new JButton("-");
	JButton szorzoGomb = new JButton("*");
	JButton osztodGomb = new JButton("÷");
	JButton elojelGomb = new JButton("+/-");
	JButton tizedesGomb = new JButton(",");
	
	JButton nullaGomb = new JButton("0");
	JButton egyesGomb = new JButton("1");
	JButton kettesGomb = new JButton("2");
	JButton harmasGomb = new JButton("3");
	JButton negyesGomb = new JButton("4");
	JButton otosGomb = new JButton("5");
	JButton hatosGomb = new JButton("6");
	JButton hetesGomb = new JButton("7");
	JButton nyolcasGomb = new JButton("8");
	JButton kilencesGomb = new JButton("9");
	
	JButton ngyokGomb = new JButton("²√");
	JButton hatvanyGomb = new JButton("x²");
	JButton fuggvenyGomb = new JButton("1/x");	
	JButton visszaTorloGomb = new JButton("<");
	
	JButton torloGomb = new JButton("C");
	JButton reszTorloGomb = new JButton("CE");
	JButton szazalekGomb = new JButton("%");	
	JButton memTaroloGomb = new JButton("MS");
	JButton torlesAMembolGomb = new JButton("M-");
	JButton hozzaAdMemGomb = new JButton("M+");
	JButton memOlvasoGomb = new JButton("MR");
	JButton memTorloGomb = new JButton("MC");
		
	Border blackline;
	private String bemenet;
	private static Muveletek szamolo = (Muveletek)Program.factory.getBean("muveletek");
	private static Float eredmeny;
	private String szam1 = "";
	private String szam2 = "";
	private String muvJel = "";
	private String tempSzam1 = "";
	private String tempSzam2 = "";
	private String tempJel = "";
	private int jelolo;
	private String[] muvSor = new String[3];
	private boolean egyszeruSzamolo = true;
			
	public boolean isEgyszeruSzamolo() {
		return egyszeruSzamolo;
	}

	public void setEgyszeruSzamolo(boolean egyszeruSzamolo) {
		this.egyszeruSzamolo = egyszeruSzamolo;
	}

		Menu() {

			ablakKeszit();
			addActionEvents();	
		}
	
	

	public void ablakKeszit() {
				frame = new JFrame();
				//Ablak megnevezése
				frame.setTitle("Bazsi Pallas SZAMOLOGEP");
				//Ablakot nem engedi szétesni, arányosan mozgatja
				frame.getContentPane().setLayout(null);
				//Ablak háttérszínének megadása
				frame.getContentPane().setBackground(Color.gray);
				//Ablak mérete px
				frame.setSize(216,415);
				//Ablak mindig a képernyő közepére kerüljön
				frame.setLocationRelativeTo(null);
				//Ablak látszódjon vagy ne booleannal beállítva
				frame.setVisible(true);
				//Ablak "X" gomb mit csináljon
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				blackline = BorderFactory.createLineBorder(Color.black);
				
				
				//Gombok formázása elhelyezkedése és mérete	
				
				kiiratas.setEditable(false);
				kiiratas.setBounds(0, 20, 200, 40);
				kiiratas.setHorizontalAlignment(JTextField.RIGHT);
				frame.add(kiiratas);				
				szamoltOsszeg.setBounds(0, 0, 200, 20);
				szamoltOsszeg.setBackground(Color.LIGHT_GRAY);
				szamoltOsszeg.setOpaque(true);
				szamoltOsszeg.setBorder(blackline);
				frame.add(szamoltOsszeg);
				
				muveletElvegzo.setBounds(151, 330, 50, 50);
				frame.add(muveletElvegzo);
				tizedesGomb.setBounds(101, 330, 50, 50);
				frame.add(tizedesGomb);
				nullaGomb.setBounds(51, 330, 50, 50);
				frame.add(nullaGomb);
				elojelGomb.setBounds(1, 330, 50, 50);
				frame.add(elojelGomb);
				
				osszeadoGomb.setBounds(151, 280, 50, 50);
				frame.add(osszeadoGomb);
				harmasGomb.setBounds(101, 280, 50, 50);
				frame.add(harmasGomb);
				kettesGomb.setBounds(51, 280, 50, 50);
				frame.add(kettesGomb);
				egyesGomb.setBounds(1, 280, 50, 50);
				frame.add(egyesGomb);
				
				kivonoGomb.setBounds(151, 230, 50, 50);
				frame.add(kivonoGomb);
				hatosGomb.setBounds(101, 230, 50, 50);
				frame.add(hatosGomb);
				otosGomb.setBounds(51, 230, 50, 50);
				frame.add(otosGomb);
				negyesGomb.setBounds(1, 230, 50, 50);
				frame.add(negyesGomb);
				
				szorzoGomb.setBounds(151, 180, 50, 50);
				frame.add(szorzoGomb);
				kilencesGomb.setBounds(101, 180, 50, 50);
				frame.add(kilencesGomb);
				nyolcasGomb.setBounds(51, 180, 50, 50);
				frame.add(nyolcasGomb);
				hetesGomb.setBounds(1, 180, 50, 50);
				frame.add(hetesGomb);
				
				osztodGomb.setBounds(151, 130, 50, 50);
				frame.add(osztodGomb);
				ngyokGomb.setBounds(101, 130, 50, 50);
				frame.add(ngyokGomb);
				hatvanyGomb.setBounds(51, 130, 50, 50);
				frame.add(hatvanyGomb);
				fuggvenyGomb.setBounds(1, 130, 50, 50);
				fuggvenyGomb.setFont(new Font("arial", Font.CENTER_BASELINE, 10));
				frame.add(fuggvenyGomb);
				
				visszaTorloGomb.setBounds(151, 80, 50, 50);
				frame.add(visszaTorloGomb);
				torloGomb.setBounds(101, 80, 50, 50);
				frame.add(torloGomb);
				reszTorloGomb.setBounds(51, 80, 50, 50);
				reszTorloGomb.setFont(new Font("arial", Font.CENTER_BASELINE, 10));
				frame.add(reszTorloGomb);
				szazalekGomb.setBounds(1, 80, 50, 50);
				frame.add(szazalekGomb);
				
				memTaroloGomb.setBounds(160, 60, 40, 20);
				memTaroloGomb.setFont(new Font("arial", Font.CENTER_BASELINE, 4));
				memTaroloGomb.setToolTipText("MS");
				frame.add(memTaroloGomb);
				torlesAMembolGomb.setBounds(120, 60, 40, 20);
				torlesAMembolGomb.setFont(new Font("arial", Font.CENTER_BASELINE, 4));
				torlesAMembolGomb.setToolTipText("M-");
				frame.add(torlesAMembolGomb);
				hozzaAdMemGomb.setBounds(80, 60, 40, 20);
				hozzaAdMemGomb.setFont(new Font("arial", Font.CENTER_BASELINE, 4));
				hozzaAdMemGomb.setToolTipText("M+");
				frame.add(hozzaAdMemGomb);
				memOlvasoGomb.setBounds(40, 60, 40, 20);
				memOlvasoGomb.setFont(new Font("arial", Font.CENTER_BASELINE, 4));
				memOlvasoGomb.setToolTipText("MR");
				frame.add(memOlvasoGomb);
				memTorloGomb.setBounds(1, 60, 39, 20);
				memTorloGomb.setFont(new Font("arial", Font.CENTER_BASELINE, 4));
				memTorloGomb.setToolTipText("MC");
				frame.add(memTorloGomb);	
				
				osztodGomb.setActionCommand("/");
				tizedesGomb.setActionCommand(".");
				
				torloGomb.addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						kiiratas.setText("");
						ertekNullazo();
					}
				});
				memTaroloGomb.addActionListener(new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						szamolo.setMem_osszeg(eredmeny);						
					}
				});
				memTorloGomb.addActionListener(new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						szamolo.setMem_osszeg(0);						
					}
				});
				memOlvasoGomb.addActionListener(new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						szamoltOsszeg.setText("Memoria: " + szamolo.getMem_osszeg());						
					}
				});
				hozzaAdMemGomb.addActionListener(new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						szamolo.setMem_osszeg(szamolo.getMem_osszeg() + eredmeny );						
					}
				});
				torlesAMembolGomb.addActionListener(new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						szamolo.setMem_osszeg(szamolo.getMem_osszeg() - eredmeny );	
					}
				});	
	}
		
	public void addActionEvents() {
			
			muveletElvegzo.addActionListener(this);
			tizedesGomb.addActionListener(this);
			elojelGomb.addActionListener(this);
			osszeadoGomb.addActionListener(this);
			kivonoGomb.addActionListener(this);
			szorzoGomb.addActionListener(this);
			osztodGomb.addActionListener(this);
			visszaTorloGomb.addActionListener(this);
			reszTorloGomb.addActionListener(this);
			
			nullaGomb.addActionListener(this);
			egyesGomb.addActionListener(this);
			kettesGomb.addActionListener(this);
			harmasGomb.addActionListener(this);
			negyesGomb.addActionListener(this);
			otosGomb.addActionListener(this);
			hatosGomb.addActionListener(this);
			hetesGomb.addActionListener(this);
			nyolcasGomb.addActionListener(this);
			kilencesGomb.addActionListener(this);
					
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
			bemenet = e.getActionCommand();	
			kiiratas.setText(kiiratas.getText() + bemenet);	
			
			if (e.getSource() == visszaTorloGomb) {
				kiiratas.setText(kiiratas.getText().substring(0, kiiratas.getText().length()-2));		
			}	
			
			if (e.getSource() == reszTorloGomb) {
				bemenetAlakito(kiiratas.getText());
				
					if (muvSor[2].isEmpty() && muvSor[1].isEmpty()) {
						//Első szám törlése
						szam1 = "";
						kiiratas.setText(null);
					}else if (muvSor[2].isEmpty()) {
						//Műveleti jel törlés;
						kiiratas.setText(kiiratas.getText().substring(0, kiiratas.getText().length()-3));
						muvJel = "";
						tempSzam1 = kiiratas.getText();
					}else {
						//Második szám törlése
						kiiratas.setText(kiiratas.getText().substring(0, (kiiratas.getText().length()-2) - muvSor[2].length()));
						tempSzam1 = kiiratas.getText().substring(0, (kiiratas.getText().length()-1));						
						tempJel = kiiratas.getText().substring(tempSzam1.length(), kiiratas.getText().length());						
						szam2 = "";
						jelolo += ((kiiratas.getText().length()-2) + muvSor[2].length());
						tempSzam2 = "n";						
					}
			}	
			
			if (e.getSource() == elojelGomb) {
				bemenetAlakito(kiiratas.getText());
				
						
				if (muvSor[2].isEmpty() && muvSor[1].isEmpty()) {
					//Első szám előjelváltása
					System.out.println("Elso szam elojel valtas");
				}else {
					//Második szám előjelváltása
					System.out.println("Masodik szam elojel valtas");				
				}
					
			
			}
			if (e.getSource() == muveletElvegzo) {				
				bemenetAlakito(kiiratas.getText());
				eredmenySzamolProc();
				kiiratas.setText(kiiratas.getText() + eredmeny);
				szamoltOsszeg.setText(eredmeny.toString());
			}
			
	}	
		
	public void tempAlakito(String input) {
			char[] temp = input.toCharArray();
			tempSzam2 = "";
			
			for (int i = jelolo; i < temp.length; i++) {
				if (temp[i] >= '0' && temp[i] <= '9' || temp[i] == '.') {
					tempSzam2 += temp[i];
				}
			}
	}
		
	public void bemenetAlakito(String input) {
					
		    char[] arr = input.toCharArray();
		    
		    for (int i = 0; i < arr.length; i++) {
			    if (arr[i] >= '0' && arr[i] <= '9' || arr[i] == '.') {
			    	if(szam2.isEmpty() && muvJel.isEmpty()){
			               szam1 += arr[i];
			        }else{
			               szam2 += arr[i];
			         }
			     }  
			      
			     if(arr[i] == '+' || arr[i] == '-' || arr[i] == '/' || arr[i] == '*') {
			            muvJel += arr[i];
			     }
			  } 
		      
		      if (tempSzam1.isEmpty()) {
		    	  muvSor[0] = szam1;
		      } else muvSor[0] = tempSzam1;
		      
		      if (tempJel.isEmpty()) {
		    	  muvSor[1] = muvJel;		    	 
		      }else muvSor[1] = tempJel; 
		      
		      if (tempSzam2.isEmpty()) {
		    	  muvSor[2] = szam2;
		      }else {
		    	tempAlakito(kiiratas.getText());
				muvSor[2] = tempSzam2;
		      }
		     
	}
				
	public void eredmenySzamolProc() {
			
			 szamolo.setSzam_1(Float.parseFloat(muvSor[0]));
		     szamolo.setSzam_2(Float.parseFloat(muvSor[2]));
		     szamolo.setMuv_jel(muvSor[1].charAt(0));	
		     
		     szamolo.muveletProc();
		     ertekNullazo();
		    
		     eredmeny = szamolo.getResz_osszeg();		
	}
		
	public void ertekNullazo() {
			
			szam1 = "";
		    szam2 = "";
		    muvJel = "";
			
	}
}