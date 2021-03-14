package cz.rado;

import cz.rado.crud.impl.AdresaRepository;
import cz.rado.model.*;
import cz.rado.model.enums.Pohlavi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;


public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("cz.rado.jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AdresaRepository adresaRepository = new AdresaRepository(entityManager);

//        saveOsobaPrintOsoba(entityManager);

//        saveTelefonKOsobe(entityManager);
//        deleteTelefon(entityManager);
//        saveTelefon(entityManager);
//        saveViceAdresOsobe(entityManager);
//        saveOsobuTelefony2(entityManager);
//        addAdresaOsobe(entityManager);
//        loadOsoba(entityManager);



        Adresa adresa = new Adresa();
        adresa.setUlice("Dlhá ulica 27");
        adresa.setPsc("97404");
        adresa.setMesto("Banská Bystrica");

        Adresa adresa2 = new Adresa();
        adresa.setUlice("Dlhá ulica 25");
        adresa.setPsc("97404");
        adresa.setMesto("Banská Bystrica");

        adresaRepository.create(adresa);
        adresaRepository.create(adresa2);
        System.out.println("pridane dve adresy\n");
        //--------------------------------------------------------------------------
        Adresa adresaZdb = adresaRepository.read(Adresa.class, 1L);
        System.out.println("Adresa z db:");
        System.out.println(adresaZdb+"\n");

        //--------------------------------------------------------------------------
        Adresa adresaMoje = new Adresa();
        adresaMoje.setId(1L);
        adresaMoje.setUlice("Menim adresu 10");
        Adresa updateAdresa = adresaRepository.update(adresaMoje);
        System.out.println("Adresa update:");
        System.out.println(updateAdresa);
        System.out.println("update adresy\n");

        nativeQuery(entityManager);
        entityManager.close();
    }

    private static void nativeQuery(EntityManager entityManager) {
        entityManager.getTransaction().begin();
        List<Osoba> osoby =
                entityManager.createNativeQuery("select * from osoba",Osoba.class)
                        .getResultList();

        for (Osoba osoba : osoby){
            System.out.println("id = "+osoba.getId()+", prezdivka = "+osoba.getJmeno().getPrezdivka());
        }

        entityManager.getTransaction().commit();

    }
    private static void addAdresaOsobe(EntityManager entityManager) {
        entityManager.getTransaction().begin();

        Osoba osoba = entityManager.find(Osoba.class, 5L);

        Adresa adresa = new Adresa();
        adresa.setUlice("Nejaka ulice");
        adresa.setMesto("Najake mesto");
        adresa.setPsc("90010");
        adresa.setOsoba(osoba);

        entityManager.flush();

        entityManager.persist(adresa);
        entityManager.getTransaction().commit();
    }

    private static void loadOsoba(EntityManager entityManager) {
        Osoba osoba = entityManager.find(Osoba.class, 1L);
        Set<SkupinaKontaktu> skupiny = osoba.getSkupinyOsoby();
        skupiny.size();
        osoba.getTelefony().size();
    }

    private static void saveOsobuTelefony2(EntityManager entityManager) {
        entityManager.getTransaction().begin();

        Osoba osoba = new Osoba();
        osoba.setPohlavi(Pohlavi.Zena);
        osoba.setJmeno(new Jmeno(null,null, "Janko", null, "Beno"));
        osoba.setCisloOp("X411146D4");

        Telefon telefon = new Telefon();
        telefon.setCislo("0911545111");

        Telefon telefon2 = new Telefon();
        telefon2.setCislo("0912545222");

        osoba.addTelefon(telefon);
        osoba.addTelefon(telefon2);

        entityManager.persist(osoba);
        entityManager.getTransaction().commit();
    }

    private static void deleteSkupina(EntityManager entityManager) {
        entityManager.getTransaction().begin();

        SkupinaKontaktu skupina = entityManager.find(SkupinaKontaktu.class, 2L);
        entityManager.remove(skupina);

        entityManager.getTransaction().commit();
    }

    private static void loadSkupina(EntityManager entityManager) {
        SkupinaKontaktu skupina = entityManager.find(SkupinaKontaktu.class, 2L);
        System.out.println(skupina);
    }
    private static void saveSkupinuAOsoby(EntityManager entityManager) {
        entityManager.getTransaction().begin();

        Osoba osoba = entityManager.find(Osoba.class, 35L);
        Osoba osoba2 = entityManager.find(Osoba.class, 40L);
        Osoba osoba3 = entityManager.find(Osoba.class, 39L);

        SkupinaKontaktu skupina = new SkupinaKontaktu();
        skupina.setNazevSkupiny("Skupina 1");
        skupina.getOsobyVSkupine().add(osoba);
        skupina.getOsobyVSkupine().add(osoba2);

        SkupinaKontaktu skupina2 = new SkupinaKontaktu();
        skupina2.setNazevSkupiny("Skupina 2");
        skupina2.getOsobyVSkupine().add(osoba);
        skupina2.getOsobyVSkupine().add(osoba3);

        entityManager.persist(skupina);
        entityManager.persist(skupina2);

        entityManager.getTransaction().commit();
    }


    private static void saveViceAdresOsobe(EntityManager entityManager) {
        entityManager.getTransaction().begin();

        Osoba osoba = entityManager.find(Osoba.class, 2L);
        Telefon telefon = new Telefon();
        telefon.setCislo("38839585");
        telefon.setOsoba(osoba);
        entityManager.persist(telefon);

        Telefon telefon2 = new Telefon();
        telefon2.setCislo("312222448839585");
        telefon2.setOsoba(osoba);
        entityManager.persist(telefon2);

        Telefon telefon3 = new Telefon();
        telefon3.setCislo("388324239585");
        telefon3.setOsoba(osoba);
        entityManager.persist(telefon3);



        entityManager.getTransaction().commit();
    }

    private static void deleteTelefon(EntityManager entityManager) {
        entityManager.getTransaction().begin();
        Telefon telefon = entityManager.find(Telefon.class, 1L);
        telefon.setOsoba(null);
        entityManager.persist(telefon);
        entityManager.getTransaction().commit();



    }

    private static void saveTelefon(EntityManager entityManager) {
        entityManager.getTransaction().begin();
        Telefon telefon = new Telefon();
        telefon.setCislo("38839585");
        entityManager.persist(telefon);
        entityManager.getTransaction().commit();
    }

    private static void saveTelefonKOsobe(EntityManager entityManager) {
        entityManager.getTransaction().begin();
        Osoba osoba1 = new Osoba();
        osoba1.setPohlavi(Pohlavi.Zena);
        osoba1.setJmeno(new Jmeno("Mgr.","Pavla", "Herfert", "Phd.", "Rado"));
        osoba1.setCisloOp("XXX256732278489");
        entityManager.persist(osoba1);

        Telefon telefon = new Telefon();
        telefon.setOsoba(osoba1);
        telefon.setCislo("38839585");
        entityManager.persist(telefon);

        entityManager.getTransaction().commit();
    }

    private static void saveOsobaPrintOsoba(EntityManager entityManager) {
        Osoba osoba1 = new Osoba();
        osoba1.setPohlavi(Pohlavi.Muz);
        osoba1.setJmeno(new Jmeno("Mgr.","Radovan", "Herfert", "Phd.", "Rado"));
        osoba1.setCisloOp("XXX256732278489");
        entityManager.getTransaction().begin();
        entityManager.persist(osoba1);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        List<Osoba> result = entityManager.createQuery("from Osoba", Osoba.class).getResultList();
        for (Osoba osoba : result) {
            System.out.println("Osoba ID: " + osoba.getId() +
                    ", Pohlavi: "+osoba.getPohlavi() +
                    ", Pohlavi kod: " + osoba.getPohlavi().getKod()+
                    ", Jmeno: " + osoba.getJmeno() +
                    ", OP: " + osoba.getCisloOp());
        }
        entityManager.getTransaction().commit();
    }
    private static void getTelefon(EntityManager entityManager){
        entityManager.getTransaction().begin();
        Telefon telefon = entityManager.find(Telefon.class, 3L);
        System.out.println(telefon);
        entityManager.getTransaction().commit();
    }
}
