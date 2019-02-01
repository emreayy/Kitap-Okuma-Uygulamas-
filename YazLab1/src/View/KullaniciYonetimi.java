package View;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.classic.Session;

import Controller.KullaniciController;
import Hibernate.HibernateSOA;
import Hibernate.HibernateUtil;
import Model.Users;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KullaniciYonetimi extends JFrame {
	protected final static String baslik[] = { "USER ID", "KUL. ADI", "SIFRE", "LOKASYON", "YAS"};
	protected static HibernateSOA control = new HibernateSOA();
	@SuppressWarnings("unchecked")
	protected static List<Users> users = control.findAll(Users.class);
	protected static KullaniciController userCont = new KullaniciController();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField idTxt;
	private JTextField kulAdiTxt;
	private JTextField sifreTxt;
	private JTextField locasyonTxt;
	private JTextField yasTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					KullaniciYonetimi frame = new KullaniciYonetimi();
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

	public KullaniciYonetimi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		final Object[][] data = new Object[users.size()][];
		for (int i = 0; i < users.size(); i++) {
			data[i] = new String[] {String.valueOf(users.get(i).getUserId()), users.get(i).getKullaniciAdi(), users.get(i).getSifre(),
					users.get(i).getLocation(),users.get(i).getAge()};

		}
		
		JPanel panel = new JPanel();
		panel.setBounds(420, 10, 550, 650);
		contentPane.add(panel);
		table = new JTable(data,baslik);
		table.setBounds(420, 10, 550, 650);
		panel.add(table);
		JScrollPane scrollPane = new JScrollPane(table);
		//table.setFillsViewportHeight(true);
		panel.add(scrollPane);
		
		JLabel lblKtapYonetmEkrandr = new JLabel("KULLANICI YONETIM EKRANIDIR!");
		lblKtapYonetmEkrandr.setHorizontalAlignment(SwingConstants.CENTER);
		lblKtapYonetmEkrandr.setBounds(10, 10, 400, 30);
		contentPane.add(lblKtapYonetmEkrandr);
		
		JLabel lblIsbn = new JLabel("USER ID:");
		lblIsbn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIsbn.setBounds(10, 51, 90, 14);
		contentPane.add(lblIsbn);
		
		idTxt = new JTextField();
		idTxt.setBounds(117, 48, 293, 20);
		idTxt.setText(String.valueOf(users.size()+3));
		contentPane.add(idTxt);
		idTxt.setColumns(10);
		
		JLabel lblTtle = new JLabel("KUL. ADI:");
		lblTtle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTtle.setBounds(10, 100, 90, 14);
		contentPane.add(lblTtle);
		
		kulAdiTxt = new JTextField();
		kulAdiTxt.setColumns(10);
		kulAdiTxt.setBounds(117, 97, 293, 20);
		contentPane.add(kulAdiTxt);
		
		JLabel lblAuthor = new JLabel("SÝFRE:");
		lblAuthor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAuthor.setBounds(10, 147, 90, 14);
		contentPane.add(lblAuthor);
		
		sifreTxt = new JTextField();
		sifreTxt.setColumns(10);
		sifreTxt.setBounds(117, 144, 293, 20);
		contentPane.add(sifreTxt);
		
		JLabel lblYear = new JLabel("LOKASYON:");
		lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYear.setBounds(10, 190, 90, 14);
		contentPane.add(lblYear);
		
		locasyonTxt = new JTextField();
		locasyonTxt.setColumns(10);
		locasyonTxt.setBounds(117, 187, 293, 20);
		contentPane.add(locasyonTxt);
		
		JLabel lblPublsher = new JLabel("YAS:");
		lblPublsher.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPublsher.setBounds(10, 247, 90, 14);
		contentPane.add(lblPublsher);
		
		yasTxt = new JTextField();
		yasTxt.setColumns(10);
		yasTxt.setBounds(117, 244, 293, 20);
		contentPane.add(yasTxt);
		
		
		JButton btnEkle = new JButton("EKLE");
		btnEkle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int sonuc = userCont.createUser(kulAdiTxt.getText(),sifreTxt.getText(),locasyonTxt.getText(),
						yasTxt.getText());
				if(sonuc != -1){
        			JOptionPane.showMessageDialog(null,"Basarili");
        			temizle();
        		}
        		else{
        			JOptionPane.showMessageDialog(null,"Islem sýrasýnda hata olustu. Lutfen tekrar deneyin.");
        			}
        		}
			
		});
		btnEkle.setBounds(27, 503, 115, 23);
		contentPane.add(btnEkle);
		
		JButton btnSil = new JButton("SIL");
		btnSil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int sonuc = userCont.deleteUser(Integer.valueOf(idTxt.getText()));
				if(sonuc == 1){
        			JOptionPane.showMessageDialog(null,"Basarili");
        			temizle();
        		}
        		else{
        			JOptionPane.showMessageDialog(null,"Islem sýrasýnda hata olustu. Lutfen tekrar deneyin.");
        			}
        		}
		});
		btnSil.setBounds(170, 503, 115, 23);
		contentPane.add(btnSil);
		
		JButton gncBtn = new JButton("GUNCELLE");
		gncBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int sonuc = userCont.updateUser(Integer.valueOf(idTxt.getText()),kulAdiTxt.getText(),sifreTxt.getText(),locasyonTxt.getText(),
						yasTxt.getText());
				if(sonuc == 1){
        			JOptionPane.showMessageDialog(null,"Basarili");
        			temizle();
        		}
        		else{
        			JOptionPane.showMessageDialog(null,"Islem sýrasýnda hata olustu. Lutfen tekrar deneyin.");
        			}
        		}
		});
		gncBtn.setBounds(306, 503, 115, 23);
		contentPane.add(gncBtn);
		
		JButton ynlBtn = new JButton("YENILE");
		
		ynlBtn.addActionListener(new ActionListener() {
			//Table gridi yenileyemiyoruz.
			@Override
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent arg0) {

				
				
				dispose();
				users = control.findAll(Users.class);
				
				KullaniciYonetimi yenile = new KullaniciYonetimi();
				yenile.setVisible(true);
				
				
				for (int i = 0; i < users.size(); i++) {
					data[i] = new String[] {String.valueOf(users.get(i).getUserId()), users.get(i).getKullaniciAdi(), users.get(i).getSifre(),
							users.get(i).getLocation(),users.get(i).getAge()};
					
					System.out.println(users.get(i).getKullaniciAdi());

				}
				
				temizle();
				
				
				
				
				
			}
		});
		ynlBtn.setBounds(117, 446, 115, 23);
		contentPane.add(ynlBtn);
		
		JButton gtrBtn = new JButton("GETIR");
		gtrBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int selectedRowIndex = table.getSelectedRow();
				idTxt.setText(String.valueOf(table.getValueAt(selectedRowIndex, 0)));
				kulAdiTxt.setText(String.valueOf(table.getValueAt(selectedRowIndex, 1)));
				sifreTxt.setText(String.valueOf(table.getValueAt(selectedRowIndex, 2)));
				locasyonTxt.setText(String.valueOf(table.getValueAt(selectedRowIndex, 3)));
				yasTxt.setText(String.valueOf(table.getValueAt(selectedRowIndex, 4)));
			}
		});
		gtrBtn.setBounds(295, 446, 115, 23);
		contentPane.add(gtrBtn);
		
		
		JButton geri=new JButton("GERI");
		geri.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				Login login = new Login();
				login.setVisible(true);
			}
		});
		geri.setBounds(77, 553, 115, 23);
		contentPane.add(geri);
		
		JButton kitapYön=new JButton("KITAP YONETIMI");
		kitapYön.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				KitapYonetimi kiYon = new KitapYonetimi();
				kiYon.setVisible(true);
			}
		});
		kitapYön.setBounds(210, 553, 155, 23);
		contentPane.add(kitapYön);
		
		JButton cikis=new JButton("CIKIS");
		cikis.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		cikis.setBounds(150, 603, 155, 23);
		contentPane.add(cikis);
		
	}
	public void temizle(){
		idTxt.setText(null);
		kulAdiTxt.setText(null);
		sifreTxt.setText(null);
		locasyonTxt.setText(null);
		yasTxt.setText(null);
	}
	@SuppressWarnings("unchecked")
	public void listeYenile(){
		users = control.findAll(Users.class);
	}
}
