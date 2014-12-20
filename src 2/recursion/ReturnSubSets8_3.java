package recursion;

import java.util.ArrayList;

//Write a method that returns all subsets of a set.
//дһ����������һ�������е������Ӽ���
// For example S = {1, 2, 3} then P(s) = {{}, {1}, {2}, {3}, {1,2}, {1, 3}, {2, 3}, {1, 2, 3}}.
//If S has n elements in it then P(s) will have 2^n elements
//����һ�����ϣ������Ӽ�һ����2^n ��(�����ռ���������)��(������ѧ)
//�����ĿΪʲô�����õݹ飿 ��Ϊ�������ҵ���ԭ�����ģСȴͬ�ʵ����⡣(��ע�� ���˼��ǳ���Ҫ)
//�ȷ�˵ ���Ȱ�1 �ó��� ����������2 3���Ӽ�����ô2 3���Ӽ���2��3��  2 3��ͬʱҲ��123���Ӽ�
//Ȼ���Ұ����2 3���Լ���2��3��23�� ����1�ӽ�ȥ�����Ǿ����ˣ�1 2��1 3��123������ 2 3 1 ��23 �Ϳռ�

//���Դ�ʱ {} 1��2��3 123 ��12��13��23������
//arraylist��������װ���Ϻ�Ԫ�أ���ע�� ÿ�������Ӽ�����arraylist���ȷ�˵һ���Ӽ���(123)ʵ������arraylist{1,2,3}
//���Ӽ���ÿ��Ԫ�ض���Integer���Ǹ�forѭ��������ʵ�ӵĶ���integer

//ֱ��arraylist����һ�㷵�صĽ������add��set.get(index)+��һ�㷵�صĽ����  ������һ�����

public class ReturnSubSets8_3 {
     //���������set�� {1,2,3,4}
	//1.����һ���ݹ���õ��±�4 Ȼ��
	//2.����4����һ�����Ӽ���һ����arraylist�� ������3
	//3.����3����{}.{4} ������2���±�2��

	//4. ����2ѭ��2�Σ���Ϊ����3����2��arraylist������{({ 4}��{}).add({3��4}��{ 3})���ظ�����1
	//5. ����1ѭ��4��{2,3,4,},{2,3},{2,4}{2},��ԭ����{3��4}��{ 3}��{ 4}��{}���ط���0
	//6.����0ѭ��8��Ȼ���ټ���ԭ��8���Ӽ��� ��ÿ�����ص�arraylist�ﶼ����1 Ȼ���ԭ����8���Ӽ��ģ�
//{1,2,3,4,}{1,2,3}{1,2,4}{1,3,4}{1,2}{1,3}{1,4}{1}�ټ���	{2,3,4,},{2,3},{2,4},{2},{3��4}��{ 3}��{ 4}��{} һ��16����ȷ
//                          |                                                      |
//	                        |                                                      |
//	-----��Щ��foreachѭ����ӵ�moresubsets--------------|||--------��Щ���ϲ㷵�ص�ԭ����allsubsets---------
	//��󷵻�moresubesets.add(mroesubsets)
	
//	���������������else��ɵ����飬���Ǳ���ԭ���Ĳ㷵������ÿ���Ӽ�����add���ϲ㷵������ÿ���Ӽ��ӵ�ǰset.get(index)���������Ӽ���
//	 �ٷ�����һ�㡣�����˵ݹ��˼��
//	

//	
	// index��set���±꣬��Ȼ�Ǵ�0��ʼ��
	public static ArrayList<ArrayList<Integer>> getSubSets(
			ArrayList<Integer> set, int index) {
		// �Ȱ�������ݽṹ������ ��������װ���е��Ӽ����Ӽ�Ҳ�������ɶ��Ԫ�ص� ����ArrayList<ArrayList<Integer>>��
		ArrayList<ArrayList<Integer>> allsubsets;
		// �±굽2��arraylistʵ������size=3�����Ե�ǰ���Ѿ���0������2�ˣ�2+1=3�ˣ�����set�Ѿ�ȫ�������ˣ���ʱ����һ���ռ����¡�
		 //Ȼ��ֱ������return ��return  allsubsets  ����һ���ռ�
		if (set.size() == index) {
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>()); // add һ���ռ�
		} else {// ��������index�±���2���ݹ���õ�2���ˣ�,��ʱ���ȵ�(set,3)
			allsubsets = getSubSets(set, index + 1); 
			//allsubsets������֮ǰ�������ص������Ӽ�						
			int current = set.get(index);// Ȼ�����Ȱ�set[2] ��ֵ��current=3
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();// Ȼ�ֶ���һ���Ӽ�
			for (ArrayList<Integer> subset : allsubsets) {// ��ע�⣬������loop������allsubsets
														 // ���ǵݹ���õ���Щ�������ص���Щ�Ӽ����ǡ�,ÿ��foreach each eachһ���Ӽ�
				                                         //��ʱ�������ǿռ���3�������ģ�
				ArrayList<Integer> newsubset = new ArrayList<Integer>();// �½�һ��arraylist,��Ŵ������Ӽ�
				newsubset.addAll(subset); //newsubset.addAll ��֮ǰ�������ĵĿռ��ӵ�newsubset���ˣ�
				//��ע��addAll �ǰ�һ���Ӽ�Integer�����ӵ�����µ�newsubset ����ռ���ʲô��û�м��ϣ�
				newsubset.add(current);   //��3��ʱҲ�ӵ����newsubset��
				moresubsets.add(newsubset);//Ȼ����������3�Ϳռ���arraylist�ӵ�moresubsets�� Ȼ��������ѭ��
				//ps��moresubsets�� ArrayList<ArrayList<Integer>>
			}
			allsubsets.addAll(moresubsets);//ѭ�������� ���ظ���һ��ݹ�ģ�add ALL �ӵ����Ӽ��ǣ�����arraylist��
		
		}

		return allsubsets;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
