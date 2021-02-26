package com.company;

/**
 * Driver main to illustrate how good my code is.
 */
public class Main {
    public static void main(String[] args){
        Integer[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        spiral s = new spiral(arr);

        for (Integer x:s) {
            System.out.println(x);
        }

    }
}
