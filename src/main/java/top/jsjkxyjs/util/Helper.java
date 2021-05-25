package top.jsjkxyjs.util;

import java.util.List;

public class Helper {
	public boolean timeAdd(List<String> list, int[] classCode) {
		int[] classCodeTemp = new int[10];
		for (String tem : list) {
			char[] temArr = tem.toCharArray();
			for (int index = 0; index < temArr.length; index++) {
				classCodeTemp[temArr[index] - '0']++;
			}
		}
		for (int n : classCode)
			for (int index = 0; index < classCodeTemp.length; index++)
				if (n == index && classCodeTemp[index] > 0) {
					return false;
				}
		return true;
	}
}
