package step3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

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
                result = value1.doubleValue() / value2.doubleValue();
                break;

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

    public void removeResult() {
        //numbers.remove(numbers.size() - 1);  //가장 최근에 들어온 정보 삭제
        System.out.println("삭제 완료: " + numbers.get(0));
        numbers.remove(0); //가장 먼저 저장된 정보 삭제(0번 인덱스만 삭제) --> 인줄 알았으나 0번 인덱스 삭제하면 1번 인덱스가 0번이 됨
    }

    //람다 스트림 활용
    public List<T> BiggerResult(double baseValue) {   //리스트 전체 리턴
        try {
            return numbers.stream()
                    .filter(n -> n.doubleValue() > baseValue)       //filter로 기준값보다 더 큰 값들만 필터링
                    .collect(Collectors.toList());
        }catch (InputMismatchException e) {   //리스트에 값이 아예 없을 때 빈 리스트 출력
            return  numbers;
        }
    }

}
