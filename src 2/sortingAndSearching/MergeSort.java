package sortingAndSearching;

//经典sort复习：mergesort 归并排序(O(nlgn))
//归并排序是吧2个或者2个以上的有序表合并成一个
//0.假设数据是原始未排序状态
//1.现将N个数据看成是N个长度为1的表，将相邻的表成对合并比大小，得到N/2个长度为2的有序表
//2.再把剩下的表相邻的比大小，得到N/4个长度为4的有序表。以此类推
//体现了 分而治之的思想
public class MergeSort {

	public  static int [] mergeSort(int[] array) {
		if(array.length<=1){
			return array;
		}
		int halfLength=array.length/2;
		int[] array1=new int[halfLength];
		int[] array2=new int[array.length-halfLength];
		//因为是基本类型数组 所以用系统给的copy方法无障碍。 这样就等于实质性有了2个分割。
		System.arraycopy(array, 0, array1, 0, array1.length);
		System.arraycopy(array, halfLength, array2, 0, array2.length);
		array1=mergeSort(array1);//(递归调用)
		array2=mergeSort(array2);
		return mergeSort2Array(array1,array2);
	}

	private static int[] mergeSort2Array(int[] array1, int[] array2) {
		int[] result = new int[array1.length + array2.length];
		int i = 0;// array1下标
		int j = 0;// array2下标
		int k = 0;// result 下标
		while (true) {// 谁小，谁放到result数组里面，记得下标分别++
			if (array1[i] < array2[j]) {
				result[k] = array1[i];// 那个小 那个放到result里

				// 因为不管if{}里面的东西只不执行，()里的判断是都要执行的，所以++i会被操作
				if (++i > array1.length - 1) {
					break;
				}// array1 用完 跳出while循环
			} else {
				result[k] = array2[j];
				if (++j > array2.length - 1) {
					break;
				}
			}
			k++;
		}//此时，某个数组全进完了，跳出while循环
		//剩下的事情就是把那个没进完的数组都弄进result就可以了
		
		
		for(;i<array1.length;i++){//不写默认从之前的i开始
			result[++k]=array1[i];
		}
		for(;j<array2.length;j++){
			result[++k]=array2[j];
		}
		return result;
	}

	public static void main(String[] args) {
		int[] a={6,3,6,4,2,3,9,5,3,2,0};
		int[]  b=mergeSort(a);
		for(int i=0;i<b.length;i++){
		System.out.print(b[i]);
		}
	}

}
