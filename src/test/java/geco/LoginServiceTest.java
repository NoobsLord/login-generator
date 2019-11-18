package geco;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LoginServiceTest {
    private static final String ANEM = "ANEM";
    private static final String ABIL = "ABIL";
    private LoginService ls;

    @Before
    public void setUp() throws Exception {
        String[] start = new String[1];
        start[0] = ANEM;
        ls = new LoginService(start);
    }

    @Test
    public void loginExists() {
        boolean res = ls.loginExists(ANEM);
        Assert.assertTrue(res);
        res = ls.loginExists(ABIL);
        Assert.assertFalse(res);
    }

    @Test
    public void addLogin() {
        ls.addLogin("666");
        ls.addLogin("666");
        List<String> allLogins = ls.findAllLogins();
        Assert.assertEquals(3, allLogins.size());
    }

    @Test
    public void findAllLoginsStartingWith() {
        List<String> allLogins = ls.findAllLoginsStartingWith("A");
        Assert.assertEquals(1,allLogins.size());
        ls.addLogin("Akephalos");
        allLogins = ls.findAllLoginsStartingWith("A");
        Assert.assertEquals(2, allLogins.size());
        allLogins = ls.findAllLoginsStartingWith("B");
        Assert.assertEquals(0, allLogins.size());

    }

    @Test
    public void findAllLogins() {
        List<String> allLogins = ls.findAllLogins();
        Assert.assertEquals(1,allLogins.size());
        ls.addLogin("Baphomet");
        allLogins = ls.findAllLogins();
        Assert.assertEquals(2, allLogins.size());
    }
}