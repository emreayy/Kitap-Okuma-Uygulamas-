package Hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.classic.Session;

import Model.Books;
import Model.Users;

public class HibernateSOA {
	@SuppressWarnings("rawtypes")
	public List findAll(Class className) { //Tüm class'ý array liste atýp döndürür. 12.10.2018
		List objects = null;
		Session session = HibernateUtil.openSession();
		try {
			Query query = session.createQuery("from " + className.getName());
			objects = query.list();
		} catch (HibernateException e) {
			System.out.println("HAta!");
		} finally {
			session.close();
		}
		return objects;
	}
	public int tabloKayitSayisi(){//calýsýyor 27.10.2018
		Session ses = HibernateUtil.openSession();
		try {
			Query query = ses.createQuery("select count(*) from Users");
			 List<Object> asd= query.list();
			 if(asd==null||asd.size()<=0){
				 return -1;
			 }
		     return Integer.parseInt( asd.get(0).toString());
			 
			} catch (Exception e) {
			System.out.println("HAta!");
			return 1;
		}finally {
			ses.close();
		}
	}
	public Books findBook(String isbn) { // Isbn'den gelen kitabý Books tipinde döndürür.
		Session session = HibernateUtil.openSession();
		Books book = null;
		try {
			book = (Books) session.get(Books.class, isbn);
			if(book==null ){
				return null;
			}
		} catch (HibernateException e) {
			System.out.println("HAta!");
		} finally {
			session.close();
		}
		return book;
	}
	
	public Users findUser(int id) { // userId'den gelen user'i Users tipinde döndürür. 
		Session session = HibernateUtil.openSession();
		Users user = null;
		try {
			user = (Users) session.load(Users.class, id);
			if(user==null ){
				return null;
			}
			
		} catch (HibernateException e) {
			System.out.println("HAta!");
		}finally {
			session.close();
		}
		return user;
	}

	public void save(Object obj) { // Session açmadan kayýt ekleme yapmak için yazýlmýstýr.
		Session session = HibernateUtil.openSession();
		try {
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	public void update(Object obj) { // Session açmadan güncelleme yapmak için yazýlmýstýr. 
		Session session = HibernateUtil.openSession();
		try {
			session.beginTransaction();
			session.update(obj);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	public void delete(Object obj) { // Session açmadan kayýt silme yapmak için yazýlmýstýr.
		Session session = HibernateUtil.openSession();
		try {
			session.beginTransaction();
			session.delete(obj);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	
	public List<Books> populerKitap() {// Direkt kitaplarý getirecek. 27.10.2018 
		Session session = HibernateUtil.openSession();
		List<Books> liste = new ArrayList<>();
		
		try {
			String sql ="SELECT ISBN,SUM(rating) as toplamRating FROM ratings GROUP BY ISBN HAVING (COUNT(ISBN) > 1) ORDER BY toplamRating DESC LIMIT 10";
			SQLQuery query = session.createSQLQuery(sql);
			List<Object[]> rows = query.list();
			
			
			for(Object[] row : rows){
				if(row==null||row.toString()==null||row.toString().equals("")){
					continue;
				}
				Books book=findBook(row[0].toString());
				if(book==null){
					continue;
				}
				liste.add(book);
			}
			
		} catch (HibernateException e) {
			System.out.println("HAta!");
		}finally {
			session.close();
		}
		return liste;
	}

	public List<Books> iyiKitap() {// Direkt kitaplarý getirecek. 27.10.2018 
		Session session = HibernateUtil.openSession();
		List<Books> liste = new ArrayList<>();
		try {
			String sql ="SELECT ISBN,COUNT(ISBN) as tekrarSayisi FROM ratings GROUP BY ISBN HAVING (COUNT(ISBN) > 1) ORDER BY tekrarSayisi DESC LIMIT 10";
			SQLQuery query = session.createSQLQuery(sql);
			List<Object[]> rows = query.list();
			for(Object[] row : rows){
				if(row==null||row.toString()==null||row.toString().equals("")){
					continue;
				}
				Books book=findBook(row[0].toString());
				if(book==null){
					continue;
				}
				liste.add(book);
			}
			
		} catch (HibernateException e) {
			System.out.println("HAta!");
		}finally {
			session.close();
		}
		System.out.println(liste.size());
		return liste;
	}
	
	public List<Books> yeniKitap() { // userId'den gelen user'i Users tipinde döndürür.
		Session session = HibernateUtil.openSession();
		List<Books> books=new ArrayList<>();
		try {
			Query query = session.createQuery("select u from Books u order by createDate desc");
			List<Object> list = query.list().subList(0, 5);
			for (Object object : list) {
				if(object == null || list.size() == 0 ){
					continue;
				}
				books.add((Books)object);
			}
			
		} catch (HibernateException e) {
			System.out.println("HAta!");
		}finally {
			session.close();
		}
		return books;
	}


	
	public List<Books> onerilenKitaplar(int id) {// Direkt kitaplarý getirecek.
		Session session = HibernateUtil.openSession();
		List<Books> liste = new ArrayList<>();
		
		try {
			StringBuilder sql =new StringBuilder(" select isbn from ratings where userId in( ");
			sql.append(" select userId from ratings where isbn in (select ISBN from  ");
			sql.append(" ratings where userId= ? group by ISBN)  ");
			sql.append(" and userId<> ?  GROUP by userId)  ");
			sql.append(" and userId <> ? GROUP BY ISBN,userId LIMIT 10");
			System.out.println(sql.toString());
			System.out.println(id);
			SQLQuery query = session.createSQLQuery(sql.toString());
			query.setParameter(0, id);
			query.setParameter(1, id);
			query.setParameter(2, id);
			System.out.println(sql.toString());
			List<Object> rows = query.list();
			for(Object row : rows){
				if(row==null||row.toString()==null||row.toString().equals("")){
					continue;
				}
				System.out.println(row.toString());
				Books book = null;
				book=findBook(row.toString());
				if(book==null){
					continue;
				}
				liste.add(book);
			}
		} catch (HibernateException e) {
			System.out.println("HAta!");
		}finally {
			session.close();
		}
		return liste;
	}

	public int getUserId(){
		Session session = HibernateUtil.openSession();
		Model.Session oturum = null;
		try {
			oturum = (Model.Session) session.get(Model.Session.class, 1);
		} catch (Exception e) {
			System.out.println("HAta!");
		}finally {
			session.close();
		}
		
		return oturum.getUserId();
	}
	public void saveOrUpdate(Object obj) { // Session açmadan güncelleme yapmak için yazýlmýstýr
		Session session = HibernateUtil.openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(obj);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
}
