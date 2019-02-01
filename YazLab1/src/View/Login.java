package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.KullaniciController;
import Hibernate.HibernateSOA;
import Model.Session;
import Model.Users;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;





public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField kulAdi;
	private JTextField sifre;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
						     
				try {
					Login frame = new Login();					
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
	public Login()  {
		
		setBounds(40, 10, 1300, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKullancAd = new JLabel("Kullanici Adi");
		lblKullancAd.setBounds(582, 297, 101, 24);
		contentPane.add(lblKullancAd);
		
		JLabel lblifre = new JLabel("Sifre");
		lblifre.setBounds(582, 344, 81, 14);
		contentPane.add(lblifre);
		
		kulAdi = new JTextField();
		kulAdi.setBounds(693, 299, 86, 20);
		contentPane.add(kulAdi);
		kulAdi.setColumns(10);
		
		sifre = new JTextField();
		sifre.setBounds(693, 341, 86, 20);
		contentPane.add(sifre);
		sifre.setColumns(10);
		
		JButton btnGiri = new JButton("Giris");
		btnGiri.setBounds(693, 387, 89, 23);
		contentPane.add(btnGiri);
		
		JButton btnUyeOL = new JButton("Uye Ol");
		btnUyeOL.setBounds(582, 387, 89, 23);
		contentPane.add(btnUyeOL);
		
		JLabel lblNewLabel = new JLabel("EMRE AY 160201136 - OÐUZ KAAN YILDIZ 160201139");
		lblNewLabel.setBounds(474, 77, 598, 107);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(lblNewLabel);
		
		
		
		btnGiri.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (kulAdi.getText().toString().equals("admin") && sifre.getText().toString().equals("admin")){
					
					JOptionPane.showMessageDialog(null, "Yönetici Paneline Giris basarilidir.");
					dispose();
					KullaniciYonetimi kulYonetim = new KullaniciYonetimi();
					kulYonetim.setVisible(true);
				}
				else {
				KullaniciController user = new KullaniciController();
				int sonuc = user.usersControl(kulAdi.getText(), sifre.getText());
				if(sonuc != -1) {
					JOptionPane.showMessageDialog(null, "Giris basarilidir.");
					Session ses = new Session();
					ses.setId(1);
					ses.setUserId(sonuc);
					HibernateSOA control = new HibernateSOA();
					control.saveOrUpdate(ses);
					dispose();
					Anasayfa anasayfa = new Anasayfa();
					anasayfa.setVisible(true);
				}else if(sonuc == -1) {
					
					JOptionPane.showMessageDialog(null, "Kullaniciniz bulunamadi! Uye Ol butonuna tiklayarak uye olun!");
				}
			   }
			}
		});
		
		btnUyeOL.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				UyeOl yeniuye = new UyeOl();
				yeniuye.setVisible(true);
			}
		});
		
	}
}
