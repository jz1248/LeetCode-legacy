package priv.zzy.utils;

public class StringUtil {

    public static String encode(String str, String escapingPrefix, String... escapingStrings) {
        if (str == null) return null;
        if (str.equals("")) return "";

        StringBuilder sb = new StringBuilder();

        int index;
        int lastIndex = 0;

        for (String escapingStr: escapingStrings) {
            while ((index = str.indexOf(escapingStr, lastIndex)) != -1) {
                sb.append(str.substring(lastIndex, index));
                sb.append(escapingPrefix);
                sb.append(escapingStr);
                lastIndex = index + escapingStr.length();
            }
            sb.append(str.substring(lastIndex));
            str = sb.toString();
            sb.setLength(0);
            lastIndex = 0;
        }

        return str;
    }
}
