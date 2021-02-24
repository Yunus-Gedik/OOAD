package com.company;

import javax.net.ssl.SSLServerSocket;
import java.io.Serializable;
import java.util.Random;

/**
 * Represents a person. Includes a mediator.
 */
public class individual implements movement, Serializable {
    protected mediator media;
    protected String direction;     // left, right, up, down
    protected int S;                // Speed, constant [1-500]
    protected int C;                // [1-5]
    protected int D;                // social distance [1-9]
    protected int x,y;              // my position on canvas.
    protected boolean M;            // 0,2 or 1
    protected int timeLeft;         // 100 * (1-Z)
    protected int hospitalTime;     // time left at hospital
    protected boolean hospital;     // I am in hospital
    protected int interactionTime;  // time passed at interaction
    protected boolean interaction;  // true =  I am in interaction
    protected individual mate;      // Interacted mate
    protected boolean yield;        // true = I am done in this turn.
    protected boolean infected;     // true = infected
    protected int infectedTime;     // >=25 go hospital
    protected boolean justTalked;   // true = I just talked to someone
    protected boolean dead;         // true = person is dead

    individual(mediator media){
        this.media = media;
        Random r = new Random();
        direction = mediator.ways[r.nextInt(mediator.ways.length)];
        S =  r.nextInt(500 - 1)+1;
        C = r.nextInt(5 - 1) + 1;
        D = r.nextInt(9 - 1) + 1;
        x = r.nextInt(995);
        y = r.nextInt(595);
        M = r.nextBoolean();
        timeLeft = 0;
        hospitalTime = 0;
        hospital = false;
        interactionTime = 0;
        interaction = false;
        mate = null;
        yield = false;
        infected = false;
        justTalked = false;
        dead = false;
        infectedTime = 0;
    }

    /**
     * notify method of mediator pattern and also method of composite pattern
     */
    @Override
    public void move() {
        media.move();
    }
}



