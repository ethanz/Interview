package hard;

import java.util.Arrays;
import java.util.Random;

import javax.swing.text.StyledEditorKit.ForegroundAction;

//Write a method to shuffle a deck of cards. It must be a perfect shuffle - 
//in other words, each 52! permutations of the deck has to be equally likely.
//Assume that you are given a random number generator which is perfect.
//дһ�����ϴ�ƺ�����Ҫ��ϴ����52!����϶��ǵȸ��ʵġ� 
//Ҳ������ϴ����һ����ϵĸ�����1/(52!)�������Ѿ�����һ���������������������
//�ص��� perfect shuffle  equally likely
//��Ϊ����������ˣ� ��ֱ�۵�˼·��ʲô���ܼ򵥣�ÿ�δ��ƶ����������һ�ų�������ô�� ��һ������52�ֿ��ܣ�
//�����ʣ��51�ţ��ڶ�������51�ֿ��ܣ�����������50�ֿ��ܣ� ����һֱ�������������ȥֱ���������1�ţ�
//���Ǿʹ�52!�ֿ�����ȡ����һ�����У� ������ж�Ӧ�ĸ�����1/(52!)����ȫ��������
//�㿴 �ⲻ���Ƕ�̬�滮��˼��ô���ͺ��������nԪȻ����1 3 5ԪӲ�ҹ�����һ����
public class ShuffleCards20_2 {
//���� ����ó�������Ʋ��ٲ����ǩ�أ�(����鵽���Ʋ���a[0]�Ļ�)����԰ѳ鵽���ƺ�a[0]��λ�ã�
//�����´γ鵽ʱ��ֻ��a[1]��a[51]�� �Դ�����	

	public static void shuffleCards(int[] cards){
	 
		for(int i=0;i<cards.length;i++){
				     //-i ��Ҫ���� ����i=50�� ��randon��30���� �ټ�50�� ��������Խ����ô
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

