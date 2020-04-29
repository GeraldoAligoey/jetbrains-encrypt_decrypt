package encryptdecrypt;

import Algorithm.Shifter;
import Algorithm.Unicoder;
import Algorithm.common.IEncryptDecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String alg = "shift";
        String mode = "enc";
        String data = "";
        String inFile = "";
        String outFile = "";
        int index = 0;

        IEncryptDecrypt encryptDecrypt = null;

        List<String> argList = Arrays.asList(args);

        if (argList.contains("-mode")) {
            mode = argList.get(argList.indexOf("-mode") + 1);
        }

        if (argList.contains("-key")) {
            index = Integer.parseInt(argList.get(argList.indexOf("-key") + 1));
        }

        if (argList.contains("-alg")) {
            alg = argList.get(argList.indexOf("-alg") + 1);

            if (alg.equals("shift")) {
                encryptDecrypt = new Shifter();
            }

            if (alg.equals("unicode")) {
                encryptDecrypt = new Unicoder();
            }
        } else {
            encryptDecrypt = new Shifter();
        }

        if (argList.contains("-in")) {
            inFile = (argList.get(argList.indexOf("-in") + 1));
            data = getDataFromFile(inFile);
        } else if (argList.contains("-data")) {
            data = (argList.get(argList.indexOf("-data") + 1));
        }

        if (argList.contains("-out")) {
            outFile = (argList.get(argList.indexOf("-out") + 1));
        }

        if (mode.equals("enc")) {
            String encrypted_data = encryptDecrypt.encrypt(data, index);
            if (outFile.isEmpty()) {
                System.out.println(encrypted_data);
            } else {
                writeToFile(outFile, encrypted_data);
            }
        } else {
            String decrypted_data = encryptDecrypt.decrypt(data , index);
            if (outFile.isEmpty()) {
                System.out.println(decrypted_data);
            } else {
                writeToFile(outFile, decrypted_data);
            }
        }
    }

    private static void writeToFile(String outFile, String data) {
        try {
            FileWriter myWriter = new FileWriter(outFile);
            myWriter.write(data);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static String getDataFromFile(String inFile) {
        String data = "";

        try {
            File file = new File(inFile);
            Scanner sc = new Scanner(file);

            while(sc.hasNextLine()) {
                data += sc.nextLine();
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error! File not found.");
            e.printStackTrace();
        }

        return data;
    }
}
