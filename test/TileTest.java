/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Valeria
 */
public class TileTest {

    public TileTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testValidOrderNumber() {
        Tile tile = new Tile(5);
        assertEquals(5, tile.getOrderNumber());
    }

    @Test
    public void testTooSmallOrderNumber() {
        try {
            Tile tile = new Tile(0);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception, received one.
        }
    }
    
    @Test
    public void testTooBigOrderNumber() {
        try {
            Tile tile = new Tile(100);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception, received one.
        }        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
