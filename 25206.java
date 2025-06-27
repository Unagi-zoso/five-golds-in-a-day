import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Float> table = Map.of(
            "A+", 4.5f, 
            "A0", 4.0f, 
            "B+", 3.5f, 
            "B0", 3.0f, 
            "C+", 2.5f, 
            "C0", 2.0f, 
            "D+", 1.5f, 
            "D0", 1.0f,
            "F", 0.0f);
        float sumOfGradeMultiplyAVG = 0;
        float sumOfGrades = 0;
        for (int i = 0; i < 20; i++) {
            String[] input = br.readLine().split(" ");
            float grade = Float.parseFloat(input[1]);
            String clazz = input[2];
            if (clazz.equals("P")) {
                continue;
            }
            sumOfGrades += grade;
            sumOfGradeMultiplyAVG += grade * table.get(clazz);
        }
        float result = sumOfGradeMultiplyAVG / sumOfGrades;
        bw.write(String.format("%6f", result));
        bw.flush();
        bw.close();
        br.close();
    }
}