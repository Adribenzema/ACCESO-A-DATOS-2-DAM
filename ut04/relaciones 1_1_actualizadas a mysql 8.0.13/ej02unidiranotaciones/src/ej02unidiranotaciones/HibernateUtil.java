package ej02unidiranotaciones;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Elvis
 */
public class HibernateUtil {
    
    private static final SessionFactory sessionFactory;
    private static Transaction tx;
    private static Session sesion;
    
static {
   try {
       sessionFactory = new Configuration().configure().buildSessionFactory(); 
       
   } catch (Throwable th) {
	System.err.println("Enitial SessionFactory creation failed" + th);
	throw new ExceptionInInitializerError(th);
  }
}
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    /**
     * Se encarga de iniciar una transaccion de la base de datos
     * Metodo startoperation
     */
    private static void startOperation() {
        //opcion 1: abre una nueva sesionFactory
        SessionFactory sessionFactory = getSessionFactory();
        sesion = sessionFactory.openSession();//le pasa a la sesion antes declarada la sesonFactory y la abre
        sesion.getTransaction().begin();//permite que comience la transacion
    }
    
    /**
     * Se encarga de terminar una transaccion de la base de datos
     * Metodo terminaOperacion
     */
    private static void finishOperation() {
        sesion.getTransaction().commit();//confirma la transacion
        sesion.close();//cierra la sesion
    }
    
}
