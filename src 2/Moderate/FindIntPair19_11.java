package Moderate;

import java.lang.reflect.Array;
import java.util.Arrays;

//Design an algorithm to find all pairs of integers within an array which sum to a specified value.
//���һ���㷨���ҵ����������к�Ϊָ��ֵ�������ԡ�
//����ȷ�˵��ָ��ֵ��10 a[0]��5 �����һ������һ��5 �������Ӷ���O(n^2) �϶���Ҫ�����Թٱ��ӵ�
//��ô��ô���͸��Ӷ��أ���ҪO(1)�ռ临�Ӷ�  O(nlgn)ʱ�临�Ӷȣ� ����һ��+����һ�� nlgn
//�������sort һ��������� ,Ȼ����low ��high ָ����λ��С������Ԫ�� 
//����˵ low+high�� ָ����sum��,��ôhigh+�������κ����������ܵ���ָ��ֵ�� ����high�������� high--
//ֱ��low+high<= sum �� �Ǹ�high�����������high,���high�����high��������������
//ͬ�� ���low+high��ָ��sumС����ôlow+�������κ����������ܵ���ָ��ֵ�� ����low�������� low++
//���sum=low+high ���� ��ӡ Ȼ��low++ high--
//ֱ��low>=high ����ѭ��
public class FindIntPair19_11 {
		public static void printSum(int[] a, int sum){
	Arrays.sort(a);
	int first=0;
	int last=a.length-1;
	while(first<last){
		int s=a[first]+a[last];
		if(s==sum){
			System.out.println(a[first]+"+"+a[last]);
			++first;
			--last;//��Ҫ�ظ��� Ҫ������С����			
		}else if(s<sum){
			++first;//��̫С������a[first]Ҫ���
		}else{//��ʱs>sum,��̫��������a[last]Ҫ��С
			last--;
		}
		}
	}

		
	
	public static void main(String[] args) {
		  int[] a = { 1, 2, 3, 4, 5, 6,8,9,10,11};
		  printSum(a,7); 
// �����������ģ���һ����12̫���������±��10
//����̫��9.8.7.
//6ʱ������ ���, Ȼ��22,5 ���� ���
//Ȼ��3.5 ���� ���
  
}
}