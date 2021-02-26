package com.company;

public class green implements state{
    @Override
    public void lighter(light Light) {
        Light.set(this);
    }
    public String toString(){
        return "green";
    }
}
