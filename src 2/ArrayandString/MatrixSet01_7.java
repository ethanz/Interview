package ArrayandString;

import java.lang.reflect.Array;
import java.util.Arrays;

//����ĿҪ�� ����һ��MxN matrix�����������ĳ��Ԫ��Ϊ0 ��ô���и��б�����Ϊ0
//���� ����͵����ڵ�һ��ѭ�������ô���Ļ���������5x5 matrix���� ��2����2�� ��0 
//��ô�ڶ��� �ڶ��ж��ᱻ����Ϊ0��������2����3��ʱ�� �����л�Ҳ��0�� ���Ծ���һ����ȫ0�� 
//����Ӧ���ȼ�¼��0 ���ģ� ��������������Ϊ0
//1.��������һ��MN������Ϊ��¼�ã�����not necessarily.
//����ֻҪ��¼ M�������ļ�����0��N�������Ǽ�����0������structure�Ŀ����ʹ� MxN ���M+N 
 
public class MatrixSet01_7 {
//m���� n����
	private static void setZero(int[][] a) {
		int[] columns = new int[a.length];
		for (int s : columns) {
			s = 0;
		}
		int[] rows = new int[a[0].length];
		for (int s : rows) {
			s = 0;
		}

		for (int i = 0; i < columns.length; i++) {
			for (int j = 0; j < rows.length; j++) {
				// most important line
				if (a[i][j] == 0) {
					columns[i]++;
					rows[j]++;
				}
			}
		}
		//System.out.print(Arrays.toString(columns));
		//System.out.print(Arrays.toString(rows));
		for (int i = 0; i < columns.length; i++) {
		
				for (int j = 0; j < rows.length; j++) {

				//�������������
					if(columns[i]!=0||rows[j]!=0){
						a[i][j]=0;

				}
				
			

			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] b = new int[4][5];
		
		 
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				b[i][j] = 2;

			}
		}
		b[2][3] = 0;
		b[1][1] = 0;

		for (int s = 0; s < 4; s++) {
			System.out.println("");
			for (int j = 0; j < 5; j++) {
				System.out.print(b[s][j] + " ");
			}
		}
		System.out.println("");
		setZero(b);
		System.out.println("");
		
		for (int s = 0; s < 4; s++) {
			System.out.println("");
			for (int j = 0; j < 5; j++) {
			System.out.print(b[s][j] + " ");
			}
		}

	}
}
