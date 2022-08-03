package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int hour;
        int min;
        if (a == 0) {
            a = 24;
        }
        if (b < 45) {
            min = 60 - (45 - b);
            hour = a - 1;
            if(hour == 24){
                hour = 0;
            }
        }else{
            min = b-45;
            hour = a;
            if(hour == 24){
                hour = 0;
            }
        }
        System.out.println(hour + " " + min);
    }
}
