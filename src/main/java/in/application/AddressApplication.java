package in.application;

import javax.persistence.EntityManagerFactory;

import in.mecw.entity.Address;
import in.mecw.entity.Student;
import in.ty.AddressDao;

public class AddressApplication {

    private AddressDao addressDao;

    public AddressApplication(EntityManagerFactory emf) {
        addressDao = new AddressDao(emf);
    }

    // 1. Add address for student
    public void addAddresses() {

        Student student1 = new Student();
        student1.setStudentId(101);

        Student student2 = new Student();
        student2.setStudentId(102);

        Address a1 = new Address();
        a1.setAddressId(1);
        a1.setHouse("12");
        a1.setStreet("Main Street");
        a1.setCity("Salem");
        a1.setState("Tamil Nadu");
        a1.setPincode(636001);
        a1.setStudent(student1);

        Address a2 = new Address();
        a2.setAddressId(2);
        a2.setHouse("25");
        a2.setStreet("Gandhi Road");
        a2.setCity("Chennai");
        a2.setState("Tamil Nadu");
        a2.setPincode(600001);
        a2.setStudent(student2);

        System.out.println(addressDao.addAddress(a1));
        System.out.println(addressDao.addAddress(a2));
    }

    // 2. Update address
    public void updateAddress() {

        Address address =
                addressDao.findAddressByStudent(101);

        if (address != null) {

            address.setHouse("45");
            address.setStreet("New Main Street");
            address.setCity("Coimbatore");
            address.setState("Tamil Nadu");
            address.setPincode(641001);

            Address updated =
                    addressDao.updateAddress(address);

            System.out.println("Address Updated");

            System.out.println(
                    updated.getHouse() + " "
                    + updated.getStreet() + " "
                    + updated.getCity() + " "
                    + updated.getState() + " "
                    + updated.getPincode());

        } else {
            System.out.println("Address not found");
        }
    }

    // 3. Delete address
    public void deleteAddress() {

        Address address =
                addressDao.findAddressByStudent(102);

        if (address != null) {

            addressDao.deleteAddress(address);

            System.out.println("Address Deleted");

        } else {
            System.out.println("Address not found");
        }
    }

    // 4. Find address by student
    public void findAddressByStudent() {

        Address address =
                addressDao.findAddressByStudent(101);

        if (address != null) {

            System.out.println("Address ID: "
                    + address.getAddressId());

            System.out.println("House: "
                    + address.getHouse());

            System.out.println("Street: "
                    + address.getStreet());

            System.out.println("City: "
                    + address.getCity());

            System.out.println("State: "
                    + address.getState());

            System.out.println("Pincode: "
                    + address.getPincode());

        } else {
            System.out.println("Address not found");
        }
    }
}