package View;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.KitapController;
import Hibernate.HibernateSOA;
import Model.Books;
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

public class KitapYonetimi extends JFrame {
	protected final static String baslik[] = { "ISBN", "TITLE", "AUTHOR", "YEAR", "PUBLISHER", "URL S", "URL M", "URL L","DATE" };
	protected static HibernateSOA control = new HibernateSOA();
	@SuppressWarnings("unchecked")
	protected static List<Books> books = control.findAll(Books.class);
	protected static KitapController bookCont = new KitapController();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField isbnTxt;
	private JTextField titleTxt;
	private JTextField authorTxt;
	private JTextField yearTxt;
	private JTextField publisherTxt;
	private JTextField sText;
	private JTextField mTxt;
	private JTextField lText;
	private JTextField dateText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					KitapYonetimi frame = new KitapYonetimi();
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

	public KitapYonetimi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final Object[][] data = new Object[books.size()][];
		for (int i = 0; i < books.size(); i++) {
			data[i] = new String[] { books.get(i).getISBN(), books.get(i).getBookTitle(), books.get(i).getBookAuthor(),
					String.valueOf(books.get(i).getYearOfPublication()),books.get(i).getPublisher(), 
					books.get(i).getImageURLS(), books.get(i).getImageURLM(), books.get(i).getImageURLL(),books.get(i).getCreateDate().toString()};

		}
		
		JPanel panel = new JPanel();
		panel.setBounds(420, 10, 550, 850);
		contentPane.add(panel);
		table = new JTable(data,baslik);
		table.setBounds(420, 10, 550, 850);
		panel.add(table);
		JScrollPane scrollPane = new JScrollPane(table);
		//table.setFillsViewportHeight(true);
		panel.add(scrollPane);
		
		JLabel lblKtapYonetmEkrandr = new JLabel("KITAP YONETIM EKRANIDIR!");
		lblKtapYonetmEkrandr.setHorizontalAlignment(SwingConstants.CENTER);
		lblKtapYonetmEkrandr.setBounds(10, 10, 400, 30);
		contentPane.add(lblKtapYonetmEkrandr);
		
		JLabel lblIsbn = new JLabel("ISBN:");
		lblIsbn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIsbn.setBounds(10, 51, 90, 14);
		contentPane.add(lblIsbn);
		
		isbnTxt = new JTextField();
		isbnTxt.setBounds(117, 48, 293, 20);
		contentPane.add(isbnTxt);
		isbnTxt.setColumns(10);
		
		JLabel lblTtle = new JLabel("TITLE:");
		lblTtle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTtle.setBounds(10, 100, 90, 14);
		contentPane.add(lblTtle);
		
		titleTxt = new JTextField();
		titleTxt.setColumns(10);
		titleTxt.setBounds(117, 97, 293, 20);
		contentPane.add(titleTxt);
		
		JLabel lblAuthor = new JLabel("AUTHOR:");
		lblAuthor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAuthor.setBounds(10, 147, 90, 14);
		contentPane.add(lblAuthor);
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		authorTxt.setBounds(117, 144, 293, 20);
		contentPane.add(authorTxt);
		
		JLabel lblYear = new JLabel("YEAR:");
		lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYear.setBounds(10, 190, 90, 14);
		contentPane.add(lblYear);
		
		yearTxt = new JTextField();
		yearTxt.setColumns(10);
		yearTxt.setBounds(117, 187, 293, 20);
		contentPane.add(yearTxt);
		
		JLabel lblPublsher = new JLabel("PUBLISHER:");
		lblPublsher.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPublsher.setBounds(10, 247, 90, 14);
		contentPane.add(lblPublsher);
		
		publisherTxt = new JTextField();
		publisherTxt.setColumns(10);
		publisherTxt.setBounds(117, 244, 293, 20);
		contentPane.add(publisherTxt);
		
		JLabel lblUrlS = new JLabel("URL S:");
		lblUrlS.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUrlS.setBounds(10, 299, 90, 14);
		contentPane.add(lblUrlS);
		
