package geco;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {

    private LoginGenerator lg;

    @Before
    public void setUp() throws Exception {
        String[] start = new String[]{"JROL", "BPER", "CGUR", "JRAL", "JRAL1"};
        lg = new LoginGenerator(new LoginService(start));
    }

    @Test
    public void generateLoginForNomAndPrenom() {
        String login = lg.generateLoginForNomAndPrenom("Durand", "Paul");
        Assert.assertEquals("PDUR", login);
    }

    @Test
    public void generateLoginForJRAL2(){
        String login = lg.generateLoginForNomAndPrenom("Ralling", "John");
        Assert.assertEquals("JRAL2", login);
    }

    @Test
    public void generateLoginPDUR(){
        String login = lg.generateLoginForNomAndPrenom("Dùrand", "Paul");
        Assert.assertEquals("PDUR", login);
    }

    @Test
    public void loginJROLNumber(){
        String login = lg.generateLoginForNomAndPrenom("Rolling", "Jean");
        Assert.assertEquals("JROL1", login);
    }
}