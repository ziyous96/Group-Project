import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;

/**
 * The system test cases for the 4 use cases
 * 
 *
 */
public class SystemTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
    }

    /*
     * This system test represent the main success scenario for the add menu item use case.
     */
    @Test
    public void test1() throws UnsupportedEncodingException, FileNotFoundException {
        String data = "1 \n 2\n name1 \n desc1 \n 99.99 \n 234 \n 1\n 7 \n 5 \n ";
        InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn( testInput );
        Main.main(null);
        assertThat(outContent.toString(), containsString("has been added"));
        assertThat(outContent.toString(), containsString("name1"));
        assertThat(outContent.toString(), containsString("desc1"));
        assertThat(outContent.toString(), containsString("$99.99"));
        assertThat(outContent.toString(), containsString("Calories: 234"));
    }
    

    /*
     * This system test represent the main success scenario for the delete menu item use case.
     */
    @Test
    public void test2() throws UnsupportedEncodingException, FileNotFoundException {
        String data = "1 \n 2\n name1 \n desc1 \n 99.99 \n 234 \n 1\n 3\n 1\n"
                + "1\n 7 \n 5 \n ";
        InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn( testInput );
        Main.main(null);
        assertThat(outContent.toString(), containsString("has been added"));
        assertThat(outContent.toString(), containsString("name1"));
        assertThat(outContent.toString(), containsString("desc1"));
        assertThat(outContent.toString(), containsString("$99.99"));
        assertThat(outContent.toString(), containsString("Calories: 234"));
        assertThat(outContent.toString(), containsString("Item was deleted!"));
        assertThat(outContent.toString(), containsString("There are no menu items to view!"));
    }

    /*
     * This system test represent the main success scenario for the editing menu item use case.
     */
    @Test
    public void test3() throws UnsupportedEncodingException, FileNotFoundException {
        String data = "1 \n 2\n name1 \n desc1 \n 99.99 \n 234 \n 1\n 4\n 1\n 1\n newName\n 1\n"
                + "4\n  1\n 2\n desc2\n 1\n 4\n 1\n 3\n 9.99\n 1\n 4\n 1\n 4\n 300\n 1\n 7\n 5\n";
        InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn( testInput );
        Main.main(null);
        assertThat(outContent.toString(), containsString("has been added"));
        assertThat(outContent.toString(), containsString("name1"));
        assertThat(outContent.toString(), containsString("desc1"));
        assertThat(outContent.toString(), containsString("$99.99"));
        assertThat(outContent.toString(), containsString("Calories: 234"));
        assertThat(outContent.toString(), containsString("newName"));
        assertThat(outContent.toString(), containsString("desc2"));
        assertThat(outContent.toString(), containsString("$9.99"));
        assertThat(outContent.toString(), containsString("Calories: 300"));
    }
    
    /*
     * This system test represent the main success scenario for the dish promotion use case.
     */
    @Test
    public void test4() throws UnsupportedEncodingException, FileNotFoundException {
        String data = "1 \n 5\n name1 \n desc1 \n 99.99 \n 234 \n 6\n 7\n 5\n";
        InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn( testInput );
        Main.main(null);
        assertThat(outContent.toString(), containsString("Suggested Dishes:"));
        assertThat(outContent.toString(), containsString("name1"));
        assertThat(outContent.toString(), containsString("desc1"));
        assertThat(outContent.toString(), containsString("$99.99"));
        assertThat(outContent.toString(), containsString("Calories: 234"));
    }
}
