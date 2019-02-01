package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hibernate.HibernateSOA;
import Model.Books;
import Model.GeciciRating;
import Model.Session;

import javax.swing.JTextPane;
import java.awt.Color;

public class KitapSecimi extends JFrame {
	protected static List<GeciciRating> rating = new ArrayList<GeciciRating>();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected static HibernateSOA cont = new HibernateSOA();
	@SuppressWarnings("unchecked")
	protected static List<Books> books = cont.findAll(Books.class);
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					KitapSecimi frame = new KitapSecimi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	JTextPane[] KitapFoto = new JTextPane[300000];
	JTextPane[] KitapFoto2 = new JTextPane[300000];

	JTextPane[] KitapAdi = new JTextPane[300000];
	JTextPane[] KitapAdi2 = new JTextPane[300000];

	JTextPane[] KitapYazari = new JTextPane[300000];
	JTextPane[] KitapYazari2 = new JTextPane[300000];

	JTextPane[] KitapIsbn = new JTextPane[300000];
	JTextPane[] KitapIsbn2 = new JTextPane[300000];

	JTextPane[] KitapYil = new JTextPane[300000];
	JTextPane[] KitapYil2 = new JTextPane[300000];

	JTextPane[] KitapOylama = new JTextPane[300000];
	JTextPane[] KitapOylama2 = new JTextPane[300000];

	JButton[] KitapOyUstIleri = new JButton[360000];
	JButton[] KitapOyAltIleri2 = new JButton[360000];

	JButton[] KitapOyUstGeri = new JButton[360000];
	JButton[] KitapOyAltGeri2 = new JButton[360000];

	JButton tamamla = new JButton("Tamamla ve Devam Et");

	JTextPane[] label2 = new JTextPane[270000];
	JTextPane sayfa = new JTextPane();

	String[][] oylamaTablosu = new String[300000][2];

	int yolla = 0, yolla2 = 0;

