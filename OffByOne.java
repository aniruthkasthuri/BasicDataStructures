public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        int b = x;
        int a = y;
        if (Math.abs(a - b) == 1) {
            return true;
        }
        return false;
    }
}
