package sortingAndSearching;

import javax.naming.directory.SearchControls;

//Given a matrix in which each row and each column is sorted,
//write a method to find an element in it.
//eg:��ע�� ����ÿһ�е��׶�������һ�е�β�ͣ���ȷ����ֻ��ÿ�У�ÿ���ڲ����ǵ�����
// ������һ���ǿ���ȷ���� ��Խ������ԽС��Խ������Խ��
//����Ϊ�β�����ÿ��ȡ�����е㣬Ȼ������������е����ϾͲ��ÿ��ˣ�����С���е����¾Ͳ��ܿ����أ�
//��Ϊ ʣ�µĲ��Ǿ�����
//�������˼���Ĵ����Ǻõģ���Ϊÿ��ÿ�ж���sort���ˣ�����Ҫ��취�����"����"ĳЩ���ز鿴�ĵط� �����Ǳ�����
//�������ǿ���ֻ��ÿ�е����һ����Ƚϣ�ֱ��key<ĳ�����һ�㣬���ǾͰ����е��ű������ɡ��������ӵĶ���O(m+n);
//1 2 3   4   5
//3 7 8   9   11
//5 9 10  17  18
//7 12 15 19  23
//9 13 16 20  25

public class FindinSortedMatrix9_6 {

	// ���� ���int[][]�� ��MxN //eg M��N��
	public static boolean searchInMatrix(int[][] a, int key, int M, int N) {
		int row = 0;
		int column = N - 1;// ���һ�е��±�
		// ��Ϊ�����Ǵ�[0][0]��ʼ�� ����row=m����out of boundary��
		// row ���M-1,�������һ����������Ӧ����M-2 Ȼ���ȥ++��ΪM-1
		while (row < M - 1 && column >= 0) {
			if (a[row][column] == key) {   
				return true;  
			}
			while (row < M - 1 && a[row][column] < key) {
				row++;
			}
			
			                  //��<=���ĵ���Ҫ��������Ϊrow++������е����һ�л�δcheck
			for (int i = 0; i <=(N - 1); i++) {
				if (a[row][i] == key) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int temp = 1;
		int[][] a = new int[10][8];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 8; j++) {
				// most important line
				a[i][j] = temp++;
			}
		}
		System.out.print(searchInMatrix(a, 80, 10, 8));

	}

}
