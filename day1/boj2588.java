package day1;

import java.io.*;

public class boj2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        String b = br.readLine();
        int result;

        for(int i=b.length()-1; i>=0; i--){
            char tempB = b.charAt(i);
            int numB = Integer.parseInt(String.valueOf(tempB));
            result = a * numB;
            bw.write(result+"\n");
        }
        bw.write(a*Integer.parseInt(b)+"\n");
        bw.flush();
    }
}