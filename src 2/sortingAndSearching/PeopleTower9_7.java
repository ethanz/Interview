package sortingAndSearching;

//求最小子序列还要好好掌握！ 见dynamic programming

//本题还有另一种解法，就是先按身高排序 再按体重排序 再求最大公共子序列
//这种方法最好是O(n2)
import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//原文太长不复制了
//就是人叠罗汉，上面的人必须比下面的人体重轻，并且身高短，
//现在我把每个人的身高，体重都给你，你告诉我最多能叠几层  ？
//example
//Input (ht, wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
//Output: The longest tower is length 6 and includes from top to bottom: 
//	(56, 90) (60,95) (65,100) (68,110) (70,150) (75,190) //但是题目只要求给层数
public class PeopleTower9_7 {
	// 我的第一反应是一个有两个独立constrain的排序，但是怎么求呢，不知道。
	// 其实本体牵涉到动态规划的知识(详见dynamic Programming 101)
	// 做法是先按照一个指标排序，再在这个基础上求最长升序子序列即可

	// p1小为true,先以升高排序

	public boolean compare(Person p1, Person p2) {
		if (p1.height == p2.height) {
			return p1.weight < p2.weight;
		} else { 
			return p1.height < p2.height;
		}

	}

	public int maxSubSequence(ArrayList<Person> p) {
		Collections.sort(p, new Comparator<Person>() {// 内部类写比较器sort by height first 一样的话比weight
					public int compare(Person o1, Person o2) {
						if (o1.height < o2.height) {
							return -1;
						} else if (o1.height == o2.height) {
							return o1.weight - o2.weight;
						} else {                                  
							return 1;
						}

					}
				});
		Person[] person;
		person = (Person[]) p.toArray(new Person[p.size()]);
		int[] personweight = new int[person.length];
		for (int i = 0; i < person.length; i++) {
			personweight[i] = person[i].weight;   //在身高已经排好序的情况下 把weight放入数组 
		}
		int[] d = new int[personweight.length];
		int maxSubLen = 1;
		for (int i = 0; i < personweight.length; i++) { // 这么写 循环2次也是O(n2)
														// 但是有种更好的类似二分法的方法可以nlgn
														// 详见google
			d[i] = 1; //辅助记录素组 记录目前到i位时候最大升序子序列的长度
			for (int j = 0; j < i; j++) {// 去和之前的比,找到比他最小也是最近的
				// 下面这个if条件很重要        
			//	要检查的weight是 100，120，155，150，90      那么的d[0]=1| d[1]=1 d[0]=1 
				//		但是d[0]+1>d[1] 又100《120 符合条件 所以 d[1]=d[0]+1=2 符合条件  
				if (personweight[j] <= personweight[i] && (d[j]+1)>d[i]) {
					d[i] = d[j] + 1;  
				}
			}
			if (d[i] > maxSubLen) {
				maxSubLen = d[i];
			}
		}

		return maxSubLen;
	}
 
	public static void main(String[] args) {

		ArrayList test = new ArrayList<Person>();
		test.add(new Person(65, 100));
		test.add(new Person(333, 150));
		test.add(new Person(888, 90));
		test.add(new Person(66, 120));
		test.add(new Person(88, 155));
		test.add(new Person(99, 177));
		int answer = (new PeopleTower9_7()).maxSubSequence(test);
		System.out.print(answer);

	}
}

class Person implements Comparator<Person> {
	int height;
	int weight;

	public Person(int h, int w) {
		height = h;
		weight = w;

	}

	public int compare(Person o1, Person o2) {
		if (o1.height < o2.height) {
			return -1;
		} else if (o1.height == o2.height) {
			return o1.weight - o2.weight;
		} else {
			return 1;
		}

	}

}