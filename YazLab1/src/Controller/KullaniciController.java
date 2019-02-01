package Controller;

import java.util.List;

import org.hibernate.classic.Session;

import Hibernate.HibernateSOA;
import Model.Users;

public class KullaniciController {
	protected static HibernateSOA control = new HibernateSOA();
	protected static List<Users> users = control.findAll(Users.class);
	protected static Users tempUser = new Users();
	public int usersControl(String kulAdi, String sifre){
		for (Users users : users) {
			if(kulAdi.equals(users.getKullaniciAdi()) && sifre.equals(users.getSifre())){
				return users.getUserId();
			}
		}
		return -1;
	}
	@SuppressWarnings("unused")
	public int createUser(String kulAdi,String sifre,String lokasyon,String yas){
		
		System.out.println("----->"+users.size());
		int a=users.size()+3;
		tempUser.setUserId(a);
		tempUser.setKullaniciAdi(kulAdi);
		tempUser.setSifre(sifre);
		tempUser.setLocation(lokasyon);
		tempUser.setAge(yas);
		try {
			control.save(tempUser);
			return tempUser.getUserId();
		} catch (Exception e) {
			return -1;
		}
	}
	public int deleteUser(int userId){
		try {
			tempUser = control.findUser(userId);
			control.delete(tempUser);
			return 1;
		} catch (Exception e) {
			System.out.println("Ýslem Yapýlýrken Hata olustu!");
			return -1;
		}
	}
	public int updateUser(int userId,String kulAdi,String sifre,String lokasyon,String yas){
		try {
			tempUser = control.findUser(userId);
			tempUser.setKullaniciAdi(kulAdi);
			tempUser.setSifre(sifre);
			tempUser.setLocation(lokasyon);
			tempUser.setAge(yas);
			control.update(tempUser);
			return 1;
		} catch (Exception e) {
			System.out.println("Ýslem Yapýlýrken Hata olustu!");
			return -1;
		}
	}
}
