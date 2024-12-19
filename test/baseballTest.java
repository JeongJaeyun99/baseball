import static org.junit.jupiter.api.Assertions.*;

class baseballTest {

    @org.junit.jupiter.api.Test
    void main() {
    }

    @org.junit.jupiter.api.Test
    void play() {
    }

    @org.junit.jupiter.api.Test
    void numberGenerator() {
        int min = 1;
        int max = 9;
        int size = 3;
        baseball b = new baseball(min, max, size);
        int[] check = b.numberGenerator(min, max, size);
        for(int i = 1; i < check.length; i++){
            assertTrue(!b.checkDuplicate(check ,check[i]));
            assertTrue(check[i] >= min);
            assertTrue(check[i] <= max);
        }
        assertTrue(check.length == size);

    }

    @org.junit.jupiter.api.Test
    void inputNumbers() {
        baseball baseball= new baseball(1,9,3);
        int[] check = {1,2,3};
        assertArrayEquals(check , baseball.inputNumbers(1,9,3));
    }

    @org.junit.jupiter.api.Test
    void checkDuplicate() {
        baseball baseball= new baseball(1,9,3);
        int[] arr = {1,2,3};
        assertTrue(!baseball.checkDuplicate(arr , 1));
    }

    @org.junit.jupiter.api.Test
    void compare() {
        baseball baseball= new baseball(1,9,3);
        int[] input = {1,2,3};
        int[] check = {1,2,3};

        assertArrayEquals(new String[]{"strike", "strike", "strike"}, baseball.compare(input, check));

        input = new int[]{1,2,3};
        check = new int[]{3, 2, 1};
        assertArrayEquals(new String[]{"ball", "strike", "ball"}, baseball.compare(input, check));
    }

    @org.junit.jupiter.api.Test
    void view() {
    }
}