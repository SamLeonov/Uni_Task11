package com.company;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.nio.charset.Charset;



public class Main {

    public static void main(String[] args) {
       try{
           String[] text = com.company.ArrayUtils.readLinesFromFile("files/file.txt");
           StringBuilder contents = new StringBuilder();
           for (String s: text) {
                contents.append(s);
           }
           String content = contents.toString();
           ArrayList<String> Qlist = new ArrayList<>();
           String placeHolder = randomString(content);
           content = content.replaceAll("\\.","."+placeHolder);
           content = content.replaceAll("!","!"+placeHolder);
           content = content.replaceAll("\\?","\\?"+placeHolder);
           String[] sentences = content.split(placeHolder);
           for (String s: sentences) {
              if (s.contains("?")) {
                  s=s.trim();
                  Qlist.add(s);
               }
           }
           for (String s: Qlist) {
               System.out.println(s);
           }


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static String randomString(String orig) {
        String result = "ilovevsu";
        while (orig.contains(result)) {
            byte[] array = new byte[5];
            new Random().nextBytes(array);
            result = new String(array, Charset.forName("UTF-8"));
        }
        return result;

    }

}


