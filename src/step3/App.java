package step3;


import step2.Calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator calculator = new ArithmeticCalculator();  //Calculator 객체 생성
        OperatorType operatorType = OperatorType.SUM;
        char operations;



        int count = 0;  //인덱스 값을 알기위해 반복 횟수 카운트
        do {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int value1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int value2 = sc.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: ");
            operations = sc.next().charAt(0);

            sc.nextLine();  //아직 잔여 개행문자가 남아있어 아래 text를 입력 받을 때, nextLine이 동작하지 않는다, 그래서 해당 코드로 개행문자를 소비해준다.

            int result = calculator.calculate(value1, value2, operations);  //calculate 메서드 호출
            System.out.println("결과: " + result);

            calculator.addNumbers(result);  //ArrayList에 결과를 추가시킴


            //calculator.setNumbers(count, result);
            int a = calculator.getNumbers(count++);
            System.out.println("게터 결과: " + a);


            while(true){
                System.out.println("첫 결과를 삭제하시겠습니까? Y/N");
                char choice = sc.next().charAt(0);
                if (choice == 'Y') {
                    calculator.removeResult();
                    count--;  //삭제 시 전체적으로 인덱스가 밀리므로 -1 해줘야 함
                    break;
                } else if (choice == 'N') {
                    break;
                } else {
                    System.out.println("문자를 잘못 입력하셨습니다.");
                }
            }

            sc.nextLine();

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String text = sc.nextLine();
            if (text.equals("exit")) {
                System.out.println("모든 계산 결과: " + calculator.getAllNumbers());
                break;
            }
        } while (true);
    }
}
