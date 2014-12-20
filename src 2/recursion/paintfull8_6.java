package recursion;
//Implement the “paint fill” function that one might see on many image editing programs. 
//That is, given a screen (represented by a 2-dimensional array of Colors), 
//a point, and a new color, fill in the surrounding area until you hit a border of that color
//就像ps里面的油漆桶一样，点某个区域某个区域就都是这个颜色了
//eg:用红油漆桶倒蓝色区域，然后蓝色区域全部被红色覆盖了（但是蓝色区域周边的其他颜色还是被递归的）
//参数 color的二维数组，一个坐标，一种颜色（int）

public class paintfull8_6 {

	//为了简化题目，我们就假设int的二维数组好了，然后不同int是不同颜色，坐标就是二维数组中一个点
	//这题的recursive思路比较简单，无非就是被“传染”的点继续recursive"传染“附近的点。直到碰到constrains
	
	
	static boolean paintFull(int[][] screen,int x,int y, int newColor){
		int oldColor=screen[y][x];      //[第几行]（垂直大小）[第几列]（水平大小）
		return paintfull(screen,x,y,newColor,oldColor);
	}                         //行，列
	static boolean paintfull(int[][] screen,int x,int y,int newColor,int oldColor){
		            //第一行的长度                    //列数
		if(x<0||x>screen[0].length||y<0||y>screen.length){return false;}
		if(screen[y][x]==oldColor){//注意这个检查条件，如果已经到了其他颜色的地盘 这条if块里就不会执行了
			screen[y][x]=newColor; //先把本点变成新颜色
			//在“传染“ ----通过recursive给附近的点
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
