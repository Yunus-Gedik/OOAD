package com.company;

import java.util.Iterator;

public class spiral implements Iterable<Integer> {

    private Integer[][] arr;

    /**
     * Empty constructor
     */
    public spiral(){
        // Nothing
    }

    /**
     * Constructor that takes an array as argument
     * @param arr
     */
    public spiral(Integer[][] arr){
        this.arr = arr;
    }

    /**
     * Fill classes' array with arr
     * @param arr
     */
    public void transmit(Integer[][] arr){
        this.arr = arr;
    }

    /**
     * Here I assign custom iterator
     * @return
     */
    @Override
    public Iterator<Integer> iterator() {
        return new spiralit<Integer>(arr);
    }
}
