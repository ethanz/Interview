package Moderate;
//���  http://blog.csdn.net/xiangfeineu/article/details/11875893
import javax.swing.text.html.HTML.Attribute;
import javax.xml.bind.Element;

//XML��һ�źܷ����ı������ ���������ǰ��һ������õı�����һ���߼���XML��ǩ��int��Ӧ����
//���������  ���磺
//family -> 1�� person ->2, firstName ->3, LastName -> 4, state -> 5).
//<family lastName="McDowell" state="CA">
//<person firstName="Gayle">Some Message</person>
//</family>
//Becomes:
//1 4 McDowell 5 CA 0 2 3 Gayle 0 Some Message 0 0

public class EncodingXML19_9 {
//���Ա�ǩ��int���ж�Ӧ�ģ��ȶ�Ӧ��������ǩ��ʼ�ͽ�����0,һ�����Ե�ֵ��Ҫ��ҳ������ʾ�Ķ����ͱ�����
//	
	//�����Ҿ��ò��ῼ�ɡ������Ժ���ʱ���ٿ�
	
	
//	 public static void encode(Element root, StringBuffer sb) {
//		encode(root.getNameCodeQ, sb);
//		 for (Attribute a : root.attributes) {
//		 encode(a, sb);
//		 }
//	      encode(0, sb);
//		if (root.value != null && root.value != "") {
//	 encode(root.value., sb);
//		 } else {
//		 for (Element e : root.children) {
//		 encode(6, sb);
//	 }
//		 }
//		 encode("0", sb);
//		 }
//		
//		 public static void encorie(String v, StringBuffer sb) {
//		 sb.append(v);
//		 sb.append(" ");
//		 }
//		
//		 public static void encode(Attribute attr, StringBuffer sb) {
//		 encode(attr.getTagCode(), sb);
//		encode(attr.value, sb);
//		}
//		
//		 public static String encodeToString(Element root) {
//		 StringBuffer sb = new StringBuffer();
//		 encode(root, sb);
//		 return sb.toString();
//		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
