//package com.xworkz.Sohita_Gym.Repository;
//
//import com.xworkz.Sohita_Gym.Entity.SlotEntity;
//import com.xworkz.Sohita_Gym.Entity.TrainerTimeAllotmentEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Query;
//import java.util.Collections;
//import java.util.List;
//
//public class SlotSaveIRepoImpl implements SlotSaveRepository{
//
//    @Autowired
//    EntityManagerFactory entityManagerFactory;
//
//    public SlotSaveIRepoImpl(){
//        System.out.println("This is slot save repository class");
//    }
//
//    @Override
//    public boolean onSlotSave(SlotEntity slotEntity) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//        try{
//            entityTransaction.begin();
//            entityManager.persist(slotEntity);
//            entityTransaction.commit();
//            return true;
//        }catch (Exception e){
//            if(entityTransaction.isActive())
//                entityTransaction.rollback();
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    @Override
//    public List<SlotEntity> getSlots() {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//        try{
//            Query query = entityManager.createNamedQuery("getAll");
//            return query.getResultList();
//        }catch (Exception e){
//            if(entityTransaction.isActive())
//                entityTransaction.rollback();
//            e.printStackTrace();
//            return Collections.emptyList();
//        }
//    }
//
//    @Override
//    public boolean trainerAllotment(TrainerTimeAllotmentEntity trainerTimeAllotmentEntity) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//        try{
//            entityTransaction.begin();
//            entityManager.persist(trainerTimeAllotmentEntity);
//            entityTransaction.commit();
//            return true;
//        }catch (Exception e){
//            if(entityTransaction.isActive())
//                entityTransaction.rollback();
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    @Override
//    public List<TrainerTimeAllotmentEntity> getDetails() {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//        try {
//            Query query = entityManager.createNamedQuery("getAllTrainerDetails");
//            return query.getResultList();
//        } catch (Exception e) {
//            if (entityTransaction.isActive())
//                entityTransaction.rollback();
//            e.printStackTrace();
//            return Collections.emptyList();
//        }
//    }
//
//    @Override
//    public boolean delete(int id) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//        try {
//            entityTransaction.begin();
//            Query query = entityManager.createNamedQuery("deleteTrainerDetails");
//            query.setParameter("setId", id);
//            int deleteCount = query.executeUpdate();
//            entityTransaction.commit();
//            if (deleteCount > 0) {
//                return true;
//            }
//        } catch (Exception e) {
//            if (entityTransaction.isActive())
//                entityTransaction.rollback();
//            e.printStackTrace();
//            return false;
//        }
//
//        return false;
//    }
//
//    @Override
//    public String getTrainerSlot(String trainerSlot) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//        try {
//            Query query = entityManager.createNamedQuery("getTrainerSlot");
//            query.setParameter("setName", trainerSlot);
//            return (String) query.getSingleResult();
//        } catch (Exception e) {
//            if (entityTransaction.isActive()) {
//                entityTransaction.rollback();
//            }
//            entityManager.close();
//            return null;
//        }
//
//    }}
//
