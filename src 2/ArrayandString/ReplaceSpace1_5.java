package ArrayandString;

public class ReplaceSpace1_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String s ="kjlkad   laksjl  lkjlkjl";

System.out.print(replace(s));
		
		
	}
//If we don't use the buffer.
	
	public static String replace (String s){
		int spaceCount=0;
		char[] ary = s.toCharArray();
		for(int i=0;i<ary.length;i++){
			if(ary[i]==' '){
				
				spaceCount++;
			
			}
		}
		//�ܲ�д��ѭ����Ͳ�ж��ѭ����
		int newLength=ary.length+spaceCount*2;
		char[] aryNew= new char[newLength];
		//ע�� length-1
		//��ô�������±�ͬʱ��
		for(int j=ary.length-1;j>=0;j--){
			if(ary[j]==' '){
				aryNew[newLength-1]='0';
				aryNew[newLength-2]='2';
				aryNew[newLength-3]='%';
					newLength=newLength-3;
					
			}
			else{aryNew[newLength-1]=ary[j];
			newLength--;
				
				
			}			
	
		}
		String d=new String(aryNew);
		return d;	
	}
	
	
	
}
