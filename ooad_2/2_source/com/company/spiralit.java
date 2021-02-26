package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class spiralit<T> implements Iterator<T>{
    ArrayList<T> arr = new ArrayList<>();

    int index = 0;

    int x = 0;
    int y = 0;

    int height,width;

    /**
     * Takes array as argument and place its' datas in spiral order in arr.
     * After arr is going to use by iteration.
     * Order in spiral by enclosing outer squares.
     * @param array
     */
    public spiralit(T[][] array){
        height = array.length;
        width = array[0].length;

        int start_x = 0;
        int start_y = 0;
        int end_x = width-1;
        int end_y = height-1;

        while(end_x > start_x && end_y > start_y){
            int tstart_x = start_x;
            int tstart_y = start_y;
            int tend_x = end_x;
            int tend_y = end_y;

            while(tstart_y <= tend_y){
                arr.add(array[tstart_x][tstart_y]);
                ++tstart_y;
            }

            ++tstart_x;
            while(tstart_x <= tend_x){
                arr.add(array[tstart_x][tend_y]);
                ++tstart_x;
            }

            --tend_y;
            tstart_y = start_y;
            while(tend_y >= tstart_y){
                arr.add(array[tend_x][tend_y]);
                --tend_y;
            }

            --tend_x;
            tstart_x = start_x + 1;
            while(tend_x >= tstart_x){
                arr.add(array[tend_x][tstart_y]);
                --tend_x;
            }

            ++start_x;
            ++start_y;
            --end_x;
            --end_y;
        }
    }

    /**
     * Classic hasnext
     * @return
     */
    @Override
    public boolean hasNext() {
        return index < width * height;
    }

    /**
     * Returns next element in spiral order.
     * @return
     */
    @Override
    public T next() {
        ++index;
        return arr.get(index-1);
    }
}
