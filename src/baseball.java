import java.util.Arrays;
import java.util.Scanner;
import java.util.SplittableRandom;

public class baseball {

    public static void main(String[] args) {
        baseball baseball = new baseball(1,9,3);
        baseball.play();
    }

    int minNum;
    int maxNum;

    int maxArrayLength;

    int[] inputArray = new int[maxArrayLength];
    int[] gameArray = new int [maxArrayLength];

    baseball(int min , int max , int maxArrayLength){
        this.minNum = min;
        this.maxNum = max;
        this.maxArrayLength = maxArrayLength;
    }

    public void play(){
        this.inputArray = this.inputNumbers(minNum , maxNum,maxArrayLength);
        this.gameArray = this.numberGenerator(minNum , maxNum, maxArrayLength);
        String[] result = this.compare(inputArray, gameArray);
        System.out.println(Arrays.toString(inputArray));
        System.out.println(Arrays.toString(gameArray));
        view.resultView(result);
    }

    public int[] numberGenerator(int min, int max , int length){
        int[] returnArray = new int[length];
        SplittableRandom rand = new SplittableRandom();
        int randNum;

        for(int i = 0; i < length; i++){
            returnArray[i] = min - 1;
        }

        for(int i = 0; i < length; i++){
            randNum = rand.nextInt(min, max+1);
            if(!checkDuplicate(returnArray, randNum)){
                i = i -1;
            }
            else{
                returnArray[i] = randNum;
            }
        }

        return returnArray;
    }

    public int[] inputNumbers(int min, int max, int length){
        int[] returnArray = new int[length];
        Scanner sc = new Scanner(System.in);
        int inputNum;

        for(int i = 0; i < length; i++) {
            returnArray[i] = min - 1;
        }

        for(int i = 0; i < length; i++){
            inputNum = sc.nextInt();
            if(inputNum < min){
                view.inputCheckMin();
                i = i-1;
            }
            else if(inputNum > max){
                view.inputCheckMax();
                i = i-1;
            }
            else if(!checkDuplicate(returnArray, inputNum)){
                view.inputCheckDuplicate();
                i = i -1;
            }
            else{
                returnArray[i] = inputNum;
            }
        }

        return returnArray;
    }

    public boolean checkDuplicate(int[] array , int checkNum){
        for(int i = 0; i < array.length ; i ++){
            if(array[i] == checkNum){
                return false;
            }
        }
        return true;
    }

    public String[] compare(int[] inputArray,  int[] gameArray){
        String[] returnArray = new String[gameArray.length];

        for(int i = 0; i < gameArray.length; i++) {
            //out
            returnArray[i] = "out";

            //ball
            for (int j = 0; j < gameArray.length; j++) {
                if (inputArray[i] == gameArray[j]) {
                    returnArray[i] = "ball";
                }
            }

            //strike
            if (inputArray[i] == gameArray[i]) {
                returnArray[i] = "strike";
            }
        }
        return returnArray;
    }

    public void view(String[] result){
        System.out.println("결과입니다");
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
    }

    public class view{
        public static void resultView(String[] result){
            System.out.println("결과입니다");
            System.out.println(result[0]);
            System.out.println(result[1]);
            System.out.println(result[2]);
        }

        public static void inputCheckDuplicate(){
            System.out.println("중복되지 않는 값을 입력해주세요");
        }

        public static void inputCheckMin(){
            System.out.println("최소값 이상의 값을 입력해주세요");
        }

        public static void inputCheckMax(){
            System.out.println("최대값 이하의 값을 입력해주세요");
        }

    }
}



