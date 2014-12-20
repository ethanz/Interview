package sortingAndSearching;

import javax.naming.directory.SearchControls;

//Given a sorted array of strings which is interspersed with empty strings, 
//write a method to find the location of a given string.
//Example: find “ball” in [“at”, “”, “”, “”, “ball”, “”, “”, “car”, “”, “”, “dad”, “”, “”] will return 4
//Example: find “ballcar” in [“at”, “”, “”, “”, “”, “ball”, “car”, “”, “”, “dad”, “”, “”] will return -1
//在一个已经sort好的String[],但是里面有许多空String里面搜索

//为什么面试官要给你sorted array然后让你搜索呢？ 你看出什么来了没有
//没错 这是提示你用binary search,因为binary search只有在排序好的数组里才可以用
//但是因为这里有许多空String,所以需要对binary search稍加改动，前面二分搜索正常，但是当搜到L R Mid为空的时候 自动往右移
//移到不是空的为止。

public class FindinSemiEmpty9_5 {

	public static int search(String[] str,String key){
		if(str==null||key==null){
			return -1;
		}
		if(key==""){
			for(int i=0;i<str.length;i++){
				return i;
			}
			return -1;
		}
	return  binarySearch(str, key, 0, str.length-1);
	}
	
	private static int  binarySearch(String[] str,String key,int first,int last){
		while(first<=last){//这里用while first<=Last 做循环来进行bst 而不是recursive,当然两种方法都可以
			
			//保证last不是空，而且仍旧在first的后面
			while(first<=last&&str[last]==""){//本题重要之处，无视那些空string
				--last;
			}
			if(first>last){return -1;}
			int mid = (first+last)>>1;   //>>1是位运算 等于像右边移一位 因为是二进制所以相当于/2
		                                 //但是比直接写(first+last)/2 要快
			
			while(str[mid]==""&&mid<last){//本题重要之处，无视那些空string
				++mid;
			}
			int compare=str[mid].compareTo(key);
			if(compare==0){return mid;}
			if(compare<0){//mid 小 key在后半段
				first=mid+1;
			}else{
				last=mid-1;
			}
		}
		return -1;
		
	}
	
	
	
	public static void main(String[] args) {
		String[] s = {
		        "at", "", "", "", "ball", "", "", "cat", "", "", "dad", "", ""
		    };
		
		System.out.print(search(s,"cat"));

	}

}
