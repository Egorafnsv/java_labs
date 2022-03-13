package lab2;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Matrix {
    private int m;
    private int n;
    private float[][] matrixVal;


    public Matrix(String path) {
        // конструктор через файл и рандом

        try{
            setMN(path);
            matrixVal = new float[m][n];
            setValMatrix();
        }
        catch (TooBigN | OutOfMemoryError | InputMismatchException | IOException e){
            System.out.println(e);
            //e.printStackTrace();
            System.exit(1);
        }
    }

    public Matrix(int m, int n, float[][] matrix) {
        // конструктор "вручную"

        this.m = m;
        this.n = n;
        matrixVal = new float[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(matrix[i], 0, matrixVal[i], 0, n);
        }
    }

    private void setMN(String path) throws IOException, TooBigN {
        // Чтение m n из файла

        File inFile = new File(path);

        if (!inFile.exists())
            throw new FileNotFound(path);

        try (FileReader fileIn = new FileReader(path)) {
            Scanner scan = new Scanner(fileIn);
            m = scan.nextInt();
            n = scan.nextInt();
        }

        if (m > 1000000 | n > 1000000)
            throw new TooBigN(m, n);
        else if(m <=0 | n <= 0){
            throw new InputMismatchException();
        }
    }

    private void setValMatrix() {
        // рандом заполнение

        Random random = new Random();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrixVal[i][j] = -n + random.nextInt(2 * n + 1);
            }
        }
    }


    public Matrix rotate90(){
        // поворот матрицы на 90

        float[][] matrixTmp = new float[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrixTmp[i][j] = matrixVal[j][n-i-1];
                //System.out.print(matrixTmp[i][j] + " ");
            }
        }
        return new Matrix(n, m, matrixTmp);
    }

    public Matrix divElements(){
        // деление элемента на соседей

        float[][] matrixTmp = new float[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                try{
                    matrixTmp[i][j] = matrixVal[i][j] / sumNeighbors(i, j);
                }
                catch (DivByZero e){
                    e.printStackTrace();
                    matrixTmp[i][j] = matrixVal[i][j];
                }
            }
        }
//        matrixVal = matrixTmp;
//        for (int i = 0; i < n; i++) {
//            if (m >= 0) System.arraycopy(matrixTmp[i], 0, matrixVal[i], 0, m);
//        }
        return new Matrix(m, n, matrixTmp);
    }

    private float sumNeighbors(int i, int j){
        // сумма соседей для деления

        float sum = 0;

        for (int k = i - 1; k <= i + 1; k++) {
            for (int t = j - 1; t <= j + 1; t++) {
                if(k < 0 | t < 0 | k > m - 1 | t > n - 1 | (k == i & t == j))
                    continue;
                sum += matrixVal[k][t];
            }
        }
        if (sum == 0)
            throw new DivByZero(i, j);

        return sum;
    }

    public void printMtx() {
        // вывод матрицы в консоль

        for (int i = 0; i < m; i++) {
            System.out.print("\n");
            for (int j = 0; j < n; j++) {
                System.out.print(matrixVal[i][j] + " ");
            }
        }
        System.out.println("");
    }

    public void outputMatrix(String path, String nameMatrix){
        // вывод матрицы в файл

        try(FileWriter writer = new FileWriter(path, true))
        {
            writer.write(nameMatrix);
            for (int i = 0; i < m; i++) {
                writer.write("\n");
                for (int j = 0; j < n; j++) {
                    writer.write(matrixVal[i][j] + " ");
                }
            }
            writer.write("\n\n");
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}

//    public void rotateReWrite(){
//        float[][] matrixTmp = new float[n][m];
//        //System.out.print("\n");
//        for (int i = 0; i < n; i++) {
//            //System.out.print("\n");
//            for (int j = 0; j < m; j++) {
//                //System.out.println(i + " " + j);
//                matrixTmp[i][j] = matrixVal[j][n-i-1];
//                //System.out.print(matrixTmp[i][j] + " ");
//            }
//        }
//        int tmp = n;
//        n = m;
//        m = tmp;
//        matrixVal = matrixTmp;
//    }