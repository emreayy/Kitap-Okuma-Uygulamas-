package Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Hibernate.HibernateSOA;
import Model.Books;

public class KitapController {
	protected static HibernateSOA control = new HibernateSOA();
	protected static Books book = new Books();
	protected static Date date = Calendar.getInstance().getTime();
	protected static DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
	
	public int createBook(String isbn, String title, String author, String year , String publisher, String urls,String urlm,String urll){
		book.setISBN(isbn);
		book.setBookTitle(title);
		book.setBookAuthor(author);
		book.setYearOfPublication(Integer.valueOf(year));
		book.setPublisher(publisher);
		book.setImageURLS(urls);
		book.setImageURLM(urlm);
		book.setImageURLL(urll);
		book.setCreateDate(date);
		try {
			control.save(book);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}//date kýsmýný hallet
	public int updateBook(String isbn, String title, String author, String year , String publisher, String urls,String urlm,String urll){
		book.setISBN(isbn);
		book.setBookTitle(title);
		book.setBookAuthor(author);
		book.setYearOfPublication(Integer.valueOf(year));
		book.setPublisher(publisher);
		book.setImageURLS(urls);
		book.setImageURLM(urlm);
		book.setImageURLL(urll);
		book.setCreateDate(new Date());
		try {
			control.update(book);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}
	public int deleteBook(String isbn){
		try {
			book = control.findBook(isbn);
			control.delete(book);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}
}