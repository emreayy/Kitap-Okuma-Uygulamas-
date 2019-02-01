package Model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "users")
public class Users implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="userId",unique = true, nullable = false)
	private int userId;
	@Column(name = "location")
	private String location;
	@Column(name = "age")
	private String age;
	@Column(name="sifre")
	private String sifre;
	@Column(name="kullaniciAdi")
	private String kullaniciAdi;

	public Users(int userId, String location, String age, String sifre, String kullaniciAdi) {
		super();
		this.userId = userId;
		this.location = location;
		this.age = age;
		this.sifre = sifre;
		this.kullaniciAdi = kullaniciAdi;
	}
	
	public Users() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public String getKullaniciAdi() {
		return kullaniciAdi;
	}

	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", location=" + location + ", age=" + age + ", sifre=" + sifre
				+ ", kullaniciAdi=" + kullaniciAdi + "]";
	}
	
}
