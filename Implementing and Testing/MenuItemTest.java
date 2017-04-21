import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test cases for the MenuItem
 * @author Ziyou Shang
 *
 */
public class MenuItemTest {
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    /**
     * to test the getName() method
     */
    public void testGetName() {
        MenuItem item = new MenuItem("apple", "sliced apple", 5.99, 20);
        assertEquals("apple", item.getName());
    }
    
    @Test
    /**
     * to test the setName() method
     */
    public void testSetName() {
        MenuItem item = new MenuItem("apple", "sliced apple", 5.99, 20);
        item.setName("banana");
        assertEquals("banana", item.getName());
    }
    
    @Test
    /**
     * to test the getDescription() method
     */
    public void testGetDescription() {
        MenuItem item = new MenuItem("apple", "sliced apple", 5.99, 20);
        assertEquals("sliced apple", item.getDescription());
    }
    
    @Test
    /**
     * to test the setDescription() method
     */
    public void testSetDescription() {
        MenuItem item = new MenuItem("apple", "sliced apple", 5.99, 20);
        item.setDescription("diced apple");
        assertEquals("diced apple", item.getDescription());
    }
    
    @Test
    /**
     * to test the getPrice() method
     */
    public void testGetPrice() {
        MenuItem item = new MenuItem("apple", "sliced apple", 5.99, 20);
        assertEquals(5.99, item.getPrice(), 0.01);
    }
    
    @Test
    /**
     * to test the setPrice() method
     */
    public void testSetPrice() {
        MenuItem item = new MenuItem("apple", "sliced apple", 5.99, 20);
        item.setPrice(4.99);
        assertEquals(4.99, item.getPrice(), 0.01);
    }
    
    @Test
    /**
     * to test the getCalories() method
     */
    public void testGetCalories() {
        MenuItem item = new MenuItem("apple", "sliced apple", 5.99, 20);
        assertEquals(20, item.getCalories());
    }
    
    @Test
    /**
     * to test the setCalories() method
     */
    public void testSetCalories() {
        MenuItem item = new MenuItem("apple", "sliced apple", 5.99, 20);
        item.setCalories(30);
        assertEquals(30, item.getCalories());
    }
    
    @Test
    /**
     * to test the print method
     */
    public void testPrint() {
        MenuItem item = new MenuItem("apple", "sliced apple", 5.99, 20);
        item.print();
        assertEquals("apple\t\t$5.99\nsliced apple\nCalories: 20\n", outContent.toString());
        
    }

}
