package step2;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    ArrayList<Integer> numbers = new ArrayList<>();

    public Integer calculate(int value1, int value2, char operations) {
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
        return result;
    }

}
