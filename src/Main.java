
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.tools.ShellFunctions.input;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dell
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String fileInput = "input.txt";
        Controler c = new Controler();
        String txt = null;

        try {
            txt = c.loadFile(fileInput);

        } catch (IOException ex) {
            System.out.println("File not exits");
            File f = new File("input.txt");
            f.createNewFile();
            c.saveFile(fileInput, sc.nextLine());
            txt = c.loadFile(fileInput);
        }
        if (txt == null) {
            return;
        }
        
        System.out.println("The document before normalizing:\n" + txt.trim());
        System.out.println((String.valueOf(txt.charAt(0)).codePointAt(0)));
        System.out.println("The document after normalizing:\n");
        String b = "";
        b = c.normalize(txt);
        System.out.println(b);

        c.saveFile("output.txt", b);

//        System.out.println("");
//        
//        String test = "         con ba may \"   met vcl ,   holy shit   \"   123.";
//        System.out.println((String.valueOf(test.charAt(0)).codePointAt(0)));
//        String test2 = c.normalize(test);
//        System.out.println(test2);
    }

}
