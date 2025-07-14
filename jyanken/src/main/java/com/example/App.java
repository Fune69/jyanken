package com.example;

import java.util.Scanner;
import java.util.Random;;
public class App {
    public static void main( String[] args ){
    Scanner scan=new Scanner(System.in);
    Random rand=new Random();
    
        String[] hand={"グー","チョキ","パー"};
        
        System.out.println("ジャンケンをしましょう");
        int win=0;
        int lose=0;
        
        while(true){
           boolean KeepPlaying=false;
           System.out.println(0+":グー "+1+":チョキ "+2+":パー");
           int num=rand.nextInt(3);
           String input=scan.nextLine();
           int userhand;
           try {
             userhand=Integer.parseInt(input);
           } catch (NumberFormatException e) {
            
            System.out.println("正しく入力してください、少数や文字列は不正です");
            continue;
           }

            if(userhand<0||userhand>2){
                System.out.println("0〜2の数字を入れてください");
                continue;
            }
            System.out.println("あなたの手は"+hand[userhand]+"です");
            System.out.println("コンピュータの手は"+hand[num]+"です");

            String result;

            if(userhand==num){
                result="あいこ";
                System.out.println("あいこです");
                System.out.println("もう一回");
                ResultWriter.writeResult(result);
                continue;
            }else if((userhand==0&&num==1)||(userhand==1&&num==2)||(userhand==2&&num==0)){
                result="あなたの勝ち";
                System.out.println("あなたの勝ちです");
                win++;
            }else{
                result="コンピュータの勝ち";
                System.out.println("コンピュータの勝ちです");
                lose++;
            }

            ResultWriter.writeResult(result);
            System.out.println("もう一度プレイしますか");
            while(true){
              System.out.println("続けるならy、終了するならnを押してください");
            String ans=scan.nextLine().trim().toLowerCase();
            
            if(ans.equals("n")){
               System.out.println("ゲームを終了します。ありがとうございます");
               System.out.println("勝った回数:"+win+",負けた回数:"+lose);
               break;
            }else if(ans.equals("y")){
                KeepPlaying=true;
                break;
            }else{
                System.out.println("正しく入力してください");
                continue;
            }
            }
            if(!KeepPlaying)break;
            
        }
        scan.close();

}

}

    