		sText = new JTextField();
		sText.setColumns(10);
		sText.setBounds(117, 296, 293, 20);
		contentPane.add(sText);
		
		JLabel lblUrlM = new JLabel("URL M:");
		lblUrlM.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUrlM.setBounds(10, 341, 90, 14);
		contentPane.add(lblUrlM);
		
		mTxt = new JTextField();
		mTxt.setColumns(10);
		mTxt.setBounds(117, 338, 293, 20);
		contentPane.add(mTxt);
		
		JLabel lblUrlL = new JLabel("URL L:");
		lblUrlL.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUrlL.setBounds(10, 386, 90, 14);
		contentPane.add(lblUrlL);
		
		lText = new JTextField();
		lText.setColumns(10);
		lText.setBounds(117, 383, 293, 20);
		contentPane.add(lText);
		
		JLabel createDate = new JLabel("CREATE DATE:");
		createDate.setHorizontalAlignment(SwingConstants.RIGHT);
		createDate.setBounds(10, 416, 90, 14);
		contentPane.add(createDate);
		
		dateText = new JTextField();
		dateText.setColumns(10);
		dateText.setBounds(117, 416, 293, 20);
		contentPane.add(dateText);
		
		JButton btnEkle = new JButton("EKLE");
		btnEkle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int sonuc = bookCont.createBook(isbnTxt.getText(),titleTxt.getText() , authorTxt.getText(), yearTxt.getText(), publisherTxt.getText(),
						sText.getText(), mTxt.getText(), lText.getText());
				if(sonuc == 1){
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
				int sonuc = bookCont.deleteBook(isbnTxt.getText());
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
				int sonuc = bookCont.updateBook(isbnTxt.getText(),titleTxt.getText() , authorTxt.getText(), yearTxt.getText(), publisherTxt.getText(),
						sText.getText(), mTxt.getText(), lText.getText());
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
			@Override
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				books = control.findAll(Books.class);
				
				KitapYonetimi yenile2 = new KitapYonetimi();
				yenile2.setVisible(true);
				
				
				for (int i = 0; i < books.size(); i++) {
					data[i] = new String[] { books.get(i).getISBN(), books.get(i).getBookTitle(), books.get(i).getBookAuthor(),
							String.valueOf(books.get(i).getYearOfPublication()),books.get(i).getPublisher(), 
							books.get(i).getImageURLS(), books.get(i).getImageURLM(), books.get(i).getImageURLL(),books.get(i).getCreateDate().toString() };

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
				isbnTxt.setText(String.valueOf(table.getValueAt(selectedRowIndex, 0)));
				titleTxt.setText(String.valueOf(table.getValueAt(selectedRowIndex, 1)));
				authorTxt.setText(String.valueOf(table.getValueAt(selectedRowIndex, 2)));
				yearTxt.setText(String.valueOf(table.getValueAt(selectedRowIndex, 3)));
				publisherTxt.setText(String.valueOf(table.getValueAt(selectedRowIndex, 4)));
				sText.setText(String.valueOf(table.getValueAt(selectedRowIndex, 5)));
				mTxt.setText(String.valueOf(table.getValueAt(selectedRowIndex, 6)));
				lText.setText(String.valueOf(table.getValueAt(selectedRowIndex, 7)));
				dateText.setText(String.valueOf(table.getValueAt(selectedRowIndex, 8)));
				
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
				KullaniciYonetimi kulYon = new KullaniciYonetimi();
				kulYon.setVisible(true);
			}
		});
		geri.setBounds(77, 553, 115, 23);
		contentPane.add(geri);
		
		JButton cikis=new JButton("CIKIS");
		cikis.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		cikis.setBounds(210, 553, 155, 23);
		contentPane.add(cikis);
		
	}
	public void temizle(){
		isbnTxt.setText(null);
		titleTxt.setText(null);
		authorTxt.setText(null);
		yearTxt.setText(null);
		publisherTxt.setText(null);
		sText.setText(null);
		mTxt.setText(null);
		lText.setText(null);
		dateText.setText(null);
	}
	@SuppressWarnings("unchecked")
	public void listeYenile(){
		books = control.findAll(Books.class);
	}
}
