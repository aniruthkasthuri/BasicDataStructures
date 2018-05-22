import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    static CharacterComparator offByOne = new OffByOne();
    @Test
    public void testOffByOne() {

        //Testing for a true output
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('c', 'b'));

        //Testing for a false output
        assertFalse(offByOne.equalChars('r', 'b'));
        //Testing for capital output for true
        assertTrue(offByOne.equalChars('A', 'B'));
        assertFalse(offByOne.equalChars('A', 'b'));
        //Testing for capital output
        assertTrue(offByOne.equalChars('A', '@'));
        //Testing for special characters output
        assertTrue(offByOne.equalChars('$', '%'));
        //Testing for same characters output
        assertFalse(offByOne.equalChars('a', 'a'));
    }

    /*@Test
    public void testOffByN() {
        OffByN n = new OffByN(4);
        //Testing for a false output
        assertFalse(n.equalChars('a', 'b'));
        //Testing for a true output
        assertTrue(n.equalChars('a', 'e'));
    }
    */

}
