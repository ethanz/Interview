package ArrayandString;

import java.lang.reflect.Array;
import java.util.Arrays;

//这题目要求 当在一个MxN matrix里面如果发现某个元素为0 那么该行该列被设置为0
//但是 如果就单纯在第一个循环里就这么做的话，假设在5x5 matrix里面 【2】【2】 是0 
//那么第二行 第二列都会被会设为0，当到【2】【3】时候 第三列会也会0， 所以矩阵一下子全0了 
//所以应该先记录下0 在哪， 再设置他们行列为0
//1.可以再设一个MN数组作为记录用，但是not necessarily.
//我们只要记录 M行里有哪几列有0，N列里有那几行有0，这样structure的开销就从 MxN 编程M+N 
 
public class MatrixSet01_7 {
//m是行 n是列
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

				//核心在这里！！！
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
