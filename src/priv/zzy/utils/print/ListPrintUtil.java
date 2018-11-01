package priv.zzy.utils.print;

import java.util.List;

public class ListPrintUtil {

    private static final String LIST_PREFIX = "[";
    private static final String LIST_SUFFIX = "]";
    private static final String LIST_INDENT = "\t";
    private static final String LIST_SPLITTER = ", ";

    public static void print(List object) {
        print(object, 0, true);
    }

    private static void print(List object, int indent, boolean newLine) {
        if (object.size() == 0) {
            printWithIndent(LIST_PREFIX, indent);
            System.out.print(LIST_SUFFIX);
            if (newLine) {
                System.out.println();
            }
            return;
        }

        printlnWithIndent(LIST_PREFIX, indent);
        if (object.get(0) instanceof List) {
            print((List)object.get(0), indent + 1, false);
            for (int i = 1; i < object.size(); ++i) {
                System.out.println(LIST_SPLITTER);
                print((List)object.get(i), indent + 1, false);
            }
            System.out.println();
        } else {
            printWithIndent(object.get(0), indent + 1);
            for (int i = 1; i < object.size(); ++i) {
                printWithIndent(LIST_SPLITTER + object.get(i), 0);
            }
            System.out.println();
        }
        printWithIndent(LIST_SUFFIX, indent);
        if (newLine) {
            System.out.println();
        }
    }

    private static void printWithIndent(Object obj, int indent) {
        for (int i = 0; i < indent; ++i) {
            System.out.print(LIST_INDENT);
        }
        System.out.print(obj);
    }

    private static void printlnWithIndent(Object obj, int indent) {
        printWithIndent(obj, indent);
        System.out.println();
    }
}
