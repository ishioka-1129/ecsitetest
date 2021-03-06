package gametest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class kazuate{

	//0～999のランダムな数字を作り、保持
	//プレイヤーに数字を入力させる
	//保持している内容と比較し、結果を表示する
public static void main(String[] args) {
	Random random = new Random();

	int answer = random.nextInt(1000);
	int count = 0;
	int userAnswer = 0;

	System.out.println("0～999の数字を入力してください");

	while(count < 10) {
		System.out.printf("%d> ", count + 1);
		userAnswer = getNumberInput();
		System.out.printf("\t%d ..... ", userAnswer);
		if(answer == userAnswer) {
			System.out.println("正解！おめでとう！");
			break;
		} else if (answer < userAnswer) {
			System.out.println("大きすぎます！");
		} else {
			System.out.println("小さすぎます！");
		}

		int a = answer - userAnswer;
		if(10 >= a){
			if(a >= -10){
				if(a != 0){
					System.out.println("	おしい！");
				}
			}
		}

		count++;
	}

	if (answer != userAnswer ) {
		System.out.println("Game Over! 正解は " + answer + "でした");
	}

}

	//入力を受け付けることができる
	private static String getStringInput() {
		BufferedReader br = null;
		String line = null;

			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				line = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return line;
	}

	//入力が数値である場合入力を受付、それ以外の場合はもう一度入力させる
	private static int getNumberInput() {
		int userAnswer = -1;

		do {
			String s = getStringInput();
			try {
				userAnswer = Integer.parseInt(s);
			} catch(NumberFormatException e) {
				System.out.println("もう一度入力してください");
			}
		} while(userAnswer == -1);

		return userAnswer;
	}
}
