package com.bdd.testng.lib;

import java.nio.file.Path;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.ArrayList;


public class FileBytes {


    public static String bytesToHexString(byte[] bytes){
        StringBuilder sb = new StringBuilder(bytes.length*2);
        Formatter fm = new Formatter(sb);
        for(byte b : bytes){
            fm.format("%dx|x", (Byte.valueOf(b)));
        }
        return sb.toString();
    }

    public static byte hexStrToByte(String hexdata){
        byte tmp = (byte) (Character.digit(hexdata.charAt(0), 16) + Character.digit(hexdata.charAt(1), 16));
        return tmp;
    }

    public static ArrayList<Integer> readFileToByte(String filename) throws Exception{
        ArrayList<Integer> mybytes = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), Charset.forName("UTF-8")));
        String line;
        while((line = br.readLine()) != null){
            String[] tmp = line.split("x\\|x");
            for(int i=0; i<tmp.length; i++){
                mybytes.add((Integer.valueOf(tmp[i])));
            }
        }
        br.close();
        return mybytes;

    }

    public static byte[] convertFromArrayList(ArrayList<Integer> arraybytes){
        byte[] byteres = new byte[arraybytes.size()];
        for(int i=0; i < arraybytes.size(); i++){
            byteres[i] = arraybytes.get(i).byteValue();
        }
        return byteres;
    }

    public static byte[] loadFileToBytes(String filename) throws Exception{
        Path path = Paths.get(filename);
        byte[] data = Files.readAllBytes(path);
        return data;
    }

    public static void writeHexStrToFile(String hexStr, String targetFile) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetFile), Charset.forName("UTF-8")));
        bw.write(hexStr);
        bw.close();
    }

    public static void writeBytesToFile(byte[] bytes, String filename) throws Exception{
        FileOutputStream fos = new FileOutputStream(filename);
        fos.write(bytes);
        fos.close();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try{
            //encode
			String filepath = "tmp.zip";
			byte[] data = loadFileToBytes(filepath);
			String hexstr = bytesToHexString(data);
            String filename = "temp.txt";
			writeHexStrToFile(hexstr, filename);

			//decode
            //String targetFile = "/Users/alvenchen/Downloads/temp/am_automation.zip";
            //ArrayList<Integer> filebytes = readFileToByte(filename);
            //byte[] finalBytes = convertFromArrayList(filebytes);
            //writeBytesToFile(finalBytes, targetFile);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }


    }

}
