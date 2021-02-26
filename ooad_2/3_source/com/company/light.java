package com.company;

public class light extends HiTech{
    private state State = new red();

    private traffic t;

    private int timeout_X = 60;

    /**
     * Consturctor with traffic (subject)
     * @param t
     */
    light(traffic t){
        this.t = t;
    }

    /**
     * Setter for traffic light specie
     * @param State
     */
    public void set(state State){
        this.State = State;
    }

    /**
     * getter for state
     * @return
     */
    public state get(){
        return State;
    }

    /**
     * Performs traffic light changes in order by your declarations in an infinite loop.
     *
     * @throws InterruptedException
     */
    public void loop() throws InterruptedException {
        while(true) {
            System.out.printf("Current status is %s.\n", State);
            if (State.toString().equals("red")) {
                System.out.println("Waiting 15 seconds.");
                //Thread.sleep(15000);
                State = new green();
            }
            else if (State.toString().equals("green")) {
                System.out.printf("Waiting %d seconds\n", timeout_X);
                //Thread.sleep(timeout_X*1000);
                State = new yellow();
            }
            else {
                System.out.println("Waiting 3 seconds.");
                //Thread.sleep(3000);
                State = new red();
            }
        }
    }

    /**
     * notify method of observer design
     */
    @Override
    public void changeDetected() {
        if(t.getFlag()){
            // traffic
            System.out.println("Changing timeout_x to 90 seconds.");
            timeout_X = 90;
        }
        else{
            //chill
            System.out.println("Changing timeout_x to 60 seconds.");
            timeout_X = 60;
        }
    }
}
