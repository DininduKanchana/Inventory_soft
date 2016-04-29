package hibernateTest.dto;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
	private static SessionFactory factory;
	
	public void createSession(){
		 try{
	         factory = new Configuration().configure().buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		
	}
	/**
	 * @param id
	 * @param name
	 * @param price
	 * @param catogory
	 */
	public void saveDb(int id,String name,int price,String catogory){
		createSession();
		product item1 = new product();
		item1.setId(id);
		item1.setName(name);
		item1.setPrice(price);
		item1.setCatogory(catogory);
		Session session = factory.openSession();
		 try{
			 	
				session.beginTransaction();
				session.save(item1);
				session.getTransaction().commit();
	         
	        
	      }catch (HibernateException e) {
	         
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		
		//SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		
	}

}
