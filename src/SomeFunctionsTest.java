import static org.junit.jupiter.api.Assertions.*;

class SomeFunctionsTest {

    @org.junit.jupiter.api.Test
    void isPalindrome() {
        SomeFunctions s = new SomeFunctions();
        assertTrue(s.isPalindrome("aaaa"));
        assertTrue(s.isPalindrome("abccba"));
        assertTrue(s.isPalindrome("a"));
        assertTrue(s.isPalindrome(""));
        assertFalse(s.isPalindrome("as"));
        assertFalse(s.isPalindrome("abcdefgfedcbaa"));
        assertFalse(s.isPalindrome("abcdba"));
    }

    @org.junit.jupiter.api.Test
    void minSplit() {
        SomeFunctions s = new SomeFunctions();
        assertEquals(5, s.minSplit(9));
        assertEquals(6, s.minSplit(59));
        assertEquals(20, s.minSplit(1000));
        assertEquals(15, s.minSplit(567));
        assertEquals(1, s.minSplit(1));
    }

    @org.junit.jupiter.api.Test
    void notContains() {
        SomeFunctions s = new SomeFunctions();
        assertEquals(1, s.notContains(new int [] {0, -1, -200, 5, 6 ,11, 2, 3}));
        assertEquals(4, s.notContains(new int [] {5, 6, 100, 23, 0, -32}));
        assertEquals(5, s.notContains(new int [] {6}));
        assertEquals(-1, s.notContains(new int [] {1, 2, 3, 4}));
    }

    @org.junit.jupiter.api.Test
    void isProperly() {
        SomeFunctions s = new SomeFunctions();
        assertTrue(s.isProperly("()"));
        assertTrue(s.isProperly(""));
        assertTrue(s.isProperly("sasdasd(()((((()))))()())"));
        assertTrue(s.isProperly("((()))(())"));
        assertFalse(s.isProperly("("));
        assertFalse(s.isProperly(")"));
        assertFalse(s.isProperly("(()"));
        assertFalse(s.isProperly(")()()("));
    }

    @org.junit.jupiter.api.Test
    void countVariants() {
        SomeFunctions s = new SomeFunctions();
        assertEquals(1, s.countVariants(1));
        assertEquals(0, s.countVariants(0));
        assertEquals(2, s.countVariants(2));
        assertEquals(3, s.countVariants(3));
        assertEquals(5, s.countVariants(4));
        assertEquals(8, s.countVariants(5));
    }
}