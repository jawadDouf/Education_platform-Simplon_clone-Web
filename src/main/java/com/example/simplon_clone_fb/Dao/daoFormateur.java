package com.example.simplon_clone_fb.Dao;

import Models.FormateursModel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class daoFormateur extends databaseAccessObject<FormateursModel>{
    @Override
    List selectAll() {
        return null;
    }

    @Override
    FormateursModel getOneElementById(int id) {
        return null;
    }

    @Override
    public FormateursModel getOneElementByEmailPassword(String email, String password) {
        try{

            //Start the transaction
            EntityManager entityManager = entityUtility.getEntityManagerFactory().createEntityManager();
            //Create the query and return the element from database
            TypedQuery<FormateursModel> query = entityManager.createQuery("SELECT Formateur FROM " +
                            "FormateursModel Formateur " +
                            "WHERE Formateur.email = :email " +
                            "AND Formateur.password = :password",
                    FormateursModel.class);
            //Prepare the statement
            query.setParameter("email",email);
            query.setParameter("password",password);
            //execute the query
            FormateursModel formateursModel = query.getSingleResult();

            return formateursModel;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    void addOneElement() {

    }
}
