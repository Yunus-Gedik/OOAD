package com.company;

import java.util.ArrayList;

public class traffic {

    private ArrayList<HiTech> ahali = new ArrayList<HiTech>();
    private boolean flag;

    /**
     * getter for flag
     * @return
     */
    public boolean getFlag() {
        return flag;
    }

    /**
     * setter for lag
     * @param flag
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
        getup();
    }

    /**
     * adds an subscriber
     * @param ver
     */
    public void attach(HiTech ver){
        ahali.add(ver);
    }

    /**
     * notify all subscribers.
     */
    public void getup(){
        for (HiTech ver : ahali) {
            ver.changeDetected();
        }
    }
}
