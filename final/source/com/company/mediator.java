package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Mediator pattern class, works as an admin for software.
 */
public class mediator implements movement, Serializable {
    private ArrayList<individual> people;
    protected static final String[] ways = {"left","right","up","down"};
    private ArrayList<individual> hospital = new ArrayList<individual>();
    private final int hospitalSize;
    private boolean available = true;
    protected individual person = null;

    /**
     * Calculates hospital size and fill population "people"
     */
    mediator(){
        this.people = composite.people;
        hospitalSize = (int)Math.ceil(people.size()/10.0);
        //this.people.addAll(composite.people);
    }


    /**
     * Mediator notify method. Method does either one of these:
     * - walks a person
     * - kills a person
     * - interacts someone with person
     * - checks the time passed in hospital for person
     * - checks the time passed in interaction
     * - checks how much time before death for a person
     * - takes person to hospital if available
     */
    public void move(){

        if(person.yield || person.dead){
            return;
        }

        if(person.infected){
            person.infectedTime += 1;
        }

        if(person.infected && !person.hospital && person.infectedTime >= 25){
            // Hastaneye bak yer var mı diye
            // yer yoksa iletişim
            // iletişim yoksa yürüt
            person.timeLeft -= 1;
            if(person.timeLeft == 0){
                if(person.mate != null) {
                    person.mate.mate = null;
                    person.mate.interaction = false;
                    person.mate.interactionTime = 0;
                    person.mate.justTalked = true;
                }
                person.dead = true;
                return;
            }
            else{
                if(available){
                    if(person.mate != null) {
                        person.mate.mate = null;
                        person.mate.interaction = false;
                        person.mate.interactionTime = 0;
                        person.mate.justTalked = true;
                    }
                    person.timeLeft = 0;
                    person.hospital = true;
                    person.hospitalTime = 10;
                    hospital.add(person);
                    if(hospital.size() == hospitalSize){
                        available = false;
                    }
                    person.yield = true;
                    return;
                }
                else if(person.justTalked){
                    person.justTalked = false;
                    walk(person);
                    person.yield = true;
                    return;
                }
                else {
                    individual interact;
                    if ((interact = sides(person)) != null) {
                        person.interaction = true;
                        person.interactionTime = Math.max(person.C, interact.C);
                        person.mate = interact;
                        person.yield = true;

                        interact.interaction = true;
                        interact.interactionTime = Math.max(person.C, interact.C);
                        interact.mate = person;
                        interact.yield = true;
                        return;
                    }
                    walk(person);
                    person.yield = true;
                    return;
                }
            }

        }

        else if(!person.interaction && !person.hospital){
            // iletişim
            // yoksa yürüt
            if(person.justTalked){
                person.justTalked = false;
                walk(person);
            }

            else {
                individual interact;
                if ((interact = sides(person)) != null) {
                    person.interaction = true;
                    person.interactionTime = Math.max(person.C, interact.C);
                    person.mate = interact;
                    person.yield = true;

                    interact.interaction = true;
                    interact.interactionTime = Math.max(person.C, interact.C);
                    interact.mate = person;
                    interact.yield = true;
                    return;
                }
                walk(person);
                person.yield = true;
                return;
            }


        }

        else if(person.hospital){
            person.hospitalTime -= 1;
            if(person.hospitalTime == 0){
                Random r = new Random();
                person.x = r.nextInt(995);
                person.y = r.nextInt(595);
                person.hospital = false;
                person.infected = false;
                person.timeLeft = 0;
                person.infectedTime = 0;
                hospital.remove(person);
                available = true;
            }
            person.yield = true;
            return;
        }

        else if(person.interaction){
            person.interactionTime -= 1;
            person.mate.interactionTime -= 1;

            if(person.interactionTime == 0){
                person.interaction = false;
                person.justTalked = true;
                person.mate.interaction = false;
                person.mate.justTalked = true;
                if(  person.infected && !person.mate.infected ){
                    Random r = new Random();
                    int prob = p(person);
                    int temp = r.nextInt(1000000);
                    if(prob >= temp){
                        person.mate.infected = true;
                        person.mate.infectedTime = 0;
                        person.mate.timeLeft = (int)(100 * (1 - disease.Z));
                        if(available){
                            hospital.add(person);
                            if(hospital.size() == hospitalSize){
                                available = false;
                            }
                        }
                    }
                }

                else if(  !person.infected && person.mate.infected){
                    Random r = new Random();
                    int prob = p(person);
                    int temp = r.nextInt(1000000);
                    if(prob >= temp){
                        person.infected = true;
                        person.timeLeft = (int)(100 * (1 - disease.Z));
                        person.infectedTime = 0;
                        if(available){
                            hospital.add(person);
                            if(hospital.size() == hospitalSize){
                                available = false;
                            }
                        }
                    }
                }

            }
            person.yield = true;
            person.mate.yield = true;
        }


    }

    /**
     * Check if any person suitable and also collide with "person".
     * @param person person to check sides.
     * @return another person that collides with "person" or null.
     */
    private individual sides(individual person){
        for(int i = 0; i < people.size();++i){
            if( Math.abs(person.x - people.get(i).x) <= 5 && Math.abs(person.y - people.get(i).y) <= 5){
                if(people.get(i) != person){
                    if(!people.get(i).hospital && !people.get(i).interaction && !people.get(i).yield) {
                        return people.get(i);
                    }
                }
            }
        }
        return null;
    }

    /**
     * Calculates P described in pdf.
     * @param ind person and his/her mate to calculate p
     * @return p
     */
    private int p(individual ind){
        int d = Math.min(ind.D,ind.mate.D);
        int c = Math.max(ind.C,ind.mate.C);

        double total = disease.R;
               total *= ((double) (1 - d) /10.0);
               total *= ((double) (1 + c) /10.0);
        if(ind.M){
           total *= 0.2;
        }
        if(ind.mate.M){
            total *= 0.2;
        }
        total *= 1000000;
        total = Math.abs(total);
        return Math.min( (int)total,1000000);
    }

    /**
     * Walks a person.
     * @param person    person to walk
     */
    private void walk(individual person){
        switch (person.direction) {
            case "up":
                if (person.x - person.S < 0) {
                    Random r = new Random();
                    person.direction = ways[r.nextInt(ways.length)];
                    walk(person);
                    return;
                }
                else {
                    person.x -= person.S;
                }
                break;
            case "down":
                if (person.x + person.S > 995) {
                    Random r = new Random();
                    person.direction = ways[r.nextInt(ways.length)];
                    walk(person);
                    return;
                }
                else {
                    person.x += person.S;
                }
                break;
            case "left":
                if (person.y + person.S > 595) {
                    Random r = new Random();
                    person.direction = ways[r.nextInt(ways.length)];
                    walk(person);
                    return;
                }
                else {
                    person.y += person.S;
                }
                break;
            case "right":
                if (person.y - person.S < 0) {
                    Random r = new Random();
                    person.direction = ways[r.nextInt(ways.length)];
                    walk(person);
                    return;
                }
                else {
                    person.y -= person.S;
                }
                break;
        }

    }

    /**
     * Removes the sign of person that he/she moved this turn.
     */
    protected void prepareNextMoves(){
        for(individual i : people){
            i.yield = false;
        }
    }

}
