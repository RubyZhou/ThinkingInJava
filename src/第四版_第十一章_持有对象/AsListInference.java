package 第四版_第十一章_持有对象;

/**
 * Function	: AsListInference.java
 * Author	: zhouyf
 * Date		: 2018年3月19日 
 * Version	: 1.0 
 * Desc		: Arrays.asList() 产生的问题
 * 				> 测试下来看好像没什么问题 :)
 * 
 * History	:
 */

import java.util.*;

class Snow {}
class Powder	extends Snow {}
class Light		extends Snow {}
class Heavy		extends Snow {}
class Crusty	extends Snow {}
class Slush		extends Snow {}


public class AsListInference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Snow> snow1 = Arrays.asList(
								new Crusty(),
								new Slush(),
								new Powder()
								);
		
		List<Snow> snow2 = Arrays.asList(new Light(), new Heavy());
		List<Snow> snow3 = new ArrayList<Snow>();
		Collections.addAll(snow3, new Light(), new Heavy());
		
	}

}
