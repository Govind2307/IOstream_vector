import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {

        int na = 0, nb = 0, nc = 0;
        double[] a, b, c;
        String[] files = new String[3];
        FileReader fa = null, fb = null;
        PrintWriter fc = null;
        Scanner in = new Scanner(System.in);
        files[0] = in.next();
        files[1] = in.next();
        files[2] = in.next();
        try {
            fa = new FileReader(files[0]);
            fb = new FileReader(files[1]);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        Scanner in1 = new Scanner(fa);
        Scanner in2 = new Scanner(fb);
        try {
            na = in1.nextInt();
            nb = in2.nextInt();
            try {
                if (na != nb) {
                    System.out.println("Both should have equal no. of elements");
                    throw new IOException("Unequal vector lengths found");
                } else {
                    nc = na;
                    a = new double[na];
                    b = new double[nb];
                    c = new double[nc];
                    for (int i = 0; i < a.length; i++) {
                        a[i] = in1.nextDouble();
                        b[i] = in2.nextDouble();
                        c[i] = a[i] + b[i];
                    }
                    try {
                        fc = new PrintWriter(new FileWriter(files[2]));
                        System.out.println(nc);
                        fc.println(nc);
                        for (int i = 0; i < nc; i++) {
                            fc.println(c[i]);
                            System.out.println(c[i]);
                        }
                    } catch (IOException e) {
                        System.out.println("Cannot create file");
                    }
                }
            } catch (IOException e) {
                System.out.println("Cannot create the file.");
            }

        } finally {
            try {
                fa.close();
                fb.close();
                fc.close();
                in.close();
                in1.close();
                in2.close();

            } catch (IOException e) {
                System.out.println("Cannot close the file");
            }
        }
    }

}