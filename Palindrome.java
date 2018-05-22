public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> d = new LinkedListDeque();

        for (int pos = 0; pos < word.length(); pos++) {
            d.addLast(word.charAt(pos));
        }
        return d;
    }
    public boolean isPalindrome(String word) {
        if (word.length() == 1 || word.length() == 0) {
            return true;
        }
        int startPos = 0;
        int endPos = word.length() - 1;
        while (startPos <= endPos) {
            if (word.charAt(startPos) != word.charAt(endPos)) {
                return false;
            }
            startPos++;
            endPos--;
        }
        return true;
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() == 1 || word.length() == 0) {
            return true;
        }
        int startPos = 0;
        int endPos = word.length() - 1;
        while (startPos <= endPos) {
            if (startPos == endPos) {
                break;
            }
            if (!(cc.equalChars(word.charAt(startPos), word.charAt(endPos)))) {
                return false;
            }
            startPos++;
            endPos--;
        }
        return true;
    }
}
