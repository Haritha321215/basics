package com.harithapractice.basics.service;

import com.harithapractice.basics.model.Addition;
import com.harithapractice.basics.model.Subtraction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class SubtractionService {

    private List<String> problems= new ArrayList<>();
    private List<String> solutions= new ArrayList<>();
    Integer number=0;
    public String generateProblemNumbers(int numberOfDigits, int numberOfRows) {
        Random rand = new Random();
        int upperbound = 0;

        StringBuffer problem = new StringBuffer();
        StringBuffer solution = new StringBuffer();
        Integer ans=0;
        Integer num1=0;
        Integer num2=0;
        for (int i = 0; i < numberOfRows; i++) {
            if(i==0){
                if (numberOfDigits == 1) {
                    upperbound = 9;
                    number = rand.nextInt(upperbound);
                } else if (numberOfDigits == 2) {
                    upperbound = 90;
                    number = 10+rand.nextInt(upperbound);
                } else if (numberOfDigits == 3) {
                    upperbound = 900;
                    number = 100+rand.nextInt(upperbound);
                } else if (numberOfDigits == 4) {
                    upperbound = 9000;
                    number = 1000+rand.nextInt(upperbound);
                }
                num1=number;
            }
            else{
                if (numberOfDigits == 1) {
                    upperbound = 9;
                    number = rand.nextInt(upperbound);
                    if(num1>number)
                        num2=number;
                    else
                        i=1;
                } else if (numberOfDigits == 2) {
                    upperbound = 90;
                    number = 10+rand.nextInt(upperbound);
                    if(num1>number)
                        num2=number;
                    else
                        i=1;
                } else if (numberOfDigits == 3) {
                    upperbound = 900;
                    number = 100+rand.nextInt(upperbound);
                    if(num1>number)
                        num2=number;
                    else
                        i=1;
                } else if (numberOfDigits == 4) {
                    upperbound = 9000;
                    number = 1000+rand.nextInt(upperbound);
                    if(num1>=number)
                        num2=number;
                    else
                        i=1;
                }

            }

        }
        ans=num1-num2;
        problem.append(num1.toString());
        problem.append("-");
        problem.append(num2.toString());
        solution.append(ans.toString());
        solutions.add(String.valueOf(solution));
        return String.valueOf(problem);

    }

    public List<String> generateProblems(Subtraction subtraction) {
        for(int i=0;i<subtraction.getNumberOfProblems(); i++){
            String s=generateProblemNumbers(subtraction.getNumberOfDigits(),subtraction.getNumberOfRows());
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

