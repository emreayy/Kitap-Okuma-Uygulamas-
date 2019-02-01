package Model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name= "ratings")
public class Ratings implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	RatingPK id;
	@Column(name = "rating")
	private int rating;

	
	
	public Ratings(RatingPK id, int rating) {
		this.id = id;
		this.rating = rating;
	}

	public Ratings() {
	}
	
	public RatingPK getId() {
		return id;
	}
	public void setId(RatingPK id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Ratings [id=" + id + ", rating=" + rating + "]";
	}

	
	
}
