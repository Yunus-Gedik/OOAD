package com.company;

public class red implements state{
    @Override
    public void lighter(light Light) {
        Light.set(this);
    }
    public String toString(){
        return "red";
    }
}
