package sortingAndSearching;

//����sort��ϰ��mergesort �鲢����(O(nlgn))
//�鲢�����ǰ�2������2�����ϵ������ϲ���һ��
//0.����������ԭʼδ����״̬
//1.�ֽ�N�����ݿ�����N������Ϊ1�ı������ڵı�ɶԺϲ��ȴ�С���õ�N/2������Ϊ2�������
//2.�ٰ�ʣ�µı����ڵıȴ�С���õ�N/4������Ϊ4��������Դ�����
//������ �ֶ���֮��˼��
public class MergeSort {

	public  static int [] mergeSort(int[] array) {
		if(array.length<=1){
			return array;
		}
		int halfLength=array.length/2;
		int[] array1=new int[halfLength];
		int[] array2=new int[array.length-halfLength];
		//��Ϊ�ǻ����������� ������ϵͳ����copy�������ϰ��� �����͵���ʵ��������2���ָ
		System.arraycopy(array, 0, array1, 0, array1.length);
		System.arraycopy(array, halfLength, array2, 0, array2.length);
		array1=mergeSort(array1);//(�ݹ����)
		array2=mergeSort(array2);
		return mergeSort2Array(array1,array2);
	}

	private static int[] mergeSort2Array(int[] array1, int[] array2) {
		int[] result = new int[array1.length + array2.length];
		int i = 0;// array1�±�
		int j = 0;// array2�±�
		int k = 0;// result �±�
		while (true) {// ˭С��˭�ŵ�result�������棬�ǵ��±�ֱ�++
			if (array1[i] < array2[j]) {
				result[k] = array1[i];// �Ǹ�С �Ǹ��ŵ�result��

				// ��Ϊ����if{}����Ķ���ֻ��ִ�У�()����ж��Ƕ�Ҫִ�еģ�����++i�ᱻ����
				if (++i > array1.length - 1) {
					break;
				}// array1 ���� ����whileѭ��
			} else {
				result[k] = array2[j];
				if (++j > array2.length - 1) {
					break;
				}
			}
			k++;
		}//��ʱ��ĳ������ȫ�����ˣ�����whileѭ��
		//ʣ�µ�������ǰ��Ǹ�û��������鶼Ū��result�Ϳ�����
		
		
		for(;i<array1.length;i++){//��дĬ�ϴ�֮ǰ��i��ʼ
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
