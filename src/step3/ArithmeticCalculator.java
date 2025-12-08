package step3;

import java.util.ArrayList;

public class ArithmeticCalculator <T extends Number>{
    private ArrayList<T> numbers = new ArrayList<>();  //순서가 있고, 중복 허용이 되어야 하므로 ArrayList 사용


    public T calculate(T value1, T value2, char operations) {
        double result = 0;

        OperatorType operatorType = null; //OperatorType 객체 생성

        for (OperatorType type : OperatorType.values()) {  //enum 객체를 하나씩 하나씩 입력한 연산자와 비교
            if (type.getOperator() == operations) {
                operatorType = type;
                break;
            }
        }

        if (operations == 'x' ||  operations == 'X') {   //곱하기 특수 기호 처리
            operatorType = OperatorType.MUL;
        }

//        if (operatorType == null){  //App 클래스에서 연산자 재입력 필요
//            System.out.println("사칙 연산 기호는 더하기 +, 빼기 -, 곱하기 (*, x, X), 나누기 /로 입력해 주세요");
//            return -1;
//        }

        try {
            switch (operatorType) {
                case SUM:
                    result = value1.doubleValue() + value2.doubleValue();
                    break;
                case SUB:
                    result = value1.doubleValue() - value2.doubleValue();
                    break;
                case MUL:  //곱하기 기호는 혼동이 쉽기 때문에 3가지의 경우를 case로 잡음
                    result = value1.doubleValue() * value2.doubleValue();
                    break;
                case DIV:
                    /// if문이 / 연산보다 늦게 오면 자바 자체 오류처리 발생
                    if (value2.doubleValue() == 0) {
                        System.out.println("분모가 0이 될 순 없습니다.");
                        System.exit(0);  ///강제 종료 하지 않으면 swith 문 밖의 결과가 출력 되므로 프로그램 강제 종료
                    }
                    result = value1.doubleValue() / value2.doubleValue();
                    break;

            }
        } catch (NullPointerException e) {  //연산자 입력 오류시 operatorType = null -> default 값
            System.out.println("사칙 연산 기호는 더하기 +, 빼기 -, 곱하기 (*, x, X), 나누기 /로 입력해 주세요");
            System.exit(0);     //연산자 입력 오류시 프로그램 종료(연산자를 재입력하는 구문으로 바꿔야 함)
        }
        //return (T) result;  // 직접 형변환 불가
        return (T) convertType(result, value1);  // 제네릭 타입으로 형변환
    }

    private Number convertType(double result, T value) {  // result가 무슨 타입인지 확실히 파악하고 리턴
        if (value instanceof Integer) {
            return (int) result;
        } else if (value instanceof Double) {
            return result;
        } else if (value instanceof Float) {
            return (float) result;
        } else if (value instanceof Long) {
            return (long) result;
        }
        return result;
    }

    public void addNumbers(T result) {   //결과 값을 ArrayList에 추가 함
        numbers.add(result);
    }

    public T getNumbers(int count) {  //가져올 수 있는 Getter 메서드
        return numbers.get(count);   //.get(인덱스)로 조회해서 반환
    }

    public ArrayList<T> getAllNumbers() {   //모든 리스트의 결과를 출력
        return numbers;
    }

//    public void setNumbers(int count, int result) {  //수정할 수 있는 Setter 메서드
//        numbers.set(count, result);   //기존에 존재하는 인덱스를 수정
//    }

    public void removeResult() {
        //numbers.remove(numbers.size() - 1);  //가장 최근에 들어온 정보 삭제
        System.out.println("삭제 완료: " + numbers.get(0));
        numbers.remove(0); //가장 먼저 저장된 정보 삭제(0번 인덱스만 삭제) --> 인줄 알았으나 0번 인덱스 삭제하면 1번 인덱스가 0번이 됨
    }
}
