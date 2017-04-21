import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

/**
 * The test cases for Menu
 * 
 *
 */
public class MenuTest {
	private Menu menu;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUp() throws Exception {
		menu = new Menu();
		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void testAddItem1() throws UnsupportedEncodingException {
		String data = "\n name \n desc \n 99.99 \n 234 \n";
		InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
		System.setIn( testInput );
		Scanner scanner = new Scanner(System.in);
		menu.addItem(scanner);		
		assertThat(outContent.toString(), containsString("Item has been added!"));
	}
	@Test
	public void testAddItem2() throws UnsupportedEncodingException {
		String data = "\n name \n desc \n price \n 234 \n";
		InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
		System.setIn( testInput );
		Scanner scanner = new Scanner(System.in);
		menu.addItem(scanner);		
		assertThat(outContent.toString(), containsString("Invalid entry, item has NOT been added!"));
	}
	@Test
	public void testAddItem3() throws UnsupportedEncodingException {
		String data = "\n name \n desc \n 19.99 \n calories \n";
		InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
		System.setIn( testInput );
		Scanner scanner = new Scanner(System.in);
		menu.addItem(scanner);		
		assertThat(outContent.toString(), containsString("Invalid entry, item has NOT been added!"));
	}
	@Test
	public void testView() throws UnsupportedEncodingException {
		menu.view();
		assertThat(outContent.toString(), containsString("There are no menu items to view!"));		
	}	
	@Test
	public void testView2() throws UnsupportedEncodingException {
		String data = "\n name \n desc \n 99.99 \n 234 \n";
		InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
		System.setIn( testInput );
		Scanner scanner = new Scanner(System.in);
		menu.addItem(scanner);		
		menu.view();
		assertThat(outContent.toString(), containsString("name"));
		assertThat(outContent.toString(), containsString("desc"));
		assertThat(outContent.toString(), containsString("$99.99"));
		assertThat(outContent.toString(), containsString("Calories: 234"));
	}
	
	@Test
    public void testEditItem() throws UnsupportedEncodingException {
        String data = "\n name \n desc \n 99.99 \n 234";
        InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn( testInput );
        Scanner scanner = new Scanner(System.in);
        menu.addItem(scanner);  
        data = "1\n  1\n newName";
        testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn( testInput );
        scanner = new Scanner(System.in);
        menu.editItem(scanner);
        menu.view();        
        assertThat(outContent.toString(), containsString("Item has been added!"));
        assertThat(outContent.toString(), containsString("newName"));
    }
    @Test
    public void testEditItem2() throws UnsupportedEncodingException {
        String data = "\n name \n desc \n 99.99 \n 234";
        InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn( testInput );
        Scanner scanner = new Scanner(System.in);
        menu.addItem(scanner);  
        data = "1\n  2\n newDes";
        testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn( testInput );
        scanner = new Scanner(System.in);
        menu.editItem(scanner);
        menu.view();        
        assertThat(outContent.toString(), containsString("Item has been added!"));
        assertThat(outContent.toString(), containsString("newDes"));
    }
    @Test
    public void testEditItem3() throws UnsupportedEncodingException {
        String data = "\n name \n desc \n 99.99 \n 234";
        InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn( testInput );
        Scanner scanner = new Scanner(System.in);
        menu.addItem(scanner);  
        data = "1\n  3\n price";
        testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn( testInput );
        scanner = new Scanner(System.in);
        menu.editItem(scanner);
        menu.view();        
        assertThat(outContent.toString(), containsString("Item has been added!"));
        assertThat(outContent.toString(), containsString("Invalid"));
    }
    @Test
    public void testEditItem4() throws UnsupportedEncodingException {
        String data = "\n name \n desc \n 99.99 \n 234";
        InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn( testInput );
        Scanner scanner = new Scanner(System.in);
        menu.addItem(scanner);  
        data = "1\n  3\n 45.99";
        testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn( testInput );
        scanner = new Scanner(System.in);
        menu.editItem(scanner);
        menu.view();        
        assertThat(outContent.toString(), containsString("Item has been added!"));
        assertThat(outContent.toString(), containsString("$45.99"));
    }
    @Test
    public void testEditItem5() throws UnsupportedEncodingException {
        String data = "\n name \n desc \n 99.99 \n 234";
        InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn( testInput );
        Scanner scanner = new Scanner(System.in);
        menu.addItem(scanner);  
        data = "1\n  4\n 455";
        testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn( testInput );
        scanner = new Scanner(System.in);
        menu.editItem(scanner);
        menu.view();        
        assertThat(outContent.toString(), containsString("Item has been added!"));
        assertThat(outContent.toString(), containsString("Calories: 455"));
    }
    @Test
    public void testEditItem6() throws UnsupportedEncodingException {
        String data = "\n name \n desc \n 99.99 \n 234";
        InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn( testInput );
        Scanner scanner = new Scanner(System.in);
        menu.addItem(scanner);  
        data = "1\n  5\n";
        testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn( testInput );
        scanner = new Scanner(System.in);
        menu.editItem(scanner);
        menu.view();        
        assertThat(outContent.toString(), containsString("Item has been added!"));
        assertThat(outContent.toString(), containsString("name"));
        assertThat(outContent.toString(), containsString("desc"));
        assertThat(outContent.toString(), containsString("99.99"));
        assertThat(outContent.toString(), containsString("234"));
    }
	
	@Test
	public void testDeleteItem() throws UnsupportedEncodingException {
	    String data = "\n name \n desc \n 99.99 \n 234";
        InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn( testInput );
        Scanner scanner = new Scanner(System.in);
        menu.addItem(scanner);
        
        data = "1";
        testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn( testInput );
        scanner = new Scanner(System.in);
        menu.deleteItem(scanner);
	    
        assertThat(outContent.toString(), containsString("Item was deleted!"));
	}
	
	@Test
	public void testDeleteEmptyMenu() throws UnsupportedEncodingException {
	    Scanner scanner = new Scanner(System.in);
        menu.deleteItem(scanner);
        assertThat(outContent.toString(), containsString("There are no items on the menu"));
	}
	
	@Test
    public void testInvalidDelete() throws UnsupportedEncodingException {
	    String data = "\n name \n desc \n 99.99 \n 234";
        InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn( testInput );
        Scanner scanner = new Scanner(System.in);
        menu.addItem(scanner);
        
        data = "2";
        testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn( testInput );
        scanner = new Scanner(System.in);
        menu.deleteItem(scanner);
        assertThat(outContent.toString(), containsString("Invalid item number!"));
    }
	
	@Test
	public void testSuggestedDish() throws UnsupportedEncodingException {
	    String data = "\n name \n desc \n 99.99 \n 234";
        InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn( testInput );
        Scanner scanner = new Scanner(System.in);
        menu.suggestDish(scanner);
        
        assertThat(outContent.toString(), containsString("Item has been suggested!"));
	}
	
	@Test
	public void testInvalidSuggested() throws UnsupportedEncodingException {
	    String data = "\n name \n desc \n 99.99 \n 234";
        InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn( testInput );
        Scanner scanner = new Scanner(System.in);
        menu.suggestDish(scanner);
        
        menu.suggestDish(scanner);
        
        assertThat(outContent.toString(), containsString("Invalid entry"));
	}
	
	@Test
    public void testSuggestedDuplicated() throws UnsupportedEncodingException {
        String data = "\n name \n desc \n 99.99 \n 234";
        InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn( testInput );
        Scanner scanner = new Scanner(System.in);
        menu.suggestDish(scanner);
        
        testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn( testInput );
        scanner = new Scanner(System.in);
        menu.suggestDish(scanner);
        
        assertThat(outContent.toString(), containsString("exists"));
    }
	
	@Test
	public void testViewSuggestion() throws UnsupportedEncodingException {
	    String data = "\n name \n desc \n 99.99 \n 234";
        InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn( testInput );
        Scanner scanner = new Scanner(System.in);
        menu.suggestDish(scanner);
        
        menu.viewSuggested();
        
        assertThat(outContent.toString(), containsString("name"));
	}

}
