package Moderate;

//Design an algorithm to figure out if someone has won in a game of tic-tac-toe.
//设计算法检查某人是否赢得了井字游戏。
//advance：假如不是3x3而是NxN的呢
public class WinTictactoe19_2 {
	/*	
	 * 情况1：是否这个方法会被频繁调用（eg:判断1000w次这个棋局是不是赢了） 那么我们可以把所有
	 * 的可能性能存在一个地方，每次只要0（1）去判断下就可以 对于井字游戏，每个格子可以是空，我的棋子和对方的棋子3种可能，总共有3^9 = 19683
	 * 种可能状态 1 2 2 比方说左边这个就是9位的3进制数122211201 再转成10进制 存在数组里即可。 2 1 1
	 * 然后等于有一个数组，长度是19683 然后1表示赢 0表示输 然后通过酸楚的下标去数组对应下标里看0 1即可 2 0 1 时间是O(1);
	 * //如果要返回 谁赢了可以吧结果预存在char数组里 ，下标依然是19683个。
	 */

	/*
	 * 情况2：是否这个方法不会会被频繁调用 那预处理就不合算了 我们就写个正常方法，直接上NxN的吧 联通N个算胜利
	 * 判断n*n的棋盘是否有人赢，即同一棋子连成一线
	 */

	// 假设是一个char[][]的棋盘格 然后 'o','x',' '是棋盘格的三种情况
	// 那么就是检查 横向 纵向 正斜 反斜

	public static char hasWon(char[][] board) {
		int type = 0;
		int N = board.length;
		int i, j;
		// check每一行
		for (i = 0; i < N; i++) {
			// 如果i行1列不为空,检查该行每一列
			if (board[i][0] != ' ') {
				for (j = 1; j < N; j++) { // 因为j++了 所以这么写是检查这行是不是都是同一个char
											// 不是就跳出检查下一行
					if (board[i][j] != board[i][j - 1]) {
						break;
					}
				} // 如果没有break 当j到底了还是等于前面 说明连成一条线了
				if (j == N) {
					return board[i][0];
				}// 返回线上的符号
			}
		}

		// check每一列

		for (j = 0; j < N; j++) {
			// 如果i行1列不为空,检查该行每一列
			if (board[0][j] != ' ') {
				for (i = 1; i < N; i++) { // 因为i++了 所以这么写是检查这行是不是都是同一个char
											// 不是就跳出检查下一行
					if (board[i][j] != board[i - 1][j]) {
						break;
					}
				} // 如果没有break 当i到底了还是等于前面 垂直连成一条线了
				if (i == N) {
					return board[0][j];
				}// 返回线上的符号
			}
		}

		// 正对角线检查(在游戏里只有最左上到最右下着一条)
		if (board[0][0] != ' ') {
			for (i = 1; i < N; i++) {
				if (board[i][i] != board[i - 1][i - 1]) {
					break;
				}
			}
		}
		if (i == N) {
			return board[0][0];
		}
	
		// 反对角线检查(在游戏里只有最左下到右上)
		if (board[N-1][0] != ' ') {
			for (i = 1; i < N; i++) {
				if (board[(N-i)-1][i] != board[N-i][i - 1]) {
					break;
				}
			}
		}
		if (i == N) {
			return board[N-1][0];
		}
	
	
	return ' ';
	
	}

	public static void main(String[] args) {
		char[][] board = {  
                {'x', 'x', 'o'},  
                {' ', 'x', ' '},  
                {' ', ' ', 'x'}};  
  
  
  
char result = hasWon(board);  
if(result == ' '){  
    System.out.println("No one won!");  
}else{  
    System.out.println(result + " has won");  
}  

	}

}
