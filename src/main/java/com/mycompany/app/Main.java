package com.mycompany.app;

import com.mycompany.app.entity.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_persistence_unit");

    EntityManager em = emf.createEntityManager();
    try{
    em.getTransaction().begin();
    Book book  =new Book();
    book.setBookName("myBook");
    book.setIsbn("123-456");
    em.persist(book);
    em.getTransaction().commit();
    } 
    finally{
      em.close();
    }
   
  }
}