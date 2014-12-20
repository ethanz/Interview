package recursion;

//parenthes(圆括号)
public class parentheses8_5 {

	// Implement an algorithm to print all valid
	// (e.g., properly opened and closed) combinations of n-pairs of
	// parentheses.
	// e.g. input: 3 (e.g., 3 pairs of parentheses)
	// output: ()()(), ()(()), (())(), ((())),(()())

	// 首先 先不谈代码 这道题目的基本逻辑是什么？
	// 当然是“（” 和 “）” 的数量相等，如果“（”多，只能打印“）”，反之亦然
	// 所以当 这方法被传参数5的时候 就是5个“（”和“）”
	// 但是左括号和右括号的逻辑有点不一样
	// 左：只要还有还没用完参数规定的数量 就可以插入
	// 右：有左才能有右，假设已经有了n个左，那么右的数量不能超过n

	// 这样一来，在程序中，只要还有左括号，我们就加入输出串，然后递归调用。
	// 当退出递归时，如果剩余的右括号数量比剩余的左括号数量多，我们就将右括号加入输出串。
	// 直到最后剩余的左括号和右括号都为0时，即可打印一个输出串。

	public static void printPar(int number) {
		char[] str = new char[number * 2];
		printpar(number, number, str, 0);
	}

	// 存放要打印的括号 //count表示str的数组下标，毕竟char得从左往右写啊（不然你怎么知道用了几个左括号）
	// 插了一个括号后count+1（count +1）
	private static void printpar(int l, int r, char[] str, int count) {
		if (l < 0 || r < 0) { //这里是<0不是<1  试想要是 l/r到0的时候 如果条件是<1 就return了 还怎么执行(l == 0 && r == 0)里面的打印语句呢？
			return;
		}// invalid number
		if (l == 0 && r == 0) {
			
			System.out.println(str);// 因为起始l r是一样多的，所以当l r都用光时候表示配对成功。可以打印
		} else {
			if (l > 0) {
				str[count] = '(';
				printpar(l - 1, r, str, count + 1);
			}
			if (r > l) {// 如果此时r>l, 说明str里'('用的比')'多，所以可以用')'
				str[count] = ')';
				printpar(l, r - 1, str, count + 1);

			}
		}

	}
//这题和上两题的区别是 递归调用后无需返回东西给上层 只不过上层吧半成品str一层层递归调用传参下去，直到满足l==r==0 括号都齐了 就打印
	public static void main(String[] args) {
		printPar(3);

	}

}
