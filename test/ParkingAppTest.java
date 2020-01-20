import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test parking lot application with CLI commands
 *
 * @author Gregorius Kristian Purwidi
 */
public class ParkingAppTest {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outStream));
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        System.setOut(originalOut);
    }

    /**
     * Test method for {@link parkinglotgojek.ParkingApp#main(java.lang.String[])}.
     */
    @Test
    public void testMain() {

        String inputFile = "test/test_commands.txt";
        String outputFile = "test/expected_output.txt";

        boolean keepRun = true;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String command;
            while ((command = br.readLine()) != null) {
                keepRun = ParkingApp.runCommand(command);
            }
        } catch(IOException e) {
            fail("IO exception");
        }

        //Assert output
        //TODO there must be a better way than this
        try (BufferedReader br = new BufferedReader(new FileReader(outputFile))) {
            int i = 0;
            String expected;
            String output[] = outStream.toString().split("\\r?\\n");
            while ((expected = br.readLine()) != null) {
                assertEquals(expected, output[i]);
                i++;
            }
        } catch(IOException e) {
            fail("IO exception");
        }
    }

}
