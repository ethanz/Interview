package sortingAndSearching;

//If you have a 2 GB file with one string per line, which sorting algorithm would you use to sort the file and why?
//如果你有个2GB的文件，其中每一行是一个字符串，你会使用哪种算法来排序，为什么？
public class Sort2GB9_4 {
//官说到2GB文件的时候，他其实就是在暗示你， 他并不希望一次性把所有的数据都载入内存。
//这样子的话，我们要怎么做呢？ 我们每次就将部分数据载入内存就好了。
//假设有10MB内存可以用,那我们可以把2000MB分成200分 这样每份就是10MB
//然后以普通的内部sort的 O(nlogn)的方法 都sort好这200份小块

	//然后我们采用N路并归的思想N-way merge (本质是mergesort )
	//我们不是有200块sort好的小块么
	//每次peek那200块的最前面的那个String,谁最小，谁就“剪切”到新文件里
	//然后再比一次这200块，继续谁最小，谁剪切到新文件里。以此类推后新文件就完全sort好了。
	
}//这整个方法叫external sort
