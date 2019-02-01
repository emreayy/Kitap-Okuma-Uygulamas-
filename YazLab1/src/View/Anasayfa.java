package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import Hibernate.HibernateSOA;
import Model.Books;

import javax.swing.JLabel;

public class Anasayfa extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static HibernateSOA control = new HibernateSOA();
	protected static List<Books> populerKitap = control.populerKitap();
	protected static List<Books> enIyiKitap = control.iyiKitap();
	protected static List<Books> yeniKitap = control.yeniKitap();
	static int id = control.getUserId();
	protected static List<Books> oneriKitap = control.onerilenKitaplar(id);

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Anasayfa frame = new Anasayfa();
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
	JTextPane[] KitapFoto1 = new JTextPane[30];
	JTextPane[] KitapFoto2 = new JTextPane[30];
	JTextPane[] KitapFoto3 = new JTextPane[30];
	JTextPane[] KitapFoto4 = new JTextPane[30];
	
	JTextPane[] KitapAdi1 = new JTextPane[30];
	JTextPane[] KitapAdi2 = new JTextPane[30];
	JTextPane[] KitapAdi3 = new JTextPane[30];
	JTextPane[] KitapAdi4 = new JTextPane[30];
	
	JButton[] KitapOku1 = new JButton[30];
	JButton[] KitapOku2 = new JButton[30];
	JButton[] KitapOku3 = new JButton[30];
	JButton[] KitapOku4 = new JButton[30];
	
	
	public Anasayfa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(40, -10, 1300, 760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Populer = new JLabel("Populer Kitaplar");
		Populer.setBounds(562, 0, 218, 14);
		contentPane.add(Populer);
		
		JLabel EnIyý = new JLabel("En Iyi Kitaplar");
		EnIyý.setBounds(562, 177, 218, 14);
		contentPane.add(EnIyý);
		
		JLabel YeniEklenen = new JLabel("Yeni Eklenen Kitaplar");
		YeniEklenen.setBounds(557, 355, 218, 14);
		contentPane.add(YeniEklenen);
		
		JLabel Onerilen = new JLabel("Onerilen Kitaplar");
		Onerilen.setBounds(562, 531, 218, 14);
		contentPane.add(Onerilen);
		
		
		int j=0;
		for (int i=0; i<populerKitap.size(); i++) {
			
			
			KitapFoto1[i] = new JTextPane();

			URL url = null;
			try {
				url = new URL(populerKitap.get(i).getImageURLM());
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

			KitapFoto1[i].insertIcon(new ImageIcon(image));
			getContentPane().add(KitapFoto1[i]);

			KitapFoto1[i].setBounds(26 +j, 41, 100, 110);
			contentPane.add(KitapFoto1[i]);

			KitapAdi1[i] = new JTextPane();
			KitapAdi1[i].setText(populerKitap.get(i).getBookTitle());
			KitapAdi1[i].setBounds(26 +j, 17, 100, 20);
			contentPane.add(KitapAdi1[i]);

			KitapOku1[i] = new JButton();
			KitapOku1[i].setText("Oku");
			KitapOku1[i].setBounds(26 +j, 155, 100, 20);
			contentPane.add(KitapOku1[i]);
			
			KitapOku1[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					oku();
				}
			});
			
			j=j+125;
					
		}
	
		 j=0;
		for (int i=0; i<enIyiKitap.size(); i++) {
			
			KitapFoto2[i] = new JTextPane();

			URL url2 = null;
			try {
				url2 = new URL(enIyiKitap.get(i).getImageURLM());
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

			KitapFoto2[i].insertIcon(new ImageIcon(image2));
			getContentPane().add(KitapFoto2[i]);

			KitapFoto2[i].setBounds(26 +j, 217, 100, 110);
			contentPane.add(KitapFoto2[i]);

			
			KitapAdi2[i] = new JTextPane();
			KitapAdi2[i].setText(enIyiKitap.get(i).getBookTitle());
			KitapAdi2[i].setBounds(26 +j, 194, 100, 20);
			contentPane.add(KitapAdi2[i]);
			
			KitapOku2[i] = new JButton();
			KitapOku2[i].setText("Oku");
			KitapOku2[i].setBounds(26 +j, 332, 100, 20);
			contentPane.add(KitapOku2[i]);
			
			KitapOku2[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					oku();
				}
			});
			
			j=j+125;
					
		}
		
		 j=0;
			for (int i=0; i<yeniKitap.size(); i++) {
				
				KitapFoto3[i] = new JTextPane();

				URL url3 = null;
				try {
					url3 = new URL(yeniKitap.get(i).getImageURLM());
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				BufferedImage image3 = null;
				try {
					image3 = ImageIO.read(url3);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				KitapFoto3[i].insertIcon(new ImageIcon(image3));
				getContentPane().add(KitapFoto3[i]);

				KitapFoto3[i].setBounds(26 +j, 395, 100, 110);
				contentPane.add(KitapFoto3[i]);
				
				KitapAdi3[i] = new JTextPane();
				KitapAdi3[i].setText(yeniKitap.get(i).getBookTitle());
				KitapAdi3[i].setBounds(26 +j, 371, 100, 20);
				contentPane.add(KitapAdi3[i]);

				KitapOku3[i] = new JButton();
				KitapOku3[i].setText("Oku");
				KitapOku3[i].setBounds(26 +j, 509, 100, 20);
				contentPane.add(KitapOku3[i]);
				
			KitapOku3[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					oku();
				}
			});

				j=j+125;
						
			}
			
			j=0;
			for (int i=0; i<oneriKitap.size(); i++) {
				
				KitapFoto4[i] = new JTextPane();

				URL url4 = null;
				try {
					url4 = new URL(oneriKitap.get(i).getImageURLM());
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				BufferedImage image4 = null;
				try {
					image4 = ImageIO.read(url4);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				KitapFoto4[i].insertIcon(new ImageIcon(image4));
				getContentPane().add(KitapFoto4[i]);

				KitapFoto4[i].setBounds(26 +j, 576, 100, 110);
				contentPane.add(KitapFoto4[i]);
				
				KitapAdi4[i] = new JTextPane();
				KitapAdi4[i].setText(oneriKitap.get(i).getBookTitle());
				KitapAdi4[i].setBounds(26 +j, 551, 100, 20);
				contentPane.add(KitapAdi4[i]);
				
				KitapOku4[i] = new JButton();
				KitapOku4[i].setText("Oku");
				KitapOku4[i].setBounds(26 +j, 690, 100, 20);
				contentPane.add(KitapOku4[i]);
				
				KitapOku4[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						oku();
					}
				});
				
				j=j+125;
						
			}
	}
	
	public void oku() {
		
		Random r=new Random(); 
		 int gelen=r.nextInt(3);
		
		if (gelen ==1 ) {
		
		 try {

				if ((new File("E:\\2018-2019KOU\\eclipse\\KOUYAZLAB\\YazLab1\\kitaplar\\Java1.pdf")).exists()) {

					Process p = Runtime
					   .getRuntime()
					   .exec("rundll32 url.dll,FileProtocolHandler E:\\2018-2019KOU\\eclipse\\KOUYAZLAB\\YazLab1\\kitaplar\\Java1.pdf");
					p.waitFor();
						
				} else {

					System.out.println("Dosya Bulunamadi");

				}

				System.out.println("Çýktý");

		  	  } catch (Exception ex) {
				ex.printStackTrace();
			  }}
		
		else if (gelen ==2){
			
			 try {

					if ((new File("E:\\2018-2019KOU\\eclipse\\KOUYAZLAB\\YazLab1\\kitaplar\\Java2.pdf")).exists()) { //Ayný olacak yerleri

						Process p = Runtime
						   .getRuntime()
						   .exec("rundll32 url.dll,FileProtocolHandler E:\\2018-2019KOU\\eclipse\\KOUYAZLAB\\YazLab1\\kitaplar\\Java2.pdf");//Ayný olacak yerleri
						p.waitFor();
							
					} else {

						System.out.println("Dosya Bulunamadi");

					}

					System.out.println("Çýktý");

			  	  } catch (Exception ex) {
					ex.printStackTrace();
				  }}
		
		else {
			
			 try {

					if ((new File("E:\\2018-2019KOU\\eclipse\\KOUYAZLAB\\YazLab1\\kitaplar\\Java3.pdf")).exists()) { //Ayný olacak yerleri

						Process p = Runtime
						   .getRuntime()
						   .exec("rundll32 url.dll,FileProtocolHandler E:\\2018-2019KOU\\eclipse\\KOUYAZLAB\\YazLab1\\kitaplar\\Java3.pdf");//Ayný olacak yerleri
						p.waitFor();
							
					} else {

						System.out.println("Dosya Bulunamadi");

					}

					System.out.println("Çýktý");

			  	  } catch (Exception ex) {
					ex.printStackTrace();
				  }}

	}
}