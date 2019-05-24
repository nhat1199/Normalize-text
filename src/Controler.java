
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dell
 */
public class Controler {
/**
 *  Get content from file
 * @param fileName
 * @return
 * @throws FileNotFoundException
 * @throws IOException 
 */
    String loadFile(String fileName) throws FileNotFoundException, IOException {

        RandomAccessFile f = new RandomAccessFile(fileName, "r");
        String content = "";
        String s;

        while ((s = f.readLine()) != null) {
            content += s;
        }
        f.close();
        return content;
    }

    /**
     * save content to file
     * @param fileName
     * @param content
     * @throws IOException 
     */
    void saveFile(String fileName, String content) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

        try {
            bw.write(content);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Writing success...");
    }

    /**
     *
     * @param content
     * @return content has been normalized
     */
    String normalize(String content) {
        //
        /**
         * -	Only one space between words
         * -	Only one space after comma (,), dot
         * (.) and colon (:). First character of word after dot is in Uppercase
         * and other words are in lower case. 
         * -	There are no spaces before and
         * after sentence or word phrases in quotes (“”).
         * -	First character of
         * word in first line is in Uppercase. 
         * -	There are no blank line between
         * lines
         * -	There are no space between comma or dot and word in front of
         * it.
         * -	Must have dot at the end of text.
         *
         */
        String noidung = content.toLowerCase().replaceAll("[ ]+", " ").replaceAll(" :", ":").replaceAll(":", ": ")
                .replaceAll(" ,", ", ").replaceAll(",", ", ").replaceAll(" \"", "\"").replaceAll("\" ", "\"").replaceAll("[ ]+", " ").trim();

        //to upper case the first character
        noidung = String.valueOf(noidung.charAt(0)).toUpperCase() + noidung.substring(1);

        String[] st = noidung.split("\\.");

        String e = "";
        
        for (int i = 0; i < st.length; i++) {
            st[i] = st[i].trim();
            e = e + String.valueOf(st[i].charAt(0)).toUpperCase() + st[i].substring(1) + ". ";
        }

        return e;
    }

}
