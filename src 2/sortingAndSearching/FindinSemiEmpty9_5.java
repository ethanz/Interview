package sortingAndSearching;

import javax.naming.directory.SearchControls;

//Given a sorted array of strings which is interspersed with empty strings, 
//write a method to find the location of a given string.
//Example: find ��ball�� in [��at��, ����, ����, ����, ��ball��, ����, ����, ��car��, ����, ����, ��dad��, ����, ����] will return 4
//Example: find ��ballcar�� in [��at��, ����, ����, ����, ����, ��ball��, ��car��, ����, ����, ��dad��, ����, ����] will return -1
//��һ���Ѿ�sort�õ�String[],��������������String��������

//Ϊʲô���Թ�Ҫ����sorted arrayȻ�����������أ� �㿴��ʲô����û��
//û�� ������ʾ����binary search,��Ϊbinary searchֻ��������õ�������ſ�����
//������Ϊ����������String,������Ҫ��binary search�ԼӸĶ���ǰ������������������ǵ��ѵ�L R MidΪ�յ�ʱ�� �Զ�������
//�Ƶ����ǿյ�Ϊֹ��

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
		while(first<=last){//������while first<=Last ��ѭ��������bst ������recursive,��Ȼ���ַ���������
			
			//��֤last���ǿգ������Ծ���first�ĺ���
			while(first<=last&&str[last]==""){//������Ҫ֮����������Щ��string
				--last;
			}
			if(first>last){return -1;}
			int mid = (first+last)>>1;   //>>1��λ���� �������ұ���һλ ��Ϊ�Ƕ����������൱��/2
		                                 //���Ǳ�ֱ��д(first+last)/2 Ҫ��
			
			while(str[mid]==""&&mid<last){//������Ҫ֮����������Щ��string
				++mid;
			}
			int compare=str[mid].compareTo(key);
			if(compare==0){return mid;}
			if(compare<0){//mid С key�ں���
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
