package ArrayandString;
//本题要求矩阵转置 NxN matrix
//题目要求每个元素是一个像素  4 bytes       
public class RotationMatrix1_6 {

	
	static int temp=1;
	
	//in place转换 无需额外空间 
	 private static int[][] rotate(int[][] matrix, int n) {
		 for(int layer=0;layer<n/2;++layer){ //外循环 层数变大
			  int first=layer;
			  int last=n-1-layer;//下标 -layer
		  for(int i=first;i<last;++i){   //first是层数,i是本层中的位置
			  int offset=i-first;//offset是位移的意思
		      //储存上边
			  int top=matrix[first][i];
		      //左到上 
			  matrix[first][i]=matrix[last-offset][first];
			  //下到左
			  matrix[last-offset][first]=matrix[last][last-offset]; 
			  //右到下
			  matrix[last][last-offset]=matrix[i][last];
			  //上到右
			   matrix[i][last]=top;
		  
		  
		  }
		  
		  }
		return matrix;
	 }


	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int[][] aaa = new int[5][5];
		   for (int i = 0; i < 5; i++) {
		         for (int j = 0; j < 5; j++) {
		           aaa[i][j] = temp++;
		         }
		     }
		   for (int i = 0; i < 5; i++) {
			   System.out.println("");
		         for (int j = 0; j < 5; j++) {
		        	 System.out.print(aaa[i][j]+" ");
		         }
		     }
		   
		 aaa=  rotate(aaa, 5) ;
		 for (int i = 0; i < 5; i++) {
			   System.out.println("");
		         for (int j = 0; j < 5; j++) {
		        	 System.out.print(aaa[i][j]+" ");
		         }
		     }
		   
		   
		
	}

}
