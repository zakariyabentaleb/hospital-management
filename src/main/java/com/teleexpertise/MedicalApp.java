package com.teleexpertise;


import com.teleexpertise.config.Dbconnection;
import com.teleexpertise.enums.Role;
import com.teleexpertise.model.Infirmier;
import com.teleexpertise.model.MedecinGeneraliste;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.teleexpertise.util.PasswordUtil;
import org.mindrot.jbcrypt.BCrypt;


public class MedicalApp {
    public static void main(String[] args) {
        try (Session session = Dbconnection.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            MedecinGeneraliste medecinGeneraliste = new MedecinGeneraliste();
            medecinGeneraliste.setNom("zan3");
            medecinGeneraliste.setPrenom("moha");
            medecinGeneraliste.setEmail("said@gmail.com");

            String hash = BCrypt.hashpw("123456789", BCrypt.gensalt(12));
            medecinGeneraliste.setPassword(hash);

            medecinGeneraliste.setRole(Role.GENERALISTE);

            session.persist(medecinGeneraliste);
            tx.commit();
        }
    }
}
