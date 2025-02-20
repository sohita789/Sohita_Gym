package com.xworkz.Sohita_Gym.Repository;

import com.xworkz.Sohita_Gym.DTO.RegistrationDTO;
import com.xworkz.Sohita_Gym.Entity.*;
//import com.xworkz.Sohita_Gym.Entity.UserLoginEntity;
//import com.xworkz.Sohita_Gym.Entity.UpdateRegistrationDetailsEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Repository
@Slf4j
public class GymRepoImplementation implements GymRepository {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public boolean getNameByEmail(String email, String password) {
        System.out.println("getName by email and password in repoImpl");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("getNameByEmailAndPassword");
            // query.setParameter("byName",name);
            query.setParameter("setEmail", email);
            query.setParameter("setPassword", password);
            Object singleResult = query.getSingleResult();
            entityTransaction.commit();

            if (singleResult != null) {
                System.out.println("result is not null");
                return true;
            }
            System.out.println("it is null");
            return false;
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean saveEnquiry(EnquiryEntity enquiryEntity) {
        System.out.println("Running the saveEnquiry Method in GymRepoImplementation");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            System.out.println("repo :" + enquiryEntity);
            entityManager.persist(enquiryEntity);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean updateStatusAndReason(String name, String status, String reasons) {
        System.out.println("Running the updateStatusAndReason method in GymRepoImplementation");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        boolean isUpdated = false;
        try {
            entityTransaction.begin();
            String query = "UPDATE EnquiryEntity e SET e.status = :status, e.reasons = :reasons where e.name = :name";
            int rowsAffected = entityManager.createQuery(query)
                    .setParameter("status", status)
                    .setParameter("reasons", reasons)
                    .setParameter("name", name)
                    .executeUpdate();

            entityTransaction.commit();
            //  isUpdated = rowsAffected > 0;

        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return true;
    }

    @Override
    public List<EnquiryEntity> findByStatus(String status) {
        System.out.println("findAll in GymRepoImpl");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        String query = "SELECT e from EnquiryEntity e where e.status =:status";
        return entityManager.createQuery(query, EnquiryEntity.class).setParameter("status", status).getResultList();
    }

    @Override
    public List<EnquiryEntity> findAll() {
        System.out.println("findAll in GymRepoImpl");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        String query = "SELECT e from EnquiryEntity e";
        return entityManager.createQuery(query, EnquiryEntity.class).getResultList();
    }

    @Override
    public boolean saveRegister(RegistrationEntity registrationEntity) {
        System.out.println("Running the saveRegister Method in GymRepoImplementation");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            System.out.println("repo :" + registrationEntity);
            entityManager.merge(registrationEntity);
            entityTransaction.commit();
            //return true;
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            //return false;
        } finally {
            entityManager.close();
        }
        return true;
    }

    @Override
    public RegistrationEntity findByNameAndPhoneNo(String name, long phoneNo) {
        System.out.println("Running the findByNameAndPhoneNo Method in GymRepoImplementation");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        String queryStr = "SELECT r from RegistrationEntity r where r.name = :name AND r.phoneNo = :phoneNo";
        Query query = entityManager.createQuery(queryStr);
        query.setParameter("name", name);
        query.setParameter("phoneNo", phoneNo);

        try {
            entityTransaction.begin();
            return (RegistrationEntity) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public long countName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String queryStr = "SELECT COUNT(p) FROM RegistrationEntity p WHERE p.name = :name";
            Query query = entityManager.createQuery(queryStr);
            query.setParameter("name", name);

            long count = (long) query.getSingleResult();
            System.out.println("  count for name: " + count);

            return count;

        } catch (Exception e) {
            System.out.println("Error fetching count for name: " + name);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return 0;
    }

    @Override
    public long countAge(String age) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String queryStr = "SELECT COUNT(p) FROM RegistrationEntity p WHERE p.age = :age";
            Query query = entityManager.createQuery(queryStr);
            query.setParameter("age", age);

            long count = (long) query.getSingleResult();
            System.out.println("  count for age: " + count);

            return count;

        } catch (Exception e) {
            System.out.println("Error fetching count for age: " + age);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return 0;
    }


    @Override
    public long countEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String queryStr = "SELECT COUNT(p) FROM RegistrationEntity p WHERE p.email = :email";
            Query query = entityManager.createQuery(queryStr);
            query.setParameter("email", email);

            long count = (long) query.getSingleResult();
            System.out.println("  count for email: " + count);

            return count;

        } catch (Exception e) {
            System.out.println("Error fetching count for email: " + email);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return 0;
    }


