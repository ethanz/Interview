package sortingAndSearching;

//Given a sorted array of n integers that has been rotated an unknown number of times, 
//give an O(log n) algorithm that finds an element in the array.
//You may assume that the array was originally sorted in increasing order.
//һ��������n�������������ź���(����Ϊ����)������ת��δ֪�Σ�
//��ÿ�ΰ����ұߵ����ŵ�����ߡ�����һ��O(log n)���㷨�ҵ��ض���ĳ��Ԫ�ء�
//��Ϊrotatedָ�İ����ұߵ����Ƶ�����������������������   |��������|  �� 
//eg��(15 16 19 20 25 28 33 35 1 3 4 5 7 10)
// 15-25 ����1 ��14����ǰ��δ��ں���

//��ĿҪ��O(log n) ���Ա�������ʲô�Ĳ�Ҫ����
//�� ��ע�� binary sort ��O(log n)�� ���Ա���ĿҪ���Ըı�һ��binary search

public class FindAfterRotate9_3 {
	public static int search(int a[], int key) {
		return search(a, 0, a.length - 1, key);
	}

	// ����5������Ҫ�жϣ������L(��һ����С�����ǻ��Ǳ�R��)�����ҵ�R���м��M��ת�۵�min(�ʼ�����)(mid��ǰһ������max����������׬��1Ȧ)��Ҫ��ĵ�key.
	// �ȷ�˵��ھ��е����� L=15��middle=33��R-10��min=1(һ��ʼ���ǲ�֪��)
	// ���A��L<middle:˵��middle�ڵ�һ������Σ�min��middle�ұ� L...mid..min.....R
	// A.1: ��ʱ���L<middle<KEY ��˵��key��mid�ұߣ����ڵ�һ������� L...mid...key...min.....R
	// A.2�� ���L<Key<middle,��˵��key��mid��� L...key...mid...min...R
	// A.3 ��� Key<L<middle,��˵��key��mid�ұߣ��ڵڶ�������� L...mid...min...key...R
	// ���B��L>middle:˵��middle�ڵڶ�������Σ�min��middle��� L...min...mid....R
	// B.1: ��ʱ���L>middle>KEY ��˵��key��mid��ߣ����ڵڶ�������� L...min...key...mid...R
	// B.2�� ���L>key>middle ,��˵��key��mid�ұ�,�ڵڶ�������� L...min...mid...key..R
	// B.3 ��� Key>L>Middle,��˵��key��mid��ߣ��ڵ�һ���ұ� L...key..min...mid...R

	private static int search(int a[], int low, int high, int key) {
		while (low < high) {
			int middle = (low + high) / 2;
			if (a[middle] == key) {
				return middle;
			} else if (a[low] <= a[middle]) { // ���A,mid�ڵ�һ�����
				if (key > a[middle]) { // A.1 key��mid�ұ�
					low = middle + 1;
				} else if (key > a[low]) { // A.2 Key��mid���
					// ps �ܽ�����һ��,�϶���midС����������һ��if�������
					high = middle - 1;
				} else { // A.3 key��mid�ұ�
					low = middle + 1;
				}
			}else{//// ���B,mid�ڵڶ������
				if (key < a[middle]) { // B.1 key��mid���
					high = middle - 1;
				} else if (key <= a[low]) { // B.2 Key��mid�ұ�
					
					// ps �ܽ�����һ��,�϶���mid�󰡣�������һ��if������� ���Ա�����a [middle]<key<a[R] 
				low = middle + 1;
				} else { //B.3 key��mid�ұ�
					high= middle -1;
				}
			}

		}
return -1;
	}

	public static void main(String[] args) {
		int a[] = { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14   };
		System.out.println(search(a,19));

	}

}
