package priv.zzy;

import java.lang.reflect.Method;
import java.util.List;

public class Solution {

    public void run() {
        System.err.println("\"run\" method needs to be implemented!");
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void printCase(Object input, Object output, Object correctOutput) {
        String str = "\nInput:\t\t" + input + "\t(" + input.getClass() + ")" +
                "\nOutput:\t\t" + output + "\t(" + input.getClass() + ")" +
                "\nStd Output:\t" + correctOutput + "\t(" + input.getClass() + ")";
        System.out.println(str);
    }

    public static void test(Object[] inputs, Object[] outputs, Object target, String methodName, Class... classes) {
        try {
            Method method = target.getClass().getMethod(methodName, classes);
            for (int i = 0; i < inputs.length; ++i) {
                printCase(inputs[i], method.invoke(target, inputs[i]), outputs[i]);
            }
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }

    }
}
