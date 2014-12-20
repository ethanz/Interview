package hard;

//����̫���� �Ҹо���̫�ῼд���룬���ǿ�����˼·�����п��ܵ�
import java.util.ArrayList;
import java.util.HashMap;

//Given a string s and an array of smaller strings T, design a method to search s for each small string in T.
//��һ���ַ���S��һ���ַ�������T(T�е��ַ���Ҫ��S�����)�����һ���㷨�� T���кܶ�Сt������t1, t2, t3, ...��Ҫ����ЩСt�ŵ�s��ȥ�ң�Ҳ������s����Сt
//����Ҫ��S���Trie��(��׺��) Ȼ��t1.����t2.����t3ȥ����

//��String �����һ��СString, �ȷ�˵ S��abcdefg t1�� bcd �����ҵ���
//�ַ����Ķ�ģʽƥ�����⡣
//һ��ʵ��Ӧ���У�Ŀ�괮String[]������һ���ı���һƪ���£�������һ������⣬ ��ģʽ������һЩ�϶̵��ַ���
//�������������bs���� Ҳ�Ǻ����ģ���ô������Ч���أ� �� ��׺�� Trie������� ǰ׺�� - ���ƵĻ���ǰ׺����

//�ȷ�˵ bananas�ĺ�׺�� bananas,ananas,nanas,anas,nas,as   ÿ����׺�������ϵ�һ��֦�⡣
//                           root
//                         b  a   n   s
//                        a  n s   a
//                       n  a     s  n  
//                      a  n s        a
//                     n  a            s
//                    a  s
//                   s
//
//
//��׺Trie�Ĳ���Ч�ʺ����㣬�����Ҫ����һ������Ϊn���ַ�����ֻ��ҪO(n)��ʱ�䣬 
//�Ƚϴ��������ַ����ĳ��ȣ��൱������ ���ǣ������ַ���S�ĺ�׺Trieȴ��ҪO(m2 )��ʱ�䣬 (mΪS�ĳ���)����O(m2 )�Ŀռ䡣

/*�ֵ���  �ǰ�String[]���һ���� �ͺ�׺���е�����
 * �ͺñ���ǰ������һ�������� ��һ�����ݽṹʵ��һ�����뷨 ÿһ�δ�һ����ĸ����ʾ5��ƴд
 *��ô�������������ݽṹ����һ��26���� ÿ��node������5��string
 *�ȷ�˵root��26���ӽڵ���abcde������������26���� 
 */

public class FindSmallInBig20_8 {
	// ��׺��
	SuffixTreeNode root = new SuffixTreeNode();

	public FindSmallInBig20_8(String s) {
		for (int i = 0; i < s.length(); i++) {
			String suffix = s.substring(i);
			root.insertStringToTree(suffix, i);
		}
	}

	public ArrayList<Integer> getIndexes(String s) {
		return root.getIndexes(s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// suffix tree ��׺�� ÿ��node��һ��char �����26������
// ��׺�����ӽڵ��Ƕ�����hashmap��
class SuffixTreeNode {
	HashMap<Character, SuffixTreeNode> children = new HashMap<Character, SuffixTreeNode>();
	char value;
	ArrayList<Integer> indexes = new ArrayList<Integer>();

	//
	public void insertStringToTree(String s, int index) {
		indexes.add(index);
		if (s != null & s.length() > 0) {
			value = s.charAt(0);
			SuffixTreeNode child = null;
			// children��hashMap �溢���ǵ�
			if (children.containsKey(value)) {
				child = children.get(value);//�����ǶԵ� ��Ϊ����ÿһ��(���26�� ������ͬ�Ĳ����ͬһ�� �ȷ�˵abcd ��abef ����ͨ��ab֮��ͬԴrecursive��ȥ)
			} else {
				child = new SuffixTreeNode();
				children.put(value, child);
			}
			String remainder = s.substring(1);
			// cat ����c���ڵ��� ����ʣ�� at ����recursive�ĵ����������
			child.insertStringToTree(remainder, index);

		}
	}

	public ArrayList<Integer> getIndexes(String s) {
		if (s == null || s.length() == 0) {
			return indexes;
		} else {
			char first = s.charAt(0);
			if (children.containsKey(first)) {
				String remainder = s.substring(1);
				return children.get(first).getIndexes(remainder);
			}
		}
		return null;
	}
}
