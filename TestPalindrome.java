import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        //Testing for a false output
        assertFalse(palindrome.isPalindrome("cat"));
        //Testing for a true output
        assertTrue(palindrome.isPalindrome("racecar"));
        //Testing for a palindrome with various character cases
        assertFalse(palindrome.isPalindrome("nOoN"));
        //Testing for a palindrome with 0 letters
        assertTrue(palindrome.isPalindrome(""));
        //Testing for a palindrome with 1 letters
        assertTrue(palindrome.isPalindrome("p"));
        //Testing for a palindrome with even letters
        assertTrue(palindrome.isPalindrome("noon"));
        //Testing for a palindrome with odd letters
        assertTrue(palindrome.isPalindrome("kayak"));
        //Testing for a palindrome with a space in between
        assertFalse(palindrome.isPalindrome("never odd or even"));
        //Testing for a palindrome with a special characters
        assertFalse(palindrome.isPalindrome("@#$%^&"));
        //Testing for a palindrome with a special characters
        assertTrue(palindrome.isPalindrome("@#$%^&&^%$#@"));
        //Testing for a palindrome with a special characters
        assertTrue(palindrome.isPalindrome("@Aa#aA;;Aa#aA@"));

        /***
         * Test 1: Test for a general false output
         * Test 2: Test for a general true output
         * Test 3: Test for uppercase and lowercase false output
         * Test 4: Test for uppercase and lowercase true output
         * Test 5: Test for uppercase false output
         * Test 6: Test for uppercase true output
         * Test 7: Test for special characters true output
         * Test 8: Test for special characters false output
         * Test 9: Test for all characters false output
         * Test 10: Test for all characters true output
         * Test 11: Test for no characters true output
         * Test 12: Test for one character true output
         * Test 13: Test for ASCII Bordering Uppercase and Special characters
         * Test 14: Test for ASCII Bordering Special and Lowercase characters
         */

        assertFalse(palindrome.isPalindrome("horse", new OffByOne()));
        assertTrue(palindrome.isPalindrome("detrude", new OffByOne()));

        assertFalse(palindrome.isPalindrome("RacEcAR", new OffByOne()));
        assertTrue(palindrome.isPalindrome("RaCEDbS", new OffByOne()));

        assertFalse(palindrome.isPalindrome("HORSE", new OffByOne()));
        assertTrue(palindrome.isPalindrome("DETRUDE", new OffByOne()));

        assertFalse(palindrome.isPalindrome("^&*(^$^%&*", new OffByOne()));
        assertTrue(palindrome.isPalindrome("``  !!__", new OffByOne()));

        assertFalse(palindrome.isPalindrome("A~!@#aaslk##%", new OffByOne()));
        assertTrue(palindrome.isPalindrome("#$ABababAB#$", new OffByOne()));

        assertTrue(palindrome.isPalindrome("", new OffByOne()));
        assertTrue(palindrome.isPalindrome("p", new OffByOne()));

        assertTrue(palindrome.isPalindrome("@A@A", new OffByOne()));
        assertTrue(palindrome.isPalindrome("`a`a", new OffByOne()));

        // Extra Test Cases for OffByOne()
        assertTrue(palindrome.isPalindrome("\t#\n", new OffByOne()));
        assertFalse(palindrome.isPalindrome("racecar", new OffByOne()));
        assertFalse(palindrome.isPalindrome("nOoN", new OffByOne()));
        assertTrue(palindrome.isPalindrome("", new OffByOne()));
        assertTrue(palindrome.isPalindrome("p", new OffByOne()));
        assertFalse(palindrome.isPalindrome("noon", new OffByOne()));
        assertFalse(palindrome.isPalindrome("kayak", new OffByOne()));
        assertFalse(palindrome.isPalindrome("never odd or even", new OffByOne()));
        assertTrue(palindrome.isPalindrome("detrude", new OffByOne()));
        assertFalse(palindrome.isPalindrome("kayak", new OffByOne()));
        assertFalse(palindrome.isPalindrome("never odd or even", new OffByOne()));
        assertTrue(palindrome.isPalindrome("`aba", new OffByOne()));
        assertFalse(palindrome.isPalindrome("##$%^&**&^%$#$%^&*()(*&^%", new OffByOne()));
        assertTrue(palindrome.isPalindrome("DETRUDE", new OffByOne()));
        assertFalse(palindrome.isPalindrome("DETRUDD", new OffByOne()));
    }

}
