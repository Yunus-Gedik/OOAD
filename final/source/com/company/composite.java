package com.company;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Used for object creation and usage. Composite class for individuals.
 */
public class composite implements movement {

    /**
     * population
     */
    public static ArrayList<individual> people = new ArrayList<individual>();

    /**
     * Adds a person to population
     * @param emp person to add
     */
    public void addPerson(individual emp){
        people.add(emp);
    }

    /**
     * Removes a person from population.
     * @param emp person to remove
     */
    public void removePerson(individual emp){
        people.remove(emp);
    }

    /**
     * You can read from a file individual objects. (Serializable)
     * @param file  file name
     */
    public void bulk(String file){
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            people = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
        catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    public void save(String file){
        try {
            FileOutputStream out = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(people);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Calls move() method of every individual
     */
    @Override
    public void move() {
        for (individual person : people){
            person.media.person = person;
            person.move();
        }

    }

    /**
     * creates individuals with mediator media object
     * @param people_count number of people in population
     * @param media mediator object
     */
    composite(int people_count, mediator media){
        people.clear();
        for(int i=0; i< people_count; ++i){
            people.add(new individual(media));
        }
    }

    /*
    public static void main(String[] args){

        mediator m = new mediator();
        composite c = new composite(100,m);
        c.save("save");
        composite.people.clear();
        c.bulk("save");

    }
    */

}
