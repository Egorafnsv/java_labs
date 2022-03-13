package lab2;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        String pathIn = ".\\resources\\input.txt";
        String pathOut = ".\\resources\\output.txt";
        String nameMatrix;
        File outputFile = new File(pathOut);
        Matrix matrix = new Matrix(pathIn);

        if (outputFile.delete())
            System.out.println("delete output.txt - ok");

        matrix.printMtx();

        for (int i = 0; i < 3; i++) {
            matrix = matrix.rotate90();
            matrix = matrix.divElements();
            matrix.printMtx();
            nameMatrix = "name: " + (90 * (i + 1));
            matrix.outputMatrix(pathOut, nameMatrix);
        }
    }

}
