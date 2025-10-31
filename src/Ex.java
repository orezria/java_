import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("5개의 정수를 입력하세요.");
        int intArray[] = new int[5];

        double sum = 0.0;
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = scanner.nextInt();  //키보드에서 입력받은 정수 저장
        }
        for (int i = 0; i < intArray.length; i++) {
            sum += intArray[i];
        }
        System.out.println("평균은" + sum / intArray.length);
        scanner.close();

    }
}