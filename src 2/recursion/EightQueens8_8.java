package recursion;

//Write an algorithm to print all ways of arranging eight queens 
//on a chess board so that none of them share the same row, column or diagonal.
//8皇后问题，在一个8x8的国际象棋二维数组的棋盘上 放8个皇后 int queen=8,每个皇后在下一步不能吃掉其他皇后
//每个皇后可以横走 直走 diagonal(斜走) 不限距离

/*暴力法：（缺点2^64种可能）
 * 那我可以遍历+递归么 第一个皇后 可以放任一格子，递归调用-第二个皇后可以放禁区之外的任意格子-递归调用第三个皇后。。。
 *直到皇后数目=0 时候 这是个成功的放法。可以打印之。
 */

/* 更好的方法
 * 由于皇后们是不能放在同一行的， 所以我们可以去掉“行”这个因素，即我第1次考虑把皇后放在第1行的某个位置，
 *   第2次放的时候就不用去放在第一行了.第2次我就考虑把皇后放在第2行的某个位置，第3次我考虑把皇后放在第3行的某个位置，
 * 这样依次去递归。每计算1行，递归一次，每次递归里面考虑8列， 即对每一行皇后有8个可能的位置可以放。
 * 找到一个与前面行的皇后都不会互相攻击的位置， 然后再递归进入下一行
 * 用for循环（i=0-7）表示行 用一个column[0-7]一维数组表示列
 * column[i]=j ---》第i行的queen放在第j列  (下标是行数，值 column[i]是列数)
 */

public class EightQueens8_8 {

	// 如何写检查这个格子是否可用的方法，在coding之前要先理解题意
	// 因为现在的列是一维数组，所以之前place过皇后的列都不能用，eg:第一个皇后放在int[0],以后所有的0都不能用了
	// 斜对角线怎么算？ 有正对角线和反对角线，(请记住，for循环里的i是行数)，
	// 要判断是否在已存在queen的正对角线上，行1-行2=列1-列2. (下标是行数，值 column[i]是列数)
	// 所以(i-j)==column[i]-column[j];
	// 同理 反对角线，行1-行2=列2-列1
	// 所以(j-i)==column[i]-column[j];

	static int column[] = new int[8];

	public static boolean checkPosition(int row) {
		for (int i = 0; i < row; i++) { //为何要i<row 因为i是已经放置过皇后的行数，比方说现在传进来的row是3
			                            //那么就说明0行 1行 2行都已经放过皇后了 所以才是i和row比
			
			// 计算斜线的差，因为正反斜线的check只不过是符号不同 所以可以用绝对值
			int columnDiff = Math.abs(column[i] - column[row]); // diff是列的差(下标是行数，值
																// column[i]是列数)
			// 两个queen在同一列上 两个queen在同一对角线上
			if (columnDiff == 0 || columnDiff == row - i) {
				return false;
			}
		}

		return true;
	}

	public static void placeQueens(int row) {
		if (row == 8) {
			System.out.println("found one");
			for (int i = 0; i < 8; i++) {
				System.err.print(i +"row");
				System.err.print(column[i]+"col");
			
				System.out.println("");
			}
			return;
		}
		for (int i = 0; i < 8; i++) {// 这个for遍历的是column
			column[row] = i;//第一个皇后肯定是可以在第一格子随便放的，但是第二次递归开始都要check 所以复制在这里对
			if (checkPosition(row)) {;// 当前row 每一个column test过来  
				placeQueens(row + 1); //能进到这里被递归调用的都是valid的格子
			}
		}
	}

	public static void main(String[] args) {
    placeQueens(0);
	}

}
