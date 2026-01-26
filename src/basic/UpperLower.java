package basic;

import java.util.Scanner;

public class UpperLower {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String str = "";

        for(int i =0; i <= a.length()-1; i++){
            char c = a.charAt(i);
            if(Character.isUpperCase(c)){
                str += Character.toLowerCase(c);
            }else if (Character.isLowerCase(c)){
                str += Character.toUpperCase(c);
            }else{
                str += c;
            }
        }
        System.out.println(str);
    }
}
