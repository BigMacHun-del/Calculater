package step3;

public enum OperatorType {
    SUM('+'),
    SUB('-'),
    MUL('*'),
    DIV('/');

    //연산자를 저장할 필드
    private char operator;

    //생성자
    OperatorType(char operator) {
        this.operator = operator;
    }

    //Getter
    public char getOperator() {
        return operator;
    }
}
