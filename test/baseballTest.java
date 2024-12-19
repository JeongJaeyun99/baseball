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
        baseball b = new baseball();

    }

    @org.junit.jupiter.api.Test
    void inputNumbers() {
        baseball baseball= new baseball();
        int[] check = {1,2,3};
        assertArrayEquals(check , baseball.inputNumbers(1,9,3));
    }

    @org.junit.jupiter.api.Test
    void checkDuplicate() {
        baseball baseball= new baseball();
        int[] arr = {1,2,3};
        assertTrue(!baseball.checkDuplicate(arr , 1));
    }

    @org.junit.jupiter.api.Test
    void compare() {
        baseball baseball= new baseball();
        int[] input = {1,2,3};
        int[] check = {1,2,3};

        assertArrayEquals(new String[]{"strike", "strike", "strike"}, baseball.compare(input, check));
    }

    @org.junit.jupiter.api.Test
    void view() {
    }
}