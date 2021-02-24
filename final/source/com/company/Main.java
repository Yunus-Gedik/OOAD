package com.company;


import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Driver class uses Java FX.
 */
public class Main extends Application{

    /**
     * Driver program
     * @param args only 1 parameter, number of persons in population
     */
    public static void main(String[] args){
        launch(args);
    }

    /**
     * Javafx start program. Updates every 1 second.
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        ArrayList<ImageView> images = new ArrayList<ImageView>();

        String parameters = getParameters().getUnnamed().toString();

        parameters = parameters.substring(1,parameters.length()-1);
        mediator m = new mediator();
        composite co = new composite(Integer.parseInt(parameters),m);


        Random r = new Random();

        disease.Z = (r.nextInt(8)/10.0) + 0.1;
        disease.R = (r.nextInt(5)/10.0) + 0.5;

        composite.people.get(7).infected = true;
        composite.people.get(7).timeLeft = (int)(100 * (1 - disease.Z));

        Image clean = new Image(new FileInputStream("clean.png"));
        Image infected = new Image(new FileInputStream("infected.png"));
        Image background = new Image(new FileInputStream("arka.png"));

        // Black background
        ImageView backView = new ImageView(background);
        backView.setX(0);
        backView.setY(0);
        backView.setPreserveRatio(true);
        images.add(backView);


        for(individual i : composite.people){
            ImageView v;
            if(i.hospital) {
                continue;
            }
            else if(i.infected){
                v = new ImageView(infected);
            }
            else{
                v = new ImageView(clean);
            }
            v.setX(i.x);
            v.setY(i.y);
            v.setPreserveRatio(true);

            images.add(v);
        }


        //Creating a Group object
        Group root = new Group();
        for(ImageView i : images){
            root.getChildren().add(i);
        }

        //Creating a scene object
        Scene scene = new Scene(root, 1000, 600);

        //Setting title to the Stage
        stage.setTitle("Corona");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();

        Timer myTimer = new Timer();
        myTimer.scheduleAtFixedRate(new TimerTask(){

            @Override
            public void run() {

                co.move();
                m.prepareNextMoves();


                for(int i=0;i< composite.people.size(); ++i){

                    //root.getChildren().clear();
                    //root.getChildren().add(backView);
                    if(composite.people.get(i).dead){
                        images.remove(i+1);
                        composite.people.remove(i);
                        continue;
                    }

                    if(composite.people.get(i).infected){
                        images.get(i+1).setImage(infected);
                    }
                    else if(!composite.people.get(i).infected){
                        images.get(i+1).setImage(clean);
                    }

                    if(composite.people.get(i).hospital){
                        images.get(i+1).setVisible(false);
                    }

                    else{
                        images.get(i+1).setVisible(true);
                    }

                    images.get(i+1).setX(composite.people.get(i).x);
                    images.get(i+1).setY(composite.people.get(i).y);

                }
            }

        }, 3000, 1000);












    }
}