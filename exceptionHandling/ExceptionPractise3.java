package exceptionHandling;

import java.util.Scanner;
import java.io.*;

public class ExceptionPractise3 {
    public static void main(String[] args) {
        //try-with-resource
        try (Scanner input = new Scanner(System.in)) {
            String str = input.nextLine();
            System.out.println(str);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int getPlayerScore(String playerFile) {
        /*
        try (Scanner contents = new Scanner(new File(playerFile))) {
            return Integer.parseInt(contents.nextLine());
        } catch (IOException e) {
            System.out.println("Player file wouldn't load! " + e);
            return 0;
        } catch (NumberFormatException e) {
            System.out.println("Player file was corrupted! " + e);
            return 0;
        } catch (Exception e) {
            System.out.println("An Exception occurred! " + e);
            return 0;
        } finally {
            System.out.println("finally executed!");
        }
        */

        //union catch block
        try (Scanner contents = new Scanner(new File(playerFile))) {
            return Integer.parseInt(contents.nextLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Player file wouldn't load! " + e);
            return 0;
        } catch (Exception e) {
            System.out.println("An Exception occurred! " + e);
            return 0;
        } finally {
            System.out.println("finally executed!");
        }
    }

    static String readFirstLineFromFile(String path) throws IOException {
        try (FileReader fr = new FileReader(path);
             BufferedReader br = new BufferedReader(fr)) {
            return br.readLine();
        }
    }
}

