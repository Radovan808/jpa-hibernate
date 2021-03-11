package cz.rado;

import cz.rado.model.Message;
import cz.rado.model.Osoba;
import cz.rado.model.enums.Pohlavi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("cz.rado.jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        entityManager.getTransaction().begin();
//        entityManager.persist(new Message("Prvni zprava"));
//        entityManager.persist(new Message("Druha zprava"));
//        entityManager.getTransaction().commit();
//        entityManager.close();
        entityManager.getTransaction().begin();
        entityManager.persist(new Osoba(Pohlavi.Muz));
        entityManager.persist(new Osoba(Pohlavi.Muz));
        entityManager.persist(new Osoba(Pohlavi.Zena));
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        List<Osoba> result = entityManager.createQuery("from Osoba", Osoba.class).getResultList();
        for (Osoba osoba : result) {
            System.out.println("Osoba ID: " + osoba.getId() +
                    ", Pohlavi: "+osoba.getPohlavi() +
                    ", Pohlavi kod: " + osoba.getPohlavi().getKod());
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
