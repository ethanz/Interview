package recursion;

import java.util.Set;

//Imagine a robot sitting on the upper left hand corner of an XxY grid.
//The robot can only move in two directions: right and down. 
//How many possible paths are there for the robot?
//FOLLOW UP
//Imagine certain squares are ��off limits��, such that the robot can not step on them.
//Design an algorithm to get all possible paths for the robot.
public class RobotMoveDown8_2 {
//�������ھ�������Ͻ��ƶ�����������½ǣ����𰸺�ȷ��������ˣ�
//��ô��ʵÿ��path�����ߣ�x-1��������x-1�Σ�+(y-1)������x-1�Σ��������յ㣬�����߷������������
//��Ŀ����Ҫ����һ���ǡ�The robot can only move in two directions: right and down. ��
//����paths������ǣ�浽��һ�����ʹ�ʽ  (x-1)��(x-1+y-1)�����е��������
//Since you must always move right X-1 times, and you have X-1 + Y-1 total steps,
// you have to pick X-1 times to move right out of X-1+Y-1 choices. 
//	Thus, there are C(X-1, X-1+Y-1) paths
//	/(X-1 + Y-1)! / ((X-1)! * (Y-1)!)

//�����ϰ���	
public static int countPossiblePaths(int x,int y){
	// Ϊʲô��x==0||y==0�أ���Ϊ�ߵ�����ֻ��ֻ�����ű�����һ��·���� ����return 1
	if(x==0||y==0){return 1;}
	            //������һ�ֿ���                      ����Ҳ��һ�ֿ��� 
	            //һֱ������ȥ��ֱ����������߽翪ʼ����
	else{return countPossiblePaths(x-1,y)+countPossiblePaths(x,y-1);}
	//�����ϵ�������ң��� ���ֿ��ܣ�Ȼ���ʱ��2���㣨���Ե�һ����ʼ��ݹ������2������������Ȼ����2����Ҳ������2�ֿ��� ����2+2=4 ���ԣ��ڶ��ε�2����ݹ������4����������
	//2--4---8--16--32---Ȼ����Ϊ�����߽�᷵��1 ������� �᷵��1+1������ȥ Ȼ��������ķ������ܻ�õ�2+2 ֮��� Ȼ�����ĸ����� �����ǵõ�4+4 Ȼ��Խ��Խ��return����ȥ
}

//���ϰ���
public static int AllPossiblePathsWithObstacles(int x,int y,Set<Pair> obstacles){
	if(obstacles.contains(new Pair(x,y))){  //˵���˸�����,���˾�0��λ���� ����|��|��|��|ȥ��
		//Ҳ�ͼ������˼����ݹ�����ĵ�path������������
		return 0;
	}else{
		if(x==0||y==0){return 1;}
	return AllPossiblePathsWithObstacles(x,y-1,obstacles)+AllPossiblePathsWithObstacles(x-1,y,obstacles);
	}
}	

static class Pair{
	Integer x;
	Integer y;
	
	public Pair(int x,int y){
		this.x=new Integer(x);
		this.y=new Integer(y);
	}
	
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


//�����յĴ�
//public static boolean getPath(int x, int y, ArrayList<Point> path) {
//	Point point = new Point(x, y);
//	if (x == 0 && y == 0) {
//		return true;
//	}
//	boolean success = false;
//	if (x >= 1 && isFree(x - 1, y)) {
//		success = getPath(x - 1, y, path);
//	}
//	if (!success && y >= 1 && isFree(x, y - 1)) {
//		success = getPath(x, y - 1, path);
//	}
//	if (success) {
//		path.add(point);
//	}
//	return success;
//}
//
//private static boolean isFree(int x, int y) {
//	return false;
//}
//
//public static boolean getPath(int x, int y, ArrayList<Point> path,
//		Hashtable<Point, Boolean> cache) {
//	Point point = new Point(x, y);
//	if (cache.containsKey(point)) {
//		return cache.get(point);
//	}
//	if (x == 0 && y == 0) {
//		return true;
//	}
//	boolean success = false;
//	if (x >= 1 && isFree(x - 1, y)) {
//		success = getPath(x - 1, y, path);
//	}
//	if (!success && y >= 1 && isFree(x, y - 1)) {
//		success = getPath(x, y - 1, path);
//	}
//	if (success) {
//		path.add(point);
//	}
//	cache.put(point, success);
//	return success;
//}

