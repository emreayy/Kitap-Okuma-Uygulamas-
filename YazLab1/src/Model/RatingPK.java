package Model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class RatingPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(targetEntity=Users.class, fetch=FetchType.LAZY)
	@JoinColumn(name="userId", referencedColumnName="userId",nullable=false)
	private Users user;
	
	@ManyToOne(targetEntity=Books.class, fetch=FetchType.LAZY)
	@JoinColumn(name="ISBN", referencedColumnName="ISBN",nullable=false)
	private Books book;

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "RatingPK [user=" + user + ", book=" + book + "]";
	}
	
	
	
	
	
	
}
