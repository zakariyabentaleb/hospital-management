package com.teleexpertise;


import com.teleexpertise.config.Dbconnection;
import com.teleexpertise.dao.PatientDAO;
import com.teleexpertise.enums.Role;
import com.teleexpertise.enums.StatutConsultation;
import com.teleexpertise.model.*;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.teleexpertise.util.PasswordUtil;
import org.mindrot.jbcrypt.BCrypt;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.teleexpertise.enums.StatutConsultation.EN_COURS;



public class MedicalApp {
    public static void main(String[] args) {
//            PatientDAO allpatient = new PatientDAO();
//            List<Patient> listPatient = allpatient.findAll();
//
//           List<Patient> result = listPatient.stream().filter(p->p.getConsultations()!= null ).toList();
//            for(Patient p : result){
//                System.out.println(p.getNom() + " " + p.getPrenom());
//                for(Consultation c : p.getConsultations()){
//                    if(c.getStatut().equals(EN_COURS)){
//                        System.out.println("  - Consultation ID: " + c.getId() + ", Motif: " + c.getMotif());
//                    }
//                }
//            }

            try (Session session = Dbconnection.getSessionFactory().openSession()) {
                Transaction tx = session.beginTransaction();

                Infirmier nurse = new Infirmier();
                nurse.setNom("newww");
                nurse.setPrenom("jjjj");
                nurse.setEmail("new@gmail.com");

                String hash = BCrypt.hashpw("123456", BCrypt.gensalt(12));
                nurse.setPassword(hash);

                nurse.setRole(Role.INFIRMIER);

                session.persist(nurse);
                tx.commit();
            }
        }
    }
