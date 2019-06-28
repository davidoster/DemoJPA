/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author George.Pasparakis
 */
public class DemoJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Person p = new Person("GP", "Address","1234");
        Person p2 = new Person("GKP", "Address2","5678");
        DemoJPA demo = new DemoJPA();
        demo.persist(p);
        demo.persist(p2);
        
    }
    
    public void persist(Person p) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("DemoJPAPU");
        EntityManager em = emf.createEntityManager();
        // create transaction
        // begin transaction
        em.getTransaction().begin();
        try {
            // transaction
            em.persist(p);
            em.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        finally {
            em.close();
            emf.close();
        }
        
        
        // end transaction
    }
    
}
