package step2;

import java.util.Scanner;

public class App {
    /*TODO: step_2 기능 구현
    **사칙연산을 수행 후, 결과값 반환 메서드 구현 & 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성**
        사칙연산을 수행한 후, 결과값을 반환하는 메서드 구현
        연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성
        1) 양의 정수 2개(0 포함)와 연산 기호를 매개변수로 받아 사칙연산(➕,➖,✖️,➗) 기능을 수행한 후
        2) 결과 값을 반환하는 메서드와 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성합니다.

    **STEP 1에서 구현한 App 클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정**
        연산 수행 역할은 Calculator 클래스가 담당
        연산 결과는 Calculator 클래스의 연산 결과를 저장하는 필드에 저장
        소스 코드 수정 후에도 수정 전의 기능들이 반드시 똑같이 동작해야합니다.

    **App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정 (캡슐화)**
        간접 접근을 통해 필드에 접근하여 **가져올** 수 있도록 구현합니다. (Getter 메서드)
        간접 접근을 통해 필드에 접근하여 **수정할** 수 있도록 구현합니다. (Setter 메서드)
        위 요구사항을 모두 구현 했다면 App 클래스의 main 메서드에서 위에서 구현한 메서드를 활용 해봅니다.

    **Calculator 클래스에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드를 구현한 후 **
        App 클래스의 main 메서드에 삭제 메서드가 활용될 수 있도록 수정
        키워드 : `컬렉션`
        컬렉션에서 ‘값을 넣고 제거하는 방법을 이해한다.’가 중요합니다!
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();  //Calculator 객체 생성
        do {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int value1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int value2 = sc.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operations = sc.next().charAt(0);

            sc.nextLine();  //아직 잔여 개행문자가 남아있어 아래 text를 입력 받을 때, nextLine이 동작하지 않는다, 그래서 해당 코드로 개행문자를 소비해준다.

            int result = calculator.calculate(value1, value2, operations);  //calculate 메서드 호출

            System.out.println("결과: " + result);

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String text = sc.nextLine();
            if (text.equals("exit")) {
                break;
            }
        } while (true);
    }
}
