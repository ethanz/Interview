package hard;

import java.util.Arrays;
import java.util.Random;

import javax.swing.text.StyledEditorKit.ForegroundAction;

//Write a method to shuffle a deck of cards. It must be a perfect shuffle - 
//in other words, each 52! permutations of the deck has to be equally likely.
//Assume that you are given a random number generator which is perfect.
//写一个随机洗牌函数。要求洗出的52!种组合都是等概率的。 
//也就是你洗出的一种组合的概率是1/(52!)。假设已经给你一个完美的随机数发生器。
//重点是 perfect shuffle  equally likely
//因为你有随机数了， 最直观的思路是什么？很简单，每次从牌堆中随机地拿一张出来。那么， 第一次拿有52种可能，
//拿完后剩下51张；第二次拿有51种可能，第三次拿有50种可能， …，一直这样随机地拿下去直到拿完最后1张，
//我们就从52!种可能中取出了一种排列， 这个排列对应的概率是1/(52!)，完全符合题意
//你看 这不就是动态规划的思想么，就和那题给定n元然后用1 3 5元硬币构成是一样的
public class ShuffleCards20_2 {
//但是 如何让抽出来的牌不再参与抽签呢？(如果抽到的牌不是a[0]的话)你可以把抽到的牌和a[0]换位置，
//这样下次抽到时候只在a[1]到a[51]抽 以此类推	

	public static void shuffleCards(int[] cards){
	 
		for(int i=0;i<cards.length;i++){
				     //-i 不要忘了 否则i=50了 你randon个30出来 再加50了 不是数组越界了么
			int random=(int)(Math.random()*(cards.length-i))+i;
			int temp=cards[i];
			cards[i]=cards[random];
			cards[random]=temp;
		}
	}
	public static void main(String[] args) {
		int[] a={1,2,3,4,5,6,7,8,9};
		shuffleCards(a);
		System.out.print(Arrays.toString(a));
	}
	
}

