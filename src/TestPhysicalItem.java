

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestPhysicalItem.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestPhysicalItem
{
    @Test
    public void testFailingConstructor()
    {
        Item i = new PhysicalItem("Money", "Cash money!", -1);
        //Should crash
    }
    
    @Test
    public void testGetCount()
    {
        Item i = new PhysicalItem("Money", "Cash money!", 10);
        assertEquals(10, i.getCount());
    }
    
    @Test
    public void testUse()
    {
        Item i = new PhysicalItem("Money", "Cash money", 10);
        i.use(8);
        assertEquals(2, i.getCount());
        i.use(2);
        assertEquals(0, i.getCount());
    }
    
    @Test
    public void testFailingOverUse()
    {
        Item i = new PhysicalItem("Money", "Cash money", 10);
        i.use(8);
        assertEquals(2, i.getCount());
        i.use(2);
        assertEquals(0, i.getCount());
        i.use(1);
    }
    
    @Test
    public void testFailingNegativeUse()
    {
        Item i = new PhysicalItem("Money", "Cash money", 10);
        i.use(8);
        assertEquals(2, i.getCount());
        i.use(-2);
    }
    
    @Test
    public void testFailingZeroUse()
    {
        Item i = new PhysicalItem("Money", "Cash money", 10);
        i.use(8);
        assertEquals(2, i.getCount());
        i.use(0);
    }
    
    @Test
    public void testCombine()
    {
        Item m0 = new PhysicalItem("Money", "Cash money", 10);
        Item m1 = new PhysicalItem("Money", "Cash money", 30);
        m0.combine(m1);
        assertEquals(40, m0.getCount());
        assertEquals(30, m1.getCount());  
    }
    
    
    @Test
    public void testFailingWrongNameCombine()
    {
        Item m0 = new PhysicalItem("Wallet", "Cash money", 10);
        Item m1 = new PhysicalItem("Money", "Cash money", 30);
        m0.combine(m1);
        // Should crash
    }
    
    @Test
    public void testFailingWrongDescriptionCombine()
    {
        Item m0 = new PhysicalItem("Money", "Currency", 10);
        Item m1 = new DataItem("Money", "Dollars", 30);
        m0.combine(m1);
        // Should crash
    }
    
    @Test
    public void testSameNameAndDescriptionButWrongType(){
        Item itemOne = new PhysicalItem("Money", "Currency", 10);
        Item itemTwo = new DataItem("Money", "Currency", 10);
        
        itemOne.combine(itemTwo);
    }
}
