package sortingAndSearching;

//����С�����л�Ҫ�ú����գ� ��dynamic programming

//���⻹����һ�ֽⷨ�������Ȱ�������� �ٰ��������� ������󹫹�������
//���ַ��������O(n2)
import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//ԭ��̫����������
//�����˵��޺���������˱����������������ᣬ������߶̣�
//�����Ұ�ÿ���˵���ߣ����ض����㣬�����������ܵ�����  ��
//example
//Input (ht, wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
//Output: The longest tower is length 6 and includes from top to bottom: 
//	(56, 90) (60,95) (65,100) (68,110) (70,150) (75,190) //������ĿֻҪ�������
public class PeopleTower9_7 {
	// �ҵĵ�һ��Ӧ��һ������������constrain�����򣬵�����ô���أ���֪����
	// ��ʵ����ǣ�浽��̬�滮��֪ʶ(���dynamic Programming 101)
	// �������Ȱ���һ��ָ�������������������������������м���

	// p1СΪtrue,������������

	public boolean compare(Person p1, Person p2) {
		if (p1.height == p2.height) {
			return p1.weight < p2.weight;
		} else { 
			return p1.height < p2.height;
		}

	}

	public int maxSubSequence(ArrayList<Person> p) {
		Collections.sort(p, new Comparator<Person>() {// �ڲ���д�Ƚ���sort by height first һ���Ļ���weight
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
			personweight[i] = person[i].weight;   //������Ѿ��ź��������� ��weight�������� 
		}
		int[] d = new int[personweight.length];
		int maxSubLen = 1;
		for (int i = 0; i < personweight.length; i++) { // ��ôд ѭ��2��Ҳ��O(n2)
														// �������ָ��õ����ƶ��ַ��ķ�������nlgn
														// ���google
			d[i] = 1; //������¼���� ��¼Ŀǰ��iλʱ��������������еĳ���
			for (int j = 0; j < i; j++) {// ȥ��֮ǰ�ı�,�ҵ�������СҲ�������
				// �������if��������Ҫ        
			//	Ҫ����weight�� 100��120��155��150��90      ��ô��d[0]=1| d[1]=1 d[0]=1 
				//		����d[0]+1>d[1] ��100��120 �������� ���� d[1]=d[0]+1=2 ��������  
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