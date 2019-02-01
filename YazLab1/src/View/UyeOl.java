package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controller.KullaniciController;
import Hibernate.HibernateSOA;
import Model.Session;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

public class UyeOl extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField kulAdi;
	private JTextField sifre;
	private JTextField lokasyon;
	private JTextField age;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UyeOl frame = new UyeOl();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public  UyeOl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(40, 10, 1300, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKullancAd = new JLabel("Kullanici Adi");
		lblKullancAd.setBounds(601, 237, 89, 24);
		contentPane.add(lblKullancAd);
		
		JLabel lblifre = new JLabel("Sifre");
		lblifre.setBounds(601, 285, 69, 14);
		contentPane.add(lblifre);
		
		kulAdi = new JTextField();
		kulAdi.setBounds(697, 239, 86, 20);
		contentPane.add(kulAdi);
		kulAdi.setColumns(10);
		
		sifre = new JTextField();
		sifre.setBounds(697, 282, 86, 20);
		contentPane.add(sifre);
		sifre.setColumns(10);
		
		JButton geri = new JButton("Geri");
		geri.setBounds(601, 401, 89, 23);
		contentPane.add(geri);
		
		JButton btnUyeOL = new JButton("Devam Et");
		btnUyeOL.setBounds(694, 401, 104, 23);
		contentPane.add(btnUyeOL);
		
		lokasyon = new JTextField();
		lokasyon.setColumns(10);
		lokasyon.setBounds(697, 323, 86, 20);
		contentPane.add(lokasyon);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(601, 326, 69, 14);
		contentPane.add(lblLocation);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(697, 354, 86, 20);
		contentPane.add(age);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(601, 357, 69, 14);
		contentPane.add(lblAge);
		
		geri.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	
				dispose();
				Login login = new Login();
				login.setVisible(true);
			}
		});
		
		btnUyeOL.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KullaniciController kontrol = new KullaniciController();
				int sonuc = kontrol.createUser(kulAdi.getText(), sifre.getText(), lokasyon.getText(), age.getText());
				if(sonuc == -1){
					JOptionPane.showMessageDialog(null, "Kayit islemi sirasinda hata yasanmistir. Lutfen tekrar deneyiniz.");
				}else if(sonuc != -1){
					JOptionPane.showMessageDialog(null, "Yeni kayit basarili bir sekilde alinmistir.");
					Session ses = new Session();
					ses.setId(1);
					ses.setUserId(sonuc);
					HibernateSOA control = new HibernateSOA();
					control.saveOrUpdate(ses);
					dispose();
					KitapSecimi kitapSecimi = new KitapSecimi();
					kitapSecimi.setVisible(true);
					
				}
				else{
					System.out.println("Bilinmeyen hata!");
				}
			}
		});
		
	}
}
