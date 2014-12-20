package sortingAndSearching;

import javax.naming.directory.SearchControls;

//Given a matrix in which each row and each column is sorted,
//write a method to find an element in it.
//eg:请注意 不是每一行的首都大于上一行的尾巴，能确定是只是每行，每列内部都是递增的
// 但是有一点是可以确定的 ，越往左上越小，越往右下越大，
//但是为何不可以每次取矩阵中点，然后如果比他大，中点左上就不用看了，比他小，中点又下就不能看了呢？
//因为 剩下的不是矩阵了
//但是这个思考的大方向是好的，因为每行每列都是sort过了，我们要想办法合理的"跳到"某些不必查看的地方 而不是遍历。
//所以我们可以只和每行的最后一个点比较，直到key<某行最后一点，我们就把这行倒着遍历即可。这样复杂的度数O(m+n);
//1 2 3   4   5
//3 7 8   9   11
//5 9 10  17  18
//7 12 15 19  23
//9 13 16 20  25

public class FindinSortedMatrix9_6 {

	// 假设 这个int[][]的 是MxN //eg M行N列
	public static boolean searchInMatrix(int[][] a, int key, int M, int N) {
		int row = 0;
		int column = N - 1;// 最后一列的下标
		// 因为数组是从[0][0]开始的 所以row=m就是out of boundary了
		// row 最多M-1,所以最后一个允许进块的应该是M-2 然后进去++成为M-1
		while (row < M - 1 && column >= 0) {
			if (a[row][column] == key) {   
				return true;  
			}
			while (row < M - 1 && a[row][column] < key) {
				row++;
			}
			
			                  //“<=”的等于要保留，因为row++后的那行的最后一列还未check
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
