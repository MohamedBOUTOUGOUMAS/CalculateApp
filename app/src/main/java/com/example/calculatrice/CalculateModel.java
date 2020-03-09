package com.example.calculatrice;

public class CalculateModel {
    private String firstValue = "";
    private String secondValue = "";
    private char operator = ' ';

    public String getFirstValue() {
        return firstValue;
    }

    public char getOperator() {
        return operator;
    }

    public String getSecondValue() {
        return secondValue;
    }

    public void setFirstValue(String firstValue) {
        this.firstValue = firstValue;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public void setSecondValue(String secondValue) {
        this.secondValue = secondValue;
    }

    public void addFirstValueNumber(String number) {
        this.firstValue += number;
    }

    public void addSecondValueNumber(String number){ this.secondValue += number; }

    public double calculate(){
        double x = Double.parseDouble(firstValue);
        double y = Double.parseDouble(secondValue);
        switch (operator){
            case '+':
                return x+y;
            case '-':
                return x-y;
            case '*':
                return x*y;
            case '/':
                return x/y;
            default:
                return 0.0;
        }
    }

    public void clear(){
        this.firstValue = "";
        this.secondValue = "";
        this.operator = ' ';
    }
}
