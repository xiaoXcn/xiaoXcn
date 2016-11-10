package common.utils;
/**
 * 字符串工具类
 * @author zmx
 *
 */
public class StringUtils {

	/**
	 * 判断参数是否为null或""或"  "等..
	 * 如果是则返回true;不是则返回false
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str){
		if(null==str||str.trim().length()<1){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断参数是否为null或""或"  "等..
	 * 如果是则返回false;不是则返回true
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str){
		return !isBlank(str);
	}
}
