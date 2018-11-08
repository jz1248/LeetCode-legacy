package priv.zzy.explore.medium.c01;

import priv.zzy.Solution;
import priv.zzy.utils.ListPrintUtil;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 */
public class C01T03 extends Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> dict = new HashMap<>(strs.length / 2);

        for (String s: strs) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String keyString = new String(charArr);
            if (dict.containsKey(keyString)) {
                dict.get(keyString).add(s);
            } else {
                ArrayList<String> strings = new ArrayList<>();
                strings.add(s);
                dict.put(keyString, strings);
            }
        }

        List<List<String>> result = new ArrayList<>();
        Set<String> keys = dict.keySet();
        for (String key: keys) {
            result.add(dict.get(key));
        }

        return result;
    }

    @Override
    public void run() {
        String[] words = {
                "eat", "tea", "tan", "ate", "nat", "bat"
        };
        List<List<String>> result = groupAnagrams(words);
        ListPrintUtil.print(result);
    }
}
