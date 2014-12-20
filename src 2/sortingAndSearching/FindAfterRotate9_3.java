package sortingAndSearching;

//Given a sorted array of n integers that has been rotated an unknown number of times, 
//give an O(log n) algorithm that finds an element in the array.
//You may assume that the array was originally sorted in increasing order.
//一个数组有n个整数，它们排好序(假设为升序)但被旋转了未知次，
//即每次把最右边的数放到最左边。给出一个O(log n)的算法找到特定的某个元素。
//因为rotated指的把最右边的数移到最左边来，所以这个数组是   |部分有序|  的 
//eg：(15 16 19 20 25 28 33 35 1 3 4 5 7 10)
// 15-25 有序，1 ～14有序，前半段大于后半段

//题目要求O(log n) 所以遍历数组什么的不要想了
//又 请注意 binary sort 是O(log n)的 所以本题目要稍稍改变一下binary search

public class FindAfterRotate9_3 {
	public static int search(int a[], int key) {
		return search(a, 0, a.length - 1, key);
	}

	// 共有5个点需要判断：最左点L(第一段最小，但是还是比R大)，最右点R，中间点M，转折点min(最开始的起点)(mid的前一个点是max，除非正好赚了1圈)，要求的点key.
	// 比方说像第九行的数组 L=15，middle=33，R-10，min=1(一开始我们不知道)
	// 情况A：L<middle:说明middle在第一个有序段，min在middle右边 L...mid..min.....R
	// A.1: 此时如果L<middle<KEY 则说明key在mid右边，且在第一个有序段 L...mid...key...min.....R
	// A.2： 如果L<Key<middle,则说明key在mid左边 L...key...mid...min...R
	// A.3 如果 Key<L<middle,则说明key在mid右边，在第二个有序段 L...mid...min...key...R
	// 情况B：L>middle:说明middle在第二个有序段，min在middle左边 L...min...mid....R
	// B.1: 此时如果L>middle>KEY 则说明key在mid左边，且在第二个有序段 L...min...key...mid...R
	// B.2： 如果L>key>middle ,则说明key在mid右边,在第二个有序段 L...min...mid...key..R
	// B.3 如果 Key>L>Middle,则说明key在mid左边，在第一个右边 L...key..min...mid...R

	private static int search(int a[], int low, int high, int key) {
		while (low < high) {
			int middle = (low + high) / 2;
			if (a[middle] == key) {
				return middle;
			} else if (a[low] <= a[middle]) { // 情况A,mid在第一有序段
				if (key > a[middle]) { // A.1 key在mid右边
					low = middle + 1;
				} else if (key > a[low]) { // A.2 Key在mid左边
					// ps 能进到这一块,肯定比mid小啊，否则被上一个if块接走了
					high = middle - 1;
				} else { // A.3 key在mid右边
					low = middle + 1;
				}
			}else{//// 情况B,mid在第二有序段
				if (key < a[middle]) { // B.1 key在mid左边
					high = middle - 1;
				} else if (key <= a[low]) { // B.2 Key在mid右边
					
					// ps 能进到这一块,肯定比mid大啊，否则被上一个if块接走了 所以本质是a [middle]<key<a[R] 
				low = middle + 1;
				} else { //B.3 key在mid右边
					high= middle -1;
				}
			}

		}
return -1;
	}

	public static void main(String[] args) {
		int a[] = { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14   };
		System.out.println(search(a,19));

	}

}