	public KitapSecimi() {
		int userId = cont.getUserId(); 
		System.out.println(userId + "------------>");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(40, 10, 1300, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ListeleUst(0);
		ListeleAlt(0);

		sayfa.setText("0");
		sayfa.setBounds(624, 623, 41, 23);
		contentPane.add(sayfa);

		JButton ileri = new JButton(">");
		ileri.setBounds(676, 623, 41, 23);
		contentPane.add(ileri);

		JButton geri = new JButton("<");
		geri.setBounds(573, 623, 41, 23);
		contentPane.add(geri);

		JButton son = new JButton(">>");
		son.setBounds(718, 623, 56, 23);
		contentPane.add(son);

		JButton bas = new JButton("<<");
		bas.setBounds(519, 623, 56, 23);
		contentPane.add(bas);

		tamamla.setBounds(915, 623, 175, 23);
		contentPane.add(tamamla);

		bas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				sayfa.setText("0");
				ListeleUst(0);
				ListeleAlt(0);
			}
		});

		ileri.addActionListener(new ActionListener() {
			int de = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int ileri = Integer.parseInt(sayfa.getText());

				if (ileri >= 0) {
					sayfa.setText("0");
					bas.setEnabled(true);
					geri.setEnabled(true);

				}

				ileri++;

				sayfa.setText(String.valueOf(ileri));

				ListeleUst(ileri);
				ListeleAlt(ileri);

			}
		});

		geri.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int gerii = Integer.parseInt(sayfa.getText());
				gerii--;

				sayfa.setText(String.valueOf(gerii));
				int sifir = Integer.parseInt(sayfa.getText());

				if (sifir <= 0) {
					sayfa.setText("0");
					bas.setEnabled(false);
					geri.setEnabled(false);

				}

				ListeleUst(gerii);
				ListeleAlt(gerii);

			}
		});
		son.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int sonSayfa = books.size();
				sonSayfa = sonSayfa / 18;
				
				sayfa.setText(String.valueOf(sonSayfa));
				ileri.setEnabled(false);
				ListeleUst(sonSayfa);
				ListeleAlt(sonSayfa);
				
			}
		});
		tamamla.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int say = 0;

				
				for (int i = 0; i <= books.size(); i++) {
					
					if (oylamaTablosu[i][0] != null && oylamaTablosu[i][0].length()>0) {

						say++;
					}

				}
				
				
				
				
				
				
				if (say >= 10) {
					
					
					for (int i = 0; i <= books.size(); i++) {
						
						if (oylamaTablosu[i][0] != null && oylamaTablosu[i][0].length()>0) {
							
							GeciciRating tempRat = new GeciciRating();
							tempRat.setUserId(userId);
							tempRat.setIsbn(oylamaTablosu[i][0]);
							tempRat.setRating(Integer.parseInt(oylamaTablosu[i][1]));
							ekle(tempRat);
						}

					}
					
					DBCreate();
					dispose();
					Anasayfa anasayfa = new Anasayfa();
					anasayfa.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null,"10 oy verilmedi..");
				}
				
			}
		});

	}
	public void ekle(GeciciRating temp) {
		rating.add(temp);
	}
	public void DBCreate() {
		for (int i = 0; i < rating.size(); i++) {
			cont.save(rating.get(i));
			System.out.println(rating.get(i).toString());
		}
	}
	@SuppressWarnings("unchecked")
	public void ListeleUst(int deger) {

		deger = deger * 2 + 1;
		int z = (9 * deger) - 9;

		int j = 0;

		for (int i = z; i < 9 * deger; i++) {

			KitapFoto[i] = new JTextPane();

			URL url = null;
			try {
				url = new URL(books.get(i).getImageURLM());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			BufferedImage image = null;
			try {
				image = ImageIO.read(url);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			KitapFoto[i].insertIcon(new ImageIcon(image));
			getContentPane().add(KitapFoto[i]);

			KitapFoto[i].setBounds((26 + j), 42, 127, 166);
			contentPane.add(KitapFoto[i]);

			KitapAdi[i] = new JTextPane();
			KitapAdi[i].setText(books.get(i).getBookTitle());
			KitapAdi[i].setBounds(26 + j, 11, 127, 20);
			contentPane.add(KitapAdi[i]);

			KitapYazari[i] = new JTextPane();
			KitapYazari[i].setText(books.get(i).getBookAuthor());
			KitapYazari[i].setBackground(Color.LIGHT_GRAY);
			KitapYazari[i].setBounds(26 + j, 205, 127, 42);
			contentPane.add(KitapYazari[i]);

			KitapIsbn[i] = new JTextPane();
			KitapIsbn[i].setText(books.get(i).getISBN());
			KitapIsbn[i].setBackground(Color.GRAY);
			KitapIsbn[i].setBounds(68 + j, 250, 85, 20);
			contentPane.add(KitapIsbn[i]);

			KitapYil[i] = new JTextPane();
			KitapYil[i].setText(String.valueOf(books.get(i).getYearOfPublication()));
			KitapYil[i].setBounds(26 + j, 250, 41, 20);
			contentPane.add(KitapYil[i]);

			KitapOylama[i] = new JTextPane();
			KitapOylama[i].setText("0");
			KitapOylama[i].setBounds(77 + j, 281, 23, 22);

			contentPane.add(KitapOylama[i]);

			KitapOyUstGeri[i] = new JButton();
			KitapOyUstGeri[i].setText("<");
			KitapOyUstGeri[i].setBounds(33 + j, 281, 41, 23);
			contentPane.add(KitapOyUstGeri[i]);

			KitapOyUstIleri[i] = new JButton();
			KitapOyUstIleri[i].setText(">");
			KitapOyUstIleri[i].setBounds(99 + j, 281, 41, 23);
			contentPane.add(KitapOyUstIleri[i]);

			int a = i;
			String sifir = "0";
			KitapOyUstIleri[i].addActionListener(new ActionListener() {
				@Override

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int sayt = Integer.parseInt(sayfa.getText());
					int ileri = Integer.parseInt(KitapOylama[a].getText());
					KitapOyUstGeri[a].setEnabled(true);

					if (ileri >= 9) {
						KitapOylama[a].setText("10");
						KitapOyUstIleri[a].setEnabled(false);
						KitapOyUstGeri[a].setEnabled(true);
					}

					ileri++;
					KitapOylama[a].setText(String.valueOf(ileri));

					yolla = (18 * sayt) + a;

					tamam(yolla);

				}
			});

			if (sifir.equals(KitapOylama[a].getText()))
				KitapOyUstGeri[a].setEnabled(false);
			KitapOyUstGeri[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int sayt = Integer.parseInt(sayfa.getText());
					KitapOyUstIleri[a].setEnabled(true);
					int geri = Integer.parseInt(KitapOylama[a].getText());
					String sifir = "0";
					if (sifir.equals(KitapOylama[a].getText())) {
						KitapOyUstGeri[a].setEnabled(false);
						
						

					}
					if (geri <= 1) {
						KitapOylama[a].setText("0");
						KitapOyUstGeri[a].setEnabled(false);
						KitapOyUstIleri[a].setEnabled(true);
						yolla = (18 * sayt) + a;
						tamamSil(yolla);
					}
					geri--;
					KitapOylama[a].setText(String.valueOf(geri));
				}
			});

			j = j + 137;

		}

	}

	public int tamam(int b) {

		int mod = b % 9;

		if (b >= 0) {

			int cek = Integer.parseInt(KitapOylama[mod].getText());

			if (cek >= 0) {
				

				oylamaTablosu[b][0] = String.valueOf(books.get(b).getISBN());
				oylamaTablosu[b][1] = String.valueOf(cek);


			}
		}
	
		return 0;
	}
	
	public int tamamSil(int b) {


				oylamaTablosu[b][0] = null;
				oylamaTablosu[b][1] = null;


		return 0;
	}

	
	public int tamam2(int b) {

		int mod = b % 9;

		if (b >= 0) {

			int cek = Integer.parseInt(KitapOylama2[mod].getText());

			if (cek >= 0) {
					
				oylamaTablosu[b][0] = String.valueOf(books.get(b).getISBN());
				oylamaTablosu[b][1] = String.valueOf(cek);
			}
		}

		return 0;
	}
	
	public int tamam2Sil(int b) {


		oylamaTablosu[b][0] = null;
		oylamaTablosu[b][1] = null;


return 0;
}

	@SuppressWarnings("unchecked")
	public void ListeleAlt(int deger2) {

		deger2 = deger2 * 2 + 1;
		int j2 = 0;
		int dokuz = 9;
		int zz = (dokuz * deger2) - 9;
		for (int ii = zz; ii < 9 * deger2; ii++) {

			KitapFoto2[ii] = new JTextPane();
			URL url2 = null;
			try {
				url2 = new URL(books.get(ii + dokuz).getImageURLM());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			BufferedImage image2 = null;
			try {
				image2 = ImageIO.read(url2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			KitapFoto2[ii].insertIcon(new ImageIcon(image2));
			getContentPane().add(KitapFoto2[ii]);

			KitapFoto2[ii].setBounds(23 + j2, 345, 127, 166);
			contentPane.add(KitapFoto2[ii]);

			KitapAdi2[ii] = new JTextPane();
			KitapAdi2[ii].setText(books.get(ii + dokuz).getBookTitle());
			KitapAdi2[ii].setBounds(23 + j2, 314, 127, 20);
			contentPane.add(KitapAdi2[ii]);

			KitapYazari2[ii] = new JTextPane();
			KitapYazari2[ii].setText(books.get(ii + dokuz).getBookAuthor());
			KitapYazari2[ii].setBackground(Color.LIGHT_GRAY);
			KitapYazari2[ii].setBounds(23 + j2, 508, 127, 42);
			contentPane.add(KitapYazari2[ii]);

			KitapIsbn2[ii] = new JTextPane();
			KitapIsbn2[ii].setText(books.get(ii + dokuz).getISBN());
			KitapIsbn2[ii].setBackground(Color.GRAY);
			KitapIsbn2[ii].setBounds(65 + j2, 553, 85, 20);
			contentPane.add(KitapIsbn2[ii]);

			KitapYil2[ii] = new JTextPane();
			KitapYil2[ii].setText(String.valueOf(books.get(ii + dokuz).getYearOfPublication()));
			KitapYil2[ii].setBounds(23 + j2, 553, 41, 20);
			contentPane.add(KitapYil2[ii]);

			KitapOylama2[ii] = new JTextPane();
			KitapOylama2[ii].setText("0");
			KitapOylama2[ii].setBounds(77 + j2, 584, 23, 22);

			contentPane.add(KitapOylama2[ii]);

			KitapOyAltGeri2[ii] = new JButton();
			KitapOyAltGeri2[ii].setText("<");
			KitapOyAltGeri2[ii].setBounds(33 + j2, 584, 41, 23);
			contentPane.add(KitapOyAltGeri2[ii]);

			KitapOyAltIleri2[ii] = new JButton();
			KitapOyAltIleri2[ii].setText(">");
			KitapOyAltIleri2[ii].setBounds(99 + j2, 584, 41, 23);
			contentPane.add(KitapOyAltIleri2[ii]);

			int aa = ii;
			String sifir = "0";
			KitapOyAltIleri2[ii].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int sayt2 = Integer.parseInt(sayfa.getText());
					// System.out.println("sayt2" + sayt2);
					int ileri = Integer.parseInt(KitapOylama2[aa].getText());
					KitapOyAltGeri2[aa].setEnabled(true);
					if (ileri >= 9) {
						KitapOylama2[aa].setText("10");
						KitapOyAltIleri2[aa].setEnabled(false);
						KitapOyAltGeri2[aa].setEnabled(true);
					}

					ileri++;
					KitapOylama2[aa].setText(String.valueOf(ileri));

					yolla2 = (18 * sayt2) + aa + 9;

					tamam2(yolla2);
				}
			});

			if (sifir.equals(KitapOylama2[aa].getText()))
				KitapOyAltGeri2[aa].setEnabled(false);
			KitapOyAltGeri2[ii].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int sayt2 = Integer.parseInt(sayfa.getText());
					KitapOyAltIleri2[aa].setEnabled(true);
					int geri = Integer.parseInt(KitapOylama2[aa].getText());
					String sifir = "0";
					if (sifir.equals(KitapOylama2[aa].getText()))
						KitapOyAltGeri2[aa].setEnabled(false);
					if (geri <= 1) {
						KitapOylama2[aa].setText("0");
						KitapOyAltGeri2[aa].setEnabled(false);
						KitapOyAltIleri2[aa].setEnabled(true);
						
						yolla2 = (18 * sayt2) + aa + 9;

						tamam2Sil(yolla2);
					}
					geri--;
					KitapOylama2[aa].setText(String.valueOf(geri));
				}
			});

			j2 = j2 + 137;
		}

	}

}
