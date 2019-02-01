package Model;

public class KitapPop {
	private String isbn;
	private int tekrarSay;
	
	public KitapPop(String isbn, int tekrarSay) {
		super();
		this.isbn = isbn;
		this.tekrarSay = tekrarSay;
	}

	public KitapPop() {

	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getTekrarSay() {
		return tekrarSay;
	}

	public void setTekrarSay(int tekrarSay) {
		this.tekrarSay = tekrarSay;
	}
	
	
}
