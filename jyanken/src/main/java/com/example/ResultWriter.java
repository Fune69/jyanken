package com.example;

import java.io.*;

public class ResultWriter {
   public static void writeResult(String result) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./src/main/java/com/example/result.txt", true))) {
            bw.write(result);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("ファイル書き込み中にエラーが発生しました: " + e.getMessage());
        }
    }
}
