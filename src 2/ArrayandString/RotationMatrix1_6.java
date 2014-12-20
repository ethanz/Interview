package ArrayandString;
//����Ҫ�����ת�� NxN matrix
//��ĿҪ��ÿ��Ԫ����һ������  4 bytes       
public class RotationMatrix1_6 {

	
	static int temp=1;
	
	//in placeת�� �������ռ� 
	 private static int[][] rotate(int[][] matrix, int n) {
		 for(int layer=0;layer<n/2;++layer){ //��ѭ�� �������
			  int first=layer;
			  int last=n-1-layer;//�±� -layer
		  for(int i=first;i<last;++i){   //first�ǲ���,i�Ǳ����е�λ��
			  int offset=i-first;//offset��λ�Ƶ���˼
		      //�����ϱ�
			  int top=matrix[first][i];
		      //���� 
			  matrix[first][i]=matrix[last-offset][first];
			  //�µ���
			  matrix[last-offset][first]=matrix[last][last-offset]; 
			  //�ҵ���
			  matrix[last][last-offset]=matrix[i][last];
			  //�ϵ���
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
