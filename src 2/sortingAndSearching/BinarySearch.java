package sortingAndSearching;

public class BinarySearch {

	// ֻ��sorted����ſ�����binarySearch
	// return ��int���±�
	
	// small big middle ������������±�
	public static int binarySearch(int[] a, int key){
		int small = 0;
		int big = a.length - 1;
		return binarySearch( a,small, big, key);
	}
	
	private static int binarySearch(int[] a,int small, int big, int key) {
		int middle = (small+big)/2;
		
		if (small > big) {
			return -1;
		} else {
			if (a[middle] == key) {
                return middle;
			}else if(a[middle]>key){ //key��ǰ���
				return binarySearch(a, small, middle-1, key);}
			else{return binarySearch(a, middle+1, big, key);}//key�ں���
				
			}
		}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
