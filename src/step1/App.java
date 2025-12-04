package step1;

import java.util.Scanner;

public class App {
    /*   TODO: step_1 기능 구현

         Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있습니다.
            양의 정수는 각각 하나씩 전달 받습니다.
            양의 정수는 적합한 타입으로 선언한 변수에 저장합니다.

         사칙연산 기호(➕,➖,✖️,➗)를 입력받기
            Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다.
            사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다. (charAt(0))

         위에서 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력하기
            키워드 : `if` `switch`
            사칙연산 기호에 맞는 연산자를 사용하여 연산을 진행합니다.
            입력받은 연산 기호를 구분하기 위해 제어문을 사용합니다. (예를 들면 if, switch)
            연산 오류가 발생할 경우 해당 오류에 대한 내용을 정제하여 출력합니다.

          반복문을 사용하되, 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정하기
            키워드 : 무한으로 반복, 수정하기 (처음부터 무한 반복하는 것이 아니라, 위 스텝별로 진행하며 수정)
            반복문을 사용합니다. (예를 들어, for, while…)

     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        int value1 = sc.nextInt();
        System.out.print("두 번째 숫자를 입력하세요: ");
        int value2 = sc.nextInt();

        System.out.print("사칙연산 기호를 입력하세요: ");
        char operations = sc.next().charAt(0);

        int result = 0;
        switch (operations) {
            case '+':
                result = value1 + value2;
                break;
            case '-':
                result = value1 - value2;
                break;
            case '*', 'x','X':  //곱하기 기호는 혼동이 쉽기 때문에 3가지의 경우를 case로 잡음
                result = value1 * value2;
                break;
            case '/':
                /// if문이 / 연산보다 늦게 오면 자바 자체 오류처리 발생
                if (value2 == 0) {
                    System.out.println("분모가 0이 될 순 없습니다.");
                    System.exit(0);  ///강제 종료 하지 않으면 swith 문 밖의 결과가 출력 되므로 프로그램 강제 종료
                }
                result = value1 / value2;
                break;
            default:
                System.out.println("사칙 연산 기호는 더하기 +, 빼기 -, 곱하기 (*, x, X), 나누기 /로 입력해 주세요");
        }
        System.out.println("결과: " + result);

    }
}
