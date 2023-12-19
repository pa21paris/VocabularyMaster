/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vocabularymaster.utils;

import com.mycompany.vocabularymaster.Entities.SeenWord;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author papar
 */
public class HibernateHandler {
    
    private static SessionFactory sessionFactory;
    private static Session session;
    
    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    
    private static void openSession(){
        if(session == null || !session.isOpen()) session = sessionFactory.openSession();
    }
    
    private static void closeSession(){
        if(session != null && session.isOpen()) session.close();
    }
    
    public static void saveSeenWord(SeenWord seenWord){
        openSession();
        session.beginTransaction();
        session.persist(seenWord);
        session.getTransaction().commit();
        closeSession();
    }
    
    public static Optional<SeenWord> getWordToRevise(){
        openSession();
        List<SeenWord> results = session.createSelectionQuery(
                "from SeenWord as sw where revisionDay <= :today",
                SeenWord.class)
                .setParameter("today", LocalDate.now())
                .getResultList();
        if(results.isEmpty()) return Optional.empty();
        return Optional.of(results.get(new Random().nextInt(results.size())));
    }
}
