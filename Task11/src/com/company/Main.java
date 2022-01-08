package com.company;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


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
           content = content.replaceAll("\\.",".]");
           content = content.replaceAll("!","!]");
           content = content.replaceAll("\\?","\\?]");
           String[] sentences = content.split("]");
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

}
