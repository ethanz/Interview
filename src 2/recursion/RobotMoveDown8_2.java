package recursion;

import java.util.Set;

//Imagine a robot sitting on the upper left hand corner of an XxY grid.
//The robot can only move in two directions: right and down. 
//How many possible paths are there for the robot?
//FOLLOW UP
//Imagine certain squares are “off limits”, such that the robot can not step on them.
//Design an algorithm to get all possible paths for the robot.
public class RobotMoveDown8_2 {
//机器人在矩阵的左上角移动到矩阵的右下角（看答案后确认题意如此）
//那么其实每条path都是走（x-1）（向右x-1次）+(y-1)（向下x-1次）步到达终点，但是走法可以有许多中
//题目中最要紧的一条是“The robot can only move in two directions: right and down. ”
//所以paths的数量牵涉到了一个概率公式  (x-1)在(x-1+y-1)总数中的排列组合
//Since you must always move right X-1 times, and you have X-1 + Y-1 total steps,
// you have to pick X-1 times to move right out of X-1+Y-1 choices. 
//	Thus, there are C(X-1, X-1+Y-1) paths
//	/(X-1 + Y-1)! / ((X-1)! * (Y-1)!)

//不带障碍的	
public static int countPossiblePaths(int x,int y){
	// 为什么是x==0||y==0呢？因为走到边了只有只有沿着边走着一条路径了 所以return 1
	if(x==0||y==0){return 1;}
	            //向右是一种可能                      向下也是一种可能 
	            //一直调用下去，直到碰到对面边界开始返回
	else{return countPossiblePaths(x-1,y)+countPossiblePaths(x,y-1);}
	//最左上的起点有右，下 两种可能，然后此时有2个点（所以第一个起始点递归调用了2个本方法），然后那2个点也有右下2种可能 所以2+2=4 所以（第二次的2个点递归调用了4个本方法）
	//2--4---8--16--32---然后因为碰到边界会返回1 所以最后 会返回1+1返回上去 然后调用它的方法可能会得到2+2 之类的 然后他的父方法 可能是得到4+4 然后越来越多return回上去
}

//带障碍的
public static int AllPossiblePathsWithObstacles(int x,int y,Set<Pair> obstacles){
	if(obstacles.contains(new Pair(x,y))){  //说明此格不能走,到此就0了位置了 不许|递|归|下|去！
		//也就减少了了继续递归带来的的path数，符合题意
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


//罗综艺的答案
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

