package Moderate;

import java.util.Random;

import javax.security.auth.x500.X500Principal;
//implement rand7() using rand5()
//给你一个给你一个能生成1到5随机数的函数，用它写一个函数生成1到7的随机数

//注意 本题不是随便弄一个能出1-7之间的数就好了，要等概率
//数学论证部分详见 hawstein.com/posts/19.10.html （不难）

//只要我们将Rand5 映射到一个能产生更大随机数的Randa，其中a > 7,
// 这里要注意一点的是,你映射后的Randa一定是要满足等概率生成1到a的。
// 比如 rand5()+rand5 -1 是不能 平均的生成1-9的
//不是。生成1只有一种组合： 两个Rand5()都生成1时：(1, 1)；而生成2有两种：(1, 2)和(2, 1)；生成6更多。
//所以不是随机分布而是正态分布了 
//假设Randa 能生成 1-a的随机数
//!!!所以有一个公式  a * (Randa - 1) + Randa-1 能产生更大的 而且是随机分布的随机数
//如果还不够大可以  a * (Randa^2 - 1) + Randa 
public class Random7_19_10 {

	public static int rand7() {
		while (true) {
			// num会随机分布的生产0-24
			int num = 5 * (rand5() - 1) + (rand5() - 1);
			if (num < 21) {
				// 会产生0-6 所以要
				int random = num % 7 + 1;
				return random;
			}
		}
	}

	public static int rand5(){
		Random rand =new Random();
		int i= rand.nextInt(101);
		return  i%5+1 ;
	}
	
	public static void main(String[] args) {
	for(int i=0;i<20;i++){
		System.out.println(rand7());
	}
	
	}

}
