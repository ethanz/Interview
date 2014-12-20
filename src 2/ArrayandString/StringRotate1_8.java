package ArrayandString;
//这题的提议是检测 string是不是rotation. eg：cat rotation之后就是 atc
//apple rotation之后就是pleap( ple ap)从某个字符开始读还是有顺序的 但是ppale就不是rotation
//然后你有一个现成的isstring 方法去看他是不是某个sting的substring
public class StringRotate1_8 {

	//check s2 是不是s1的rotation
public static boolean isRotate	(String s1,String s2){
	//check legit
	if(s1.length()==s2.length()||s1.length()>0&&s2.length()>0){
		
		String s1s1 = s1 + s1;  
	//eg: apple+apple =appleapple 所以如果s2是s1的rotation，那么肯定是2个s1的substring	
		
		return isSubstring(s1s1, s2);//return东西了 方法下面就不执行了
	}
	
	
	return false;
	
	
	
	
	
}	
	
	private static boolean isSubstring(String s1,String s2){
		//this is suppose to given
	return true;
	}
}
