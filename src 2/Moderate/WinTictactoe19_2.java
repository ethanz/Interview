package Moderate;

//Design an algorithm to figure out if someone has won in a game of tic-tac-toe.
//����㷨���ĳ���Ƿ�Ӯ���˾�����Ϸ��
//advance�����粻��3x3����NxN����
public class WinTictactoe19_2 {
	/*	
	 * ���1���Ƿ���������ᱻƵ�����ã�eg:�ж�1000w���������ǲ���Ӯ�ˣ� ��ô���ǿ��԰�����
	 * �Ŀ������ܴ���һ���ط���ÿ��ֻҪ0��1��ȥ�ж��¾Ϳ��� ���ھ�����Ϸ��ÿ�����ӿ����ǿգ��ҵ����ӺͶԷ�������3�ֿ��ܣ��ܹ���3^9 = 19683
	 * �ֿ���״̬ 1 2 2 �ȷ�˵����������9λ��3������122211201 ��ת��10���� ���������Ｔ�ɡ� 2 1 1
	 * Ȼ�������һ�����飬������19683 Ȼ��1��ʾӮ 0��ʾ�� Ȼ��ͨ��������±�ȥ�����Ӧ�±��￴0 1���� 2 0 1 ʱ����O(1);
	 * //���Ҫ���� ˭Ӯ�˿��԰ɽ��Ԥ����char������ ���±���Ȼ��19683����
	 */

	/*
	 * ���2���Ƿ������������ᱻƵ������ ��Ԥ����Ͳ������� ���Ǿ�д������������ֱ����NxN�İ� ��ͨN����ʤ��
	 * �ж�n*n�������Ƿ�����Ӯ����ͬһ��������һ��
	 */

	// ������һ��char[][]�����̸� Ȼ�� 'o','x',' '�����̸���������
	// ��ô���Ǽ�� ���� ���� ��б ��б

	public static char hasWon(char[][] board) {
		int type = 0;
		int N = board.length;
		int i, j;
		// checkÿһ��
		for (i = 0; i < N; i++) {
			// ���i��1�в�Ϊ��,������ÿһ��
			if (board[i][0] != ' ') {
				for (j = 1; j < N; j++) { // ��Ϊj++�� ������ôд�Ǽ�������ǲ��Ƕ���ͬһ��char
											// ���Ǿ����������һ��
					if (board[i][j] != board[i][j - 1]) {
						break;
					}
				} // ���û��break ��j�����˻��ǵ���ǰ�� ˵������һ������
				if (j == N) {
					return board[i][0];
				}// �������ϵķ���
			}
		}

		// checkÿһ��

		for (j = 0; j < N; j++) {
			// ���i��1�в�Ϊ��,������ÿһ��
			if (board[0][j] != ' ') {
				for (i = 1; i < N; i++) { // ��Ϊi++�� ������ôд�Ǽ�������ǲ��Ƕ���ͬһ��char
											// ���Ǿ����������һ��
					if (board[i][j] != board[i - 1][j]) {
						break;
					}
				} // ���û��break ��i�����˻��ǵ���ǰ�� ��ֱ����һ������
				if (i == N) {
					return board[0][j];
				}// �������ϵķ���
			}
		}

		// ���Խ��߼��(����Ϸ��ֻ�������ϵ���������һ��)
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
	
		// ���Խ��߼��(����Ϸ��ֻ�������µ�����)
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
