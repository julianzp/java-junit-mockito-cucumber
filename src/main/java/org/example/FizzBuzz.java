package org.example;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static final String FIZZ_BUZZ = "FizzBuzz";
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    public List<String> getNumbers() {

        List<String> numbers = new ArrayList<>();

        for (int i = 1; i<=100;i++) {
            numbers.add(getNumber(i));
        }

        return numbers;
    }

    private String getNumber(int i) {

        if( isMultiple(i,3) && isMultiple(i, 5)){
            return FIZZ_BUZZ;
        }
        else if(isMultiple(i,3)){
            return FIZZ;

        } else if (isMultiple(i, 5)) {
            return BUZZ;
        }

        return String.valueOf(i);

    }

    private  boolean isMultiple(int value, int multiple) {
        return value % multiple == 0;
    }
    
}
