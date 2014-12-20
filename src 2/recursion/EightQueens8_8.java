package recursion;

//Write an algorithm to print all ways of arranging eight queens 
//on a chess board so that none of them share the same row, column or diagonal.
//8�ʺ����⣬��һ��8x8�Ĺ��������ά����������� ��8���ʺ� int queen=8,ÿ���ʺ�����һ�����ܳԵ������ʺ�
//ÿ���ʺ���Ժ��� ֱ�� diagonal(б��) ���޾���

/*����������ȱ��2^64�ֿ��ܣ�
 * ���ҿ��Ա���+�ݹ�ô ��һ���ʺ� ���Է���һ���ӣ��ݹ����-�ڶ����ʺ���ԷŽ���֮����������-�ݹ���õ������ʺ󡣡���
 *ֱ���ʺ���Ŀ=0 ʱ�� ���Ǹ��ɹ��ķŷ������Դ�ӡ֮��
 */

/* ���õķ���
 * ���ڻʺ����ǲ��ܷ���ͬһ�еģ� �������ǿ���ȥ�����С�������أ����ҵ�1�ο��ǰѻʺ���ڵ�1�е�ĳ��λ�ã�
 *   ��2�ηŵ�ʱ��Ͳ���ȥ���ڵ�һ����.��2���ҾͿ��ǰѻʺ���ڵ�2�е�ĳ��λ�ã���3���ҿ��ǰѻʺ���ڵ�3�е�ĳ��λ�ã�
 * ��������ȥ�ݹ顣ÿ����1�У��ݹ�һ�Σ�ÿ�εݹ����濼��8�У� ����ÿһ�лʺ���8�����ܵ�λ�ÿ��Էš�
 * �ҵ�һ����ǰ���еĻʺ󶼲��ụ�๥����λ�ã� Ȼ���ٵݹ������һ��
 * ��forѭ����i=0-7����ʾ�� ��һ��column[0-7]һά�����ʾ��
 * column[i]=j ---����i�е�queen���ڵ�j��  (�±���������ֵ column[i]������)
 */

public class EightQueens8_8 {

	// ���д�����������Ƿ���õķ�������coding֮ǰҪ���������
	// ��Ϊ���ڵ�����һά���飬����֮ǰplace���ʺ���ж������ã�eg:��һ���ʺ����int[0],�Ժ����е�0����������
	// б�Խ�����ô�㣿 �����Խ��ߺͷ��Խ��ߣ�(���ס��forѭ�����i������)��
	// Ҫ�ж��Ƿ����Ѵ���queen�����Խ����ϣ���1-��2=��1-��2. (�±���������ֵ column[i]������)
	// ����(i-j)==column[i]-column[j];
	// ͬ�� ���Խ��ߣ���1-��2=��2-��1
	// ����(j-i)==column[i]-column[j];

	static int column[] = new int[8];

	public static boolean checkPosition(int row) {
		for (int i = 0; i < row; i++) { //Ϊ��Ҫi<row ��Ϊi���Ѿ����ù��ʺ���������ȷ�˵���ڴ�������row��3
			                            //��ô��˵��0�� 1�� 2�ж��Ѿ��Ź��ʺ��� ���Բ���i��row��
			
			// ����б�ߵĲ��Ϊ����б�ߵ�checkֻ�����Ƿ��Ų�ͬ ���Կ����þ���ֵ
			int columnDiff = Math.abs(column[i] - column[row]); // diff���еĲ�(�±���������ֵ
																// column[i]������)
			// ����queen��ͬһ���� ����queen��ͬһ�Խ�����
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
		for (int i = 0; i < 8; i++) {// ���for��������column
			column[row] = i;//��һ���ʺ�϶��ǿ����ڵ�һ�������ŵģ����ǵڶ��εݹ鿪ʼ��Ҫcheck ���Ը����������
			if (checkPosition(row)) {;// ��ǰrow ÿһ��column test����  
				placeQueens(row + 1); //�ܽ������ﱻ�ݹ���õĶ���valid�ĸ���
			}
		}
	}

	public static void main(String[] args) {
    placeQueens(0);
	}

}
