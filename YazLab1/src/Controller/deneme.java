package Controller;


import Hibernate.HibernateSOA;
import Model.Session;

public class deneme {
	public static void main(String[] args) {
		Session ses = new Session();
		ses.setId(1);
		ses.setUserId(2);
		HibernateSOA control = new HibernateSOA();
		control.saveOrUpdate(ses);
		
	}
}
