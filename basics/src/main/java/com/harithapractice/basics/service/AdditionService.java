package com.harithapractice.basics.service;

import com.harithapractice.basics.model.Addition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class AdditionService {
    private List<String> problems= new ArrayList<>();
    private List<String> solutions= new ArrayList<>();
    Integer number=0;
    public String generateProblemNumbers(int numberOfDigits, int numberOfRows) {
        Random rand = new Random();
        int upperbound = 0;

        StringBuffer problem = new StringBuffer();
        StringBuffer solution = new StringBuffer();
        Integer total=0;
        for (int i = 0; i < numberOfRows; i++) {
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
            total=total+number;
            problem.append(number.toString());
            problem.append("+");
        }
        solution.append(total.toString());
        solutions.add(String.valueOf(solution));
        return String.valueOf(problem);

    }

    public List<String> generateProblems(Addition addition) {
        for(int i=0;i<addition.getNumberOfProblems(); i++){
            String s=generateProblemNumbers(addition.getNumberOfDigits(),addition.getNumberOfRows());
            problems.add((s.substring(0, s.length() - 1))+"=");
        }
        System.out.println(problems);
        return problems;
    }

    public Collection<String> generateSolutions() {
        System.out.println(solutions);
        return solutions;
    }
}
