package com.harithapractice.basics.service;

import com.harithapractice.basics.model.Multiplication;
import com.harithapractice.basics.model.Subtraction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class MultiplicationService {
    private List<String> problems= new ArrayList<>();
    private List<String> solutions= new ArrayList<>();
    public String generateProblemNumbers(int number1Digits, int number2Digits) {
        Random rand = new Random();
        int upperbound = 0;
        StringBuffer problem = new StringBuffer();
        StringBuffer solution = new StringBuffer();
        Integer ans=0;
        Integer num1=0;
        Integer num2=0;
            if (number1Digits == 1) {
                    upperbound = 9;
                    num1 = rand.nextInt(upperbound);
            } else if (number1Digits == 2) {
                    upperbound = 90;
                    num1 = 10+rand.nextInt(upperbound);
            } else if (number1Digits == 3) {
                    upperbound = 900;
                    num1 = 100+rand.nextInt(upperbound);
            } else if (number1Digits == 4) {
                    upperbound = 9000;
                    num1 = 1000+rand.nextInt(upperbound);
            }

            if (number2Digits == 1) {
                    upperbound = 9;
                    num2 = rand.nextInt(upperbound);
            } else if (number2Digits == 2) {
                    upperbound = 90;
                    num2 = 10+rand.nextInt(upperbound);
            } else if (number2Digits == 3) {
                    upperbound = 900;
                    num2 = 100+rand.nextInt(upperbound);
            } else if (number2Digits == 4) {
                    upperbound = 9000;
                    num2 = 1000+rand.nextInt(upperbound);
            }

        ans=num1*num2;
        problem.append(num1.toString());
        problem.append("X");
        problem.append(num2.toString());
        solution.append(ans.toString());
        solutions.add(String.valueOf(solution));
        return String.valueOf(problem);

    }

    public List<String> generateProblems(Multiplication multiplication) {
        for(int i=0;i<multiplication.getNumberOfProblems(); i++){
            String s=generateProblemNumbers(multiplication.getNumber1NoOfDigits(),multiplication.getNumber2NoOfDigits());
            problems.add(s+"=");
        }
        System.out.println(problems);
        return problems;
    }

    public Collection<String> generateSolutions() {
        System.out.println(solutions);
        return solutions;
    }
}
