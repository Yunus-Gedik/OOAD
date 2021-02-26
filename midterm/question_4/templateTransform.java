import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class templateTransform {
    protected static String filename;
    protected ArrayList<Double> in =new ArrayList<Double>();
    protected ArrayList<complex> out = new ArrayList<complex>();
    protected boolean time;

    /**
     * Takes a filename to read numbers
     * @param f filename
     */
    templateTransform(String f){
        filename = f;
    }

    /**
     *  Constuctor with time choice
     * @param f filename
     * @param time boolean to user to choose betwwen show time or not
     */
    templateTransform(String f,boolean time){
        filename = f;
        this.time = time;
    }

    abstract void transform();
    /**
     * Writes back transformations to "newfile.txt"
     */
    private void write_back() {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("newfile.txt"));
        }
        catch (IOException e){
            System.out.println("Cannot create a newfile to write results back!");
            System.exit(-1);
        }


        for(complex d : out){
            try {
                writer.write(d.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                writer.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Reads numbers from given file.
     */
    private void read() {
        Scanner src = null;
        File file = null;
        try {
            file = new File(filename);
            src = new Scanner(file);
        }
        catch (FileNotFoundException f){
            System.out.println("File not found!");
            System.exit(-1);
        }

        while(src.hasNextDouble() ){
            in.add(src.nextDouble());
        }
        src.close();
    }

    /**
     * Performs given procedure.
     */
    void procedure(){
        read();
        transform();
        write_back();
    }

}
