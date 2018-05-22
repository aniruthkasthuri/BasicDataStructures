public class OffByN implements CharacterComparator {
    private int n;

    public OffByN(int x) {
        n = x;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int b = x;
        int a = y;
        if (Math.abs(a - b) == n) {
            return true;
        }
        return false;
    }
}
