/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashSet;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Valeria
 */
public class BoardTest {

    public BoardTest() {
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
    public void createBoardWithTooFewRows() {
        try {
            Board board = new Board(2, 6);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception, received one.
        }
    }

    @Test
    public void createBoardWithTooManyRows() {
        try {
            Board board = new Board(120, 6);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception, received one.
        }
    }

    @Test
    public void createBoardWithTooFewColumns() {
        try {
            Board board = new Board(4, 2);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception, received one.
        }
    }

    @Test
    public void createBoardWithTooManyColumns() {
        try {
            Board board = new Board(4, 130);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception, received one.
        }
    }

    @Test
    public void createValidBoard() {
        Board board = new Board(4, 6);
        assertEquals("Expected 4 rows", 4, board.getRows());
        assertEquals("Expected 6 columns", 6, board.getColumns());
    }

    @Test
    public void testInitializedBoard() {
        HashSet<Integer> expectedOrderNumbers = new HashSet<>();
        for (int number = 1; number <= 19; number++) {
            expectedOrderNumbers.add(number);
        }
        Board board = new Board(4, 5);
        board.initializeBoard();
        for (int row = 0; row < board.getRows(); row++) {
            for (int column = 0; column < board.getColumns(); column++) {
                Tile tile = board.getBoard()[row][column];
                if (row < board.getRows() - 1 || column < board.getColumns() - 1) {
                    if (!expectedOrderNumbers.remove(tile.getOrderNumber())) {
                        fail("Unexpected ordernumber: " + tile.getOrderNumber());
                    }
                }
            }
        }
        if (expectedOrderNumbers.size() > 0) {
            fail("Board doesn't contain all the expected numbers, remaining: " + expectedOrderNumbers);
        }
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
