package basic;

import java.util.Scanner;

public class String_print {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String code = sc.next();

        int mode = 0;
        String ret = "";

        for(int idx = 0; idx <= code.length()-1; idx++){
            if(mode == 0){
                if(code.charAt(idx) != 1){
                    if(idx % 2 == 0){
                        ret += code.charAt(idx);
                    }
                }else{
                    mode = 1;
                }
            }else if(mode == 1){
                if(code.charAt(idx) != 1){
                    if(idx % 2 == 1){
                        ret += code.charAt(idx);
                    }
                }else{
                    mode = 0;
                }
            }
        }
        for (int idx = 0; idx <= ret.length()-1; idx++){
            System.out.print(ret.charAt(idx));
        }
    }
}
