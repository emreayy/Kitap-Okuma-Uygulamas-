package Model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Books implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ISBN",unique = true, nullable = false, length = 13)
	private String ISBN;
	@Column(name = "title",length = 255)
	private String bookTitle;
	@Column(name = "author",length = 255)
	private String bookAuthor;
	@Column(name = "yearOfPublication",length = 10)
	private int yearOfPublication;
	@Column(name = "publisher",length = 255)
	private String publisher;
	@Column(name = "ImageURLS",length = 255)
	private String imageURLS;
	@Column(name = "ImageURLM",length = 255)
	private String imageURLM;
	@Column(name = "ImageURLL",length = 255)
	private String imageURLL;
	@Column(name = "createDate")
	private Date createDate;
	
	public Books(String iSBN, String bookTitle, String bookAuthor, int yearOfPublication, String publisher,
			String imageURLS, String imageURLM, String imageURLL, Date createDate) {
		super();
		ISBN = iSBN;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.yearOfPublication = yearOfPublication;
		this.publisher = publisher;
		this.imageURLS = imageURLS;
		this.imageURLM = imageURLM;
		this.imageURLL = imageURLL;
		this.createDate = createDate;
	}

	public Books() {

	}
	
	
	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	
	public String getBookTitle() {
		return bookTitle;
	}
	
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	
	public String getBookAuthor() {
		return bookAuthor;
	}
	
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	
	public int getYearOfPublication() {
		return yearOfPublication;
	}
	
	public void setYearOfPublication(int yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}
	
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getImageURLS() {
		return imageURLS;
	}

	public void setImageURLS(String imageURLS) {
		this.imageURLS = imageURLS;
	}
	
	public String getImageURLM() {
		return imageURLM;
	}
	
	public void setImageURLM(String imageURLM) {
		this.imageURLM = imageURLM;
	}
	
	
	public String getImageURLL() {
		return imageURLL;
	}
	public void setImageURLL(String imageURLL) {
		this.imageURLL = imageURLL;
	}
	
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Books [ISBN=" + ISBN + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor
				+ ", yearOfPublication=" + yearOfPublication + ", publisher=" + publisher + ", imageURLS=" + imageURLS
				+ ", imageURLM=" + imageURLM + ", imageURLL=" + imageURLL + ", createDate=" + createDate + "]";
	}

	
	
}