    @Override
    public long countPhoneNo(String phoneNo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String queryStr = "SELECT COUNT(p) FROM RegistrationEntity p WHERE p.phoneNo = :phoneNo";
            Query query = entityManager.createQuery(queryStr);
            query.setParameter("phoneNo", phoneNo);

            long count = (long) query.getSingleResult();
            System.out.println("  count for phoneNo: " + count);

            return count;

        } catch (Exception e) {
            System.out.println("Error fetching count for phoneNo: " + phoneNo);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return 0;
    }


//    @Override
//    public long countPassword(String password) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        try {
//            String queryStr = "SELECT COUNT(p) FROM RegistrationEntity p WHERE p.password = :password";
//            Query query = entityManager.createQuery(queryStr);
//            query.setParameter("password", password);
//
//            long count = (long) query.getSingleResult();
//            System.out.println("  count for password: " + count);
//
//            return count;
//
//        } catch (Exception e) {
//            System.out.println("Error fetching count for password: " + password);
//            e.printStackTrace();
//        } finally {
//            entityManager.close();
//        }
//        return 0;
//    }

    @Override
    public long countGymName(String gymName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String queryStr = "SELECT COUNT(p) FROM RegistrationEntity p WHERE p.gymName = :gymName";
            Query query = entityManager.createQuery(queryStr);
            query.setParameter("gymName", gymName);

            long count = (long) query.getSingleResult();
            System.out.println("  count for age: " + count);

            return count;

        } catch (Exception e) {
            System.out.println("Error fetching count for gymName: " + gymName);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return 0;
    }


    @Override
    public long countTrainerName(String trainerName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String queryStr = "SELECT COUNT(p) FROM RegistrationEntity p WHERE p.trainerName = :trainerName";
            Query query = entityManager.createQuery(queryStr);
            query.setParameter("trainerName", trainerName);

            long count = (long) query.getSingleResult();
            System.out.println("  count for trainerName: " + count);

            return count;

        } catch (Exception e) {
            System.out.println("Error fetching count for trainerName: " + trainerName);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return 0;
    }

    @Override
    public long countAmount(String amount) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String queryStr = "SELECT COUNT(p) FROM RegistrationEntity p WHERE p.amount = :amount";
            Query query = entityManager.createQuery(queryStr);
            query.setParameter("amount", amount);

            long count = (long) query.getSingleResult();
            System.out.println("  count for amount: " + count);

            return count;

        } catch (Exception e) {
            System.out.println("Error fetching count for amount: " + amount);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return 0;

    }

    @Override
    public long countAmountPaid(String amountPaid) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String queryStr = "SELECT COUNT(p) FROM RegistrationEntity p WHERE p.amountPaid = :amountPaid";
            Query query = entityManager.createQuery(queryStr);
            query.setParameter("amountPaid", amountPaid);

            long count = (long) query.getSingleResult();
            System.out.println("  count for amountPaid: " + count);

            return count;

        } catch (Exception e) {
            System.out.println("Error fetching count for amountPaid: " + amountPaid);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return 0;

    }

    @Override
    public long countInstallment(String installment) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String queryStr = "SELECT COUNT(p) FROM RegistrationEntity p WHERE p.installment = :installment";
            Query query = entityManager.createQuery(queryStr);
            query.setParameter("installment", installment);

            long count = (long) query.getSingleResult();
            System.out.println("  count for installment: " + count);

            return count;

        } catch (Exception e) {
            System.out.println("Error fetching count for installment: " + installment);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return 0;

    }

    @Override
    public long countBalance(String balance) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String queryStr = "SELECT COUNT(p) FROM RegistrationEntity p WHERE p.balance = :balance";
            Query query = entityManager.createQuery(queryStr);
            query.setParameter("balance", balance);

            long count = (long) query.getSingleResult();
            System.out.println("  count for balance: " + count);

            return count;

        } catch (Exception e) {
            System.out.println("Error fetching count for balance: " + balance);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return 0;
    }

    @Override
    public List<ViewEnqDetailsEntity> getAllData(int enquiryId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction et = entityManager.getTransaction();
        List<ViewEnqDetailsEntity> list = null;
        try {
            List<ViewEnqDetailsEntity> result = entityManager.createNamedQuery("getAllData").setParameter("setEnquiryId", enquiryId).getResultList();
            System.out.println("viewDetails in repo======" + result);
            return result;

        } catch (Exception e) {
            e.getMessage();
        } finally {
            entityManager.close();
        }
        return Collections.emptyList();
    }


    @Override
    public boolean saveView(ViewEnqDetailsEntity viewEnqDetailsEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction et = entityManager.getTransaction();
        try {
            et.begin();
            entityManager.persist(viewEnqDetailsEntity);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            entityManager.close();
        }
        return true;
    }

    @Override
    public EnquiryEntity getEnquiryEntityByName(String name) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction et = entityManager.getTransaction();
        String queryStr = "SELECT e FROM EnquiryEntity e WHERE e.name = :setName";
        EnquiryEntity result = null;

        try {
            et.begin();
            Query query = entityManager.createQuery(queryStr);
            query.setParameter("setName", name);

            result = (EnquiryEntity) query.getSingleResult();
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();  // Log the exception
        } finally {
            entityManager.close();
        }

        return result;  // Will be null if no result or multiple results were found
    }
