
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestGamePlay.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestGamePlay
{
    /**
     * Default constructor for test class TestGamePlay
     */
    public TestGamePlay()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    @Test
    public void testGame(){
        Wake w = new Wake();
        Blackbox b = new Blackbox();
        CommandPrompt c = new CommandPrompt();
        Inventory ram = new RAM();
        Player p = new Caleb();

        try{
            //wts.testGenPers();
            //c.enter(p);
            c.enter(p);
        }
        catch(InterruptedException err){
            System.out.println("oh noooo");
        }
        //assertEquals(p, wts.enter(p));
        //System.out.println(wts.generatePerson().personToString());

    }
}
