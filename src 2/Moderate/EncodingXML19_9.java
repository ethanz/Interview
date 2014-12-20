package Moderate;
//详见  http://blog.csdn.net/xiangfeineu/article/details/11875893
import javax.swing.text.html.HTML.Attribute;
import javax.xml.bind.Element;

//XML是一门很繁琐的标记语言 我们如果提前有一个编译好的表，按照一定逻辑把XML标签和int对应起来
//会容易许多  比如：
//family -> 1， person ->2, firstName ->3, LastName -> 4, state -> 5).
//<family lastName="McDowell" state="CA">
//<person firstName="Gayle">Some Message</person>
//</family>
//Becomes:
//1 4 McDowell 5 CA 0 2 3 Gayle 0 Some Message 0 0

public class EncodingXML19_9 {
//所以标签和int里有对应的，先对应起来，标签开始和结束是0,一般属性的值和要在页面上显示的东西就保留。
//	
	//这题我觉得不会考吧。。。以后有时间再看
	
	
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
