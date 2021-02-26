package com.company;

public class yellow implements state{
    @Override
    public void lighter(light Light) {
        Light.set(this);
    }
    public String toString(){
        return "yellow";
    }
}
