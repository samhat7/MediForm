import org.junit.Test;
import org.bson.*;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void TestReg() throws Throwable {
        // user is the contructor of User class.
        User user = new User("Registration", "RegUser", "RegPass01", 1);

        //Assert equals. First value is expected, what you thing the value should be.
        //Second value is retrieving what the value is in User.
        assertEquals("Registration", user.getName());
        assertEquals("RegUser", user.getUsername());
        assertEquals("RegPass01", user.getPassword());
        assertEquals(1, user.getRoleID());
    }

    @Test
    public void TestNurse() throws Throwable {
        // user is the contructor of User class.
        User user = new User("Nurse", "NurseUser", "NursePass01", 2);

        //Assert equals. First value is expected, what you thing the value should be.
        //Second value is retrieving what the value is in User.
        assertEquals("Nurse", user.getName());
        assertEquals("NurseUser", user.getUsername());
        assertEquals("NursePass01", user.getPassword());
        assertEquals(2, user.getRoleID());
    }

    @Test
    public void TestPhy() throws Throwable {
        // user is the contructor of User class.
        User user = new User("Physician", "PhyUser", "PhyPass01", 3);

        //Assert equals. First value is expected, what you thing the value should be.
        //Second value is retrieving what the value is in User.
        assertEquals("Physician", user.getName());
        assertEquals("PhyUser", user.getUsername());
        assertEquals("PhyPass01", user.getPassword());
        assertEquals(3, user.getRoleID());
    }

    @Test
    public void TestBill() throws Throwable {
        // user is the contructor of User class.
        User user = new User("Billing", "BillUser", "BillPass01", 4);

        //Assert equals. First value is expected, what you thing the value should be.
        //Second value is retrieving what the value is in User.
        assertEquals("Billing", user.getName());
        assertEquals("BillUser", user.getUsername());
        assertEquals("BillPass01", user.getPassword());
        assertEquals(4, user.getRoleID());
    }
}