package in.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import in.mecw.entity.Address;

public class AddressDao {

    private EntityManagerFactory emf;

    public AddressDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    // Add address for student
    public String addAddress(Address address) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(address);
        et.commit();

        return "Address inserted";
    }

    // Update address
    public Address updateAddress(Address address) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        address = em.merge(address);
        et.commit();

        return address;
    }

    // Delete address
    public void deleteAddress(Address address) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        address = em.merge(address);
        em.remove(address);

        et.commit();
    }

    // Find address by student
    public Address findAddressByStudent(int studentId) {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Address> result = em.createQuery(
                "select s.address from Student s where s.studentId = :id",
                Address.class);

        result.setParameter("id", studentId);

        return result.getSingleResult();
    }
}