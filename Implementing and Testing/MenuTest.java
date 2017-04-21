import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;

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
		String data = "name \n desc \n 99.99 \n 234 \n";
		InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
		System.setIn( testInput );
		menu.addItem();		
		assertThat(outContent.toString(), containsString("Item has been added!"));
	}
	@Test
	public void testAddItem2() throws UnsupportedEncodingException {
		String data = "name \n desc \n price \n 234 \n";
		InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
		System.setIn( testInput );
		menu.addItem();		
		assertThat(outContent.toString(), containsString("Invalid entry, item has NOT been added!"));
	}
	@Test
	public void testAddItem3() throws UnsupportedEncodingException {
		String data = "name \n desc \n 19.99 \n calories \n";
		InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
		System.setIn( testInput );
		menu.addItem();		
		assertThat(outContent.toString(), containsString("Invalid entry, item has NOT been added!"));
	}
	@Test
	public void testView() throws UnsupportedEncodingException {
		menu.view();
		assertThat(outContent.toString(), containsString("There are no menu items to view!"));		
	}	
	@Test
	public void testView2() throws UnsupportedEncodingException {
		String data = "name \n desc \n 99.99 \n 234 \n";
		InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
		System.setIn( testInput );
		menu.addItem();		
		menu.view();
		assertThat(outContent.toString(), containsString("name"));
		assertThat(outContent.toString(), containsString("desc"));
		assertThat(outContent.toString(), containsString("$99.99"));
		assertThat(outContent.toString(), containsString("Calories: 234"));
	}
	
	@Test
	public void testEditItem() throws UnsupportedEncodingException {
		String data = "name \n desc \n 99.99 \n 234";
		InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
		System.setIn( testInput );
		menu.addItem();		
		
		data = "1\n  1\n hh \n hh newName";
		testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
		System.setIn( testInput );
		menu.editItem();
		
		assertThat(outContent.toString(), containsString("newName"));
	}
	
	
	

}
