package top.jsjkxyjs.util;

import java.util.List;

public class Helper {
	public boolean timeAdd(List<String> list, int[] classCode) {
		int[] classCodeTemp = new int[13];
		for (String tem : list) {
			char[] temArr = tem.toCharArray();
			for (int index = 0; index < temArr.length; index++) {
				classCodeTemp[temArr[index] - '0']++;
			}
		}

		for (int flag : classCode)
			for (int index = 0; index < classCodeTemp.length; index++)
				if (flag == index && classCodeTemp[index] > 0) {
					return false;
				}
		return true;
	}

	public int[] parse(String str) {
		int length = str.length();
		int[] result = new int[length];
		// 依次取得字符串中的每一个字符，并将其转化为数字，放进int数组中
		for (int i = 0; i < length; i++) {
			char c = str.charAt(i);
			result[i] = Character.getNumericValue(c);
		}
		return result;
	}
}