//
//    @Override
//    public boolean updateUserdetails(RegistrationEntity entity) {
//        return false;
//    }
//
//    @Override
//    public RegistrationEntity findregistrationbyid(int registrationId) {
//        return null;
//    }

    @Override
    public long countPassword(String password) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String queryStr = "SELECT COUNT(p) FROM RegistrationEntity p WHERE p.password = :password";
            Query query = entityManager.createQuery(queryStr);
            query.setParameter("password", password);

            long count = (long) query.getSingleResult();
            System.out.println("  count for password: " + count);

            return count;

        } catch (Exception e) {
            System.out.println("Error fetching count for password: " + password);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return 0;


    }

    @Override
    public RegistrationEntity userSave(String email) {
        System.out.println("running userSave in GymRepoImpl" + email);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        RegistrationEntity registrationEntity = null;
        try {
            Query query = entityManager.createNamedQuery("getAllByEmail");
            query.setParameter("byEmail", email);
            registrationEntity = (RegistrationEntity) query.getSingleResult();
            System.out.println("Repository Entity" + registrationEntity.toString());
        } catch (Exception exception) {
            exception.getStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
        return registrationEntity;
    }

    @Override
    public void updateCount(String email, int count) {
        int result = count + 1;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        int value;

        try {
            entityTransaction.begin();
            value = entityManager.createNamedQuery("updateCount").setParameter("setCount", result).setParameter("byEmail", email).executeUpdate();
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean resetCount(String email, int count) {
        int result = 0;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        int value = 0;
        try {
            entityTransaction.begin();
            value = entityManager.createNamedQuery("resetCount").setParameter("setCount", 0).setParameter("byEmail", email).executeUpdate();
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
        } finally {
            entityManager.close();
        }
        if (value > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String updateAccountLockTimeByEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("accountLockedTimeByEmail");
            query.setParameter("accountlockedTimeBy", LocalDateTime.now());
            query.setParameter("emailBy", email);

            int value = query.executeUpdate();
            entityTransaction.commit();

            if (value > 0) {
                System.out.println("Account lock Time is set to Current Time");
            } else {
                System.out.println("Failed to set ");
            }
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
        } finally {
            entityManager.close();
        }
        // return "true";
        return "Account lock time is set";
    }

    @Override
    public String updatePasswordByName(String newPassword, String name) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            System.out.println("name::" + name);
            System.out.println("newPassword::" + newPassword);

            // Assuming "updatePasswordByName" is a named query in the UserEntity class
            Query query = em.createNamedQuery("updatePasswordByName");
            query.setParameter("setNewPassword", newPassword);
            query.setParameter("setCount", 0);
            query.setParameter("nameBy", name);

            int value = query.executeUpdate(); // Call executeUpdate on the Query object
            et.commit();

            if (value > 0) {
                return "password updated successfully";
            } else {
                return "Password is not updated";
            }
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
        return "password updated successfully";
    }


    @Override
    public String resetPasswordByEmail(String email, String newPassword) {
        System.out.println("Entering repository resetPasswordByEmail");
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();

            Query query = em.createNamedQuery("resetPasswordByEmail");
            query.setParameter("setNewPassword", newPassword);
            query.setParameter("emailBy", email);

            int value = query.executeUpdate();
            et.commit();

            System.out.println("Rows affected:" + value);

            if (value > 0) {
                return "password updated successfully";
            } else {
                return "Password Updated";
            }
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return "password updated successfully";
    }


    @Override
    public RegistrationEntity updateRegistration(String name, long phoneNo) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        String queryStr = "SELECT e FROM RegistrationEntity e WHERE e.name = :name AND e.phoneNo = :phoneNo";
        RegistrationEntity result = null;

        try {
            et.begin();
            Query query = em.createQuery(queryStr);
            query.setParameter("name", name);
            query.setParameter("phoneNo", phoneNo);
            result = (RegistrationEntity) query.getSingleResult();
            et.commit();
        } catch (Exception e) {
            System.err.println("Error in updateRegistration: " + e.getMessage());
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }

        return result;
    }

    @Override
    public Long getCountOfAdminUserNameByEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Long count = 0L;
        try {
            count = (Long) entityManager.createNamedQuery("getCountOfAdminUserNameByEmail").setParameter("SetEmail", email).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return count;
    }

    @Override
    public Long getCountOfAdminUserNameByPassword(String password) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Long count = 0L;
        try {
            count = (Long) entityManager.createNamedQuery("getCountOfAdminUserNameByPassword").setParameter("SetPassword", password).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return count;

    }

    @Override
    public boolean saveSlots(SlotTimingsEntity slotTimings) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(slotTimings);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<SlotTimingsEntity> findallslots() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Query query = entityManager.createNamedQuery("GetslotList");
            List<SlotTimingsEntity> result = query.getResultList();
            transaction.commit();
            return result;

        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public boolean savetrainerdetails(TrainerinfoEntity entity) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<TrainerinfoEntity> findAlltrainerlist() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
       // List<TrainerinfoEntity> result = null;

        try {
            transaction.begin();
            Query query = entityManager.createNamedQuery("GetTrainerInfoList");
            List<TrainerinfoEntity> result = query.getResultList();
          // query.getResultList();
            transaction.commit();
            return result;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public List<RegistrationEntity> getAllRegisteredUserDetailsById(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();

        List<RegistrationEntity> list = em.createNamedQuery("getAllRegDetailsById", RegistrationEntity.class).
                setParameter("getId", id).getResultList();
        try {
            et.begin();
            em.merge(list);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        System.out.println(list);
        return list;
    }

    @Override
    public RegistrationDTO updateUserProfile(String name, RegistrationDTO registrationDTO, String filePath) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        int value = 0;
        try {
            et.begin();
            value = em.createNamedQuery("updateUserProfileByName")
                    .setParameter("getAge", registrationDTO.getAge())
                    .setParameter("getHeight", registrationDTO.getHeight())
                    .setParameter("getWeight", registrationDTO.getWeight())
                    .setParameter("getFilePath", filePath)
                    .setParameter("getName", name).executeUpdate();

            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return null;
    }

    @Override
    public boolean getDeleteTrainersById(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            TrainerinfoEntity entity = em.find(TrainerinfoEntity.class, id);
            if (entity != null) {
                em.remove(entity);
                et.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public RegistrationEntity findByEmailCustom(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            String query = "SELECT u FROM RegistrationEntity u WHERE u.email = :email";
            return entityManager.createQuery(query, RegistrationEntity.class)
                    .setParameter("email", email)
                    .getSingleResult();

        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public boolean updateValuesById(String packageType, String trainerName, double amount, double amountPaid, double balance, int installment, int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            int value = em.createNamedQuery("updateValuesById")
                    .setParameter("setPackageType", packageType)
                    .setParameter("setTrainerName", trainerName)
                    .setParameter("setAmount", amount)
                    .setParameter("setPaid", amountPaid)
                    .setParameter("setBalance", balance)
                    .setParameter("setInstallment", installment)
                    .setParameter("idBy", id)
                    .executeUpdate();
            et.commit();

            if (value > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
            return false;

        } finally {
            em.close();
        }
    }

    @Override
    public List<RegistrationEntity> getAllDetails() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try{
            Query query = entityManager.createNamedQuery("getAllDetailsOfCustomer");
            return query.getResultList();

        }catch (Exception e){
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public List<TrainerinfoEntity> getTrainerDetails() {
        System.out.println("---------------get all details in RepoImpl-------------");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            Query query = entityManager.createNamedQuery("getAllTrainerEntityDetails");
            return query.getResultList();

        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            e.printStackTrace();
            return Collections.emptyList();

        }
    }

    @Override
    public TrainerinfoEntity getDataByTrainerId(int id) {
        System.out.println("======= getDataByTrainerId in repository =======");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            Query query = entityManager.createNamedQuery("getTrainerEntityById");
            query.setParameter("setId", id);
            return (TrainerinfoEntity) query.getSingleResult();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateTrainerEntity(TrainerinfoEntity entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(entity);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            if (entityManagerFactory.createEntityManager().getTransaction().isActive())
                entityManagerFactory.createEntityManager().getTransaction().rollback();
            return false;

        }
    }

    @Override
    public boolean saveTrainerAssignDetails(AssignTrainersEntity assignTrainersEntity) {
        System.out.println("=====saveTrainerAssignDetails in repo========");
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            em.persist(assignTrainersEntity);
            et.commit();
            System.out.println("saved data in repository");
            return true;
        } catch (Exception e){
            if(et.isActive()){
                et.rollback();
            }
            System.out.println("not saved data in repository");

        } finally {
            em.close();
        }
        return false;
    }
}




























