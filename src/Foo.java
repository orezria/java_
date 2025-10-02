import java.util.Scanner;

public class Foo {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter Your Name: ");
//        String name = scanner.nextLine();
//        System.out.println("Hello, " + name + "!");
//        scanner.close();




//        int a = 33, b = 13, c = 23;
//        int big = (a > b) ? a : b;
//        System.out.println("big = " + big);

//        int a = 70;
//        if(a >= 0) {
//            System.out.println("A학점 입니다");
//            System.out.println("짝수님 축하합니다");
//        }
//        else {
//            System.out.println("홀수 입니다");




//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("월(1~12)을 입력하시오");
//        int month = scanner.nextInt();
//        switch(month) {
//            case 3:
//            case 4:
//            case 5:
//                System.out.println("봄입니다");
//                break;
//            case 6: case 7: case 8:
//                System.out.println("여름입니다");
//                break;
//            case 9: case 10: case 11:
//                System.out.println("가을입니다");
//                break;
//            case 12: case 1: case 2:
//                System.out.println("겨울입니다");
//                break;
//            default:
//                System.out.println("잘못된 입력힙니다");


        int i = 0, sum = 0;
        for (i = 1; i <= 10; i++) {
            sum += i;
            System.out.print(i);
            if (i <= 9){
                System.out.print("+");
            }
            else {
                System.out.print("=" + sum);
            }
        }
    }
}
