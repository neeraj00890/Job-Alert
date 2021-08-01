package common.util;

import java.util.List;

public class CommonUtil {

		public static String ListToString(List<String> sourceOfList) {
			return String.join(",", sourceOfList);
		}
}
