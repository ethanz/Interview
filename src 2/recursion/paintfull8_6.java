package recursion;
//Implement the ��paint fill�� function that one might see on many image editing programs. 
//That is, given a screen (represented by a 2-dimensional array of Colors), 
//a point, and a new color, fill in the surrounding area until you hit a border of that color
//����ps���������Ͱһ������ĳ������ĳ������Ͷ��������ɫ��
//eg:�ú�����Ͱ����ɫ����Ȼ����ɫ����ȫ������ɫ�����ˣ�������ɫ�����ܱߵ�������ɫ���Ǳ��ݹ�ģ�
//���� color�Ķ�ά���飬һ�����꣬һ����ɫ��int��

public class paintfull8_6 {

	//Ϊ�˼���Ŀ�����Ǿͼ���int�Ķ�ά������ˣ�Ȼ��ͬint�ǲ�ͬ��ɫ��������Ƕ�ά������һ����
	//�����recursive˼·�Ƚϼ򵥣��޷Ǿ��Ǳ�����Ⱦ���ĵ����recursive"��Ⱦ�������ĵ㡣ֱ������constrains
	
	
	static boolean paintFull(int[][] screen,int x,int y, int newColor){
		int oldColor=screen[y][x];      //[�ڼ���]����ֱ��С��[�ڼ���]��ˮƽ��С��
		return paintfull(screen,x,y,newColor,oldColor);
	}                         //�У���
	static boolean paintfull(int[][] screen,int x,int y,int newColor,int oldColor){
		            //��һ�еĳ���                    //����
		if(x<0||x>screen[0].length||y<0||y>screen.length){return false;}
		if(screen[y][x]==oldColor){//ע������������������Ѿ�����������ɫ�ĵ��� ����if����Ͳ���ִ����
			screen[y][x]=newColor; //�Ȱѱ���������ɫ
			//�ڡ���Ⱦ�� ----ͨ��recursive�������ĵ�
			paintfull(screen,x-1,y,newColor,oldColor);
			paintfull(screen,x,y-1,newColor,oldColor);
			paintfull(screen,x+1,y,newColor,oldColor);
			paintfull(screen,x,y+1,newColor,oldColor);
						
		}
	return true;
	} 
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
