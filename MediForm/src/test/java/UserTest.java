import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void TestUser() throws Exception {
        // user is the contructor of User class.
        User user = new User("Nic", "Nreilly", "Nic", 2);

        //Assert equals. First value is expected, what you thing the value should be.
        //Second value is retrieving what the value is in User.
        assertEquals("Nic", user.getName());
        assertEquals("Nreilly", user.getUsername());
        assertEquals("Nic", user.getPassword());
        assertEquals(2, user.getRoleID());
    }
}