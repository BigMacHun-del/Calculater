package step3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator calculator = new ArithmeticCalculator();  //Calculator 객체 생성
        OperatorType operatorType = OperatorType.SUM;
        char operations;

        int count = 0;  //인덱스 값을 알기위해 반복 횟수 카운트
        do {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                double value1 = sc.nextDouble();
                System.out.print("두 번째 숫자를 입력하세요: ");
                double value2 = sc.nextDouble();
                System.out.print("사칙연산 기호를 입력하세요: ");
                operations = sc.next().charAt(0);

                sc.nextLine();  //아직 잔여 개행문자가 남아있어 아래 text를 입력 받을 때, nextLine이 동작하지 않는다, 그래서 해당 코드로 개행문자를 소비해준다.

                Double result = calculator.calculate(value1, value2, operations).doubleValue();  //calculate 메서드 호출
                System.out.println("결과: " + result);

                calculator.addNumbers(result);  //ArrayList에 결과를 추가시킴

                //calculator.setNumbers(count, result);
                Double getresult = calculator.getNumbers(count).doubleValue();
                System.out.println("리스트 추가 완료: " + getresult);
                count++;

                while(true){
                    System.out.println("첫 결과를 삭제하시겠습니까? Y/N");
                    char choice = sc.next().charAt(0);
                    sc.nextLine();

                    if (choice == 'Y' || choice == 'y') {
                        calculator.removeResult();
                        count--;  //삭제 시 전체적으로 인덱스가 밀리므로 -1 해줘야 함
                        break;
                    } else if (choice == 'N' || choice == 'n') {
                        break;
                    } else {
                        System.out.println("문자를 잘못 입력하셨습니다.");
                    }
                }

                //람다 스트림 활용
                Scanner sc2 = new Scanner(System.in);
                System.out.print("비교할 기준 값을 입력하세요: ");
                double baseValue = sc2.nextDouble();
                System.out.print("더 큰 값은 : ");
                System.out.println(calculator.BiggerResult(baseValue));


                System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
                String text = sc.nextLine();
                if (text.equals("exit")) {
                    System.out.println("모든 계산 결과: " + calculator.getAllNumbers());
                    break;
                }
            }catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("입력 오류(숫자를 입력 해주세요)");
            }catch (NullPointerException e) {
                System.out.println("사칙 연산 기호는 더하기 +, 빼기 -, 곱하기 (*, x, X), 나누기 /로 입력해 주세요");
            }
//            catch (ArithmeticException e) { // 0으로 나눴을 때
//                System.out.println("분모가 0이 될 순 없습니다.");
//            }

        } while (true);
    }
}
