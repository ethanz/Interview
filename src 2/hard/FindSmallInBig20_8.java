package hard;

//这题太难了 我感觉不太会考写代码，但是考解题思路还是有可能的
import java.util.ArrayList;
import java.util.HashMap;

//Given a string s and an array of smaller strings T, design a method to search s for each small string in T.
//给一个字符串S和一个字符串数组T(T中的字符串要比S短许多)，设计一个算法， T里有很多小t，比如t1, t2, t3, ...，要把这些小t放到s里去找，也就是在s里找小t
//所以要把S变成Trie树(后缀树) 然后t1.。。t2.。。t3去查找

//在String 里查找一个小String, 比方说 S是abcdefg t1是 bcd 就算找到了
//字符串的多模式匹配问题。
//一般实际应用中，目标串String[]往往是一段文本，一篇文章，甚至是一个基因库， 而模式串则是一些较短的字符串
//就算排序好了用bs来查 也是很慢的，那么如何提高效率呢？ 用 后缀树 Trie树（或叫 前缀树 - 类似的还有前缀树）

//比方说 bananas的后缀树 bananas,ananas,nanas,anas,nas,as   每个后缀都是树上的一条枝桠。
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
//后缀Trie的查找效率很优秀，如果你要查找一个长度为n的字符串，只需要O(n)的时间， 
//比较次数就是字符串的长度，相当给力。 但是，构造字符串S的后缀Trie却需要O(m2 )的时间， (m为S的长度)，及O(m2 )的空间。

/*字典树  是吧String[]变成一个树 和后缀树有点区别
 * 就好比以前看过的一个面试题 找一个数据结构实现一个输入法 每一次打一个字母会提示5个拼写
 *那么符合条件的数据结构就是一个26叉树 每个node里面有5个string
 *比方说root的26个子节点是abcde。。。就是这26叉数 
 */

public class FindSmallInBig20_8 {
	// 后缀树
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

// suffix tree 后缀树 每个node是一个char 最多有26个子树
// 后缀树的子节点们都存在hashmap里
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
			// children是hashMap 存孩子们的
			if (children.containsKey(value)) {
				child = children.get(value);//这样是对的 因为树立每一层(最多26叉 所以相同的差就是同一个 比方说abcd 和abef 都是通过ab之后同源recursive回去)
			} else {
				child = new SuffixTreeNode();
				children.put(value, child);
			}
			String remainder = s.substring(1);
			// cat 存了c到节点里 现在剩下 at 继续recursive的调用这个方法
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
