package basic;

import java.util.Random;

public class Dice {

    public static void main(String[] args) {

        Random random = new Random();

//        int dice1 = random.nextInt(6)+1;
//        int dice2 = random.nextInt(6)+1;
//        int dice3 = random.nextInt(6)+1;
//        int dice4 = random.nextInt(6)+1;

        int dice1 = 4;
        int dice2 = 5;
        int dice3 = 3;
        int dice4 = 6;
        int[] diceAll = {dice1, dice2, dice3, dice4};
        int[] diceCount = { 0, 0, 0, 0, 0, 0 };

        for(int i = 0; i <= diceAll.length-1; i++){
            int value = diceAll[i];

            diceCount[value -1]++;
        }

        int answer = 0;
        int flag = 1;
        //추후에 주사위 개수에 따른 점수 설계, diceCount 로직 설계
        for(int i = 0; i <= diceCount.length-1; i++){
            int sum1 = 0;
            int sum2 = 0;
            if(diceCount[i] == 4){ // 4개 전부 일치
                System.out.println("4개 일치");
                answer = 1111 * (i+1); //점수로직
                break;
            }else if(diceCount[i] == 3){ // 3개 일치, -> 1개 인 값을 찾아야함
                System.out.println("3개 일치");
                sum1 = i+1;
                for(int j =0; j <= diceCount.length-1; j++){
                    if(diceCount[j] == 1){
                        sum2 = j+1;
                    }
                }
                answer = (int)Math.pow((10 * sum1 + sum2), 2); //점수로직
                break;
            }else if(diceCount[i] == 2){ //적어도 한 쌍은 일치함 -> 1개 더 일치하는 것이 있는지 확인
                System.out.println("2개 일치");
                sum1 = i+1;
                for(int j =0; j <= diceCount.length-1; j++){ //2번째 2값 찾기
                    if(sum1 == j+1){
                        System.out.println("continue 실행");
                        continue;
                    }
                    if(diceCount[j] == 2){
                        System.out.println("2개, 2개 일치");
                        sum2 = j+1;
                        answer = (sum1+sum2) * Math.abs((sum1-sum2)); //점수로직
                    } else if(diceCount[j] == 1){
                        System.out.println("2개, 1개, 1개 일치");
                        flag *= (j+1);
                        answer = flag;
                    }
                }
                break;
            }else if (diceCount[i] == 0){
                continue;
            } else{ //전부 일치하지 않음
                System.out.println("0개 일치");
                for(int j = 0; j <= diceCount.length-1; j++){
                    if(diceCount[j] == 1){
                        answer = j+1;
                        break;
                    }
                }
            }
        }
        System.out.println("a b c d");
        System.out.printf("%d %d %d %d\n", dice1, dice2, dice3, dice4);
        System.out.printf("점수: %d", answer );
    }

}
