
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestRAM.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestRAM
{
    @Test
    public void testConstructor(){
        Inventory inv = new RAM();
        inv.addItem(new DataItem("File", "Malicious", 1));
        assertEquals(true, inv.hasItem("File"));
    }

    @Test
    public void testAddItem(){
        Inventory inv = new RAM();
        Item data = new DataItem("File", "Malware", 1);
        inv.addItem(data);
        assertEquals("Malware", inv.getItem("File").getDescription());
        Item phys = new PhysicalItem("Floppy Disk", "Old", 1);
        phys.use(1);
        inv.addItem(phys);
        assertEquals(false, inv.hasItem("Floppy Disk"));
    }
}
