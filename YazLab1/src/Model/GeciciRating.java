package Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ratings")

public class GeciciRating implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="userId")
	private int userId;
	@Column(name="ISBN")
	private String isbn;
	@Column(name="rating")
	private int rating;
	
	public GeciciRating(int userId, String isbn, int rating) {
		this.userId = userId;
		this.isbn = isbn;
		this.rating = rating;
	}
	public GeciciRating() {

	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "GeciciRating [userId=" + userId + ", isbn=" + isbn + ", rating=" + rating + "]";
	}
	
	
	
	
}
