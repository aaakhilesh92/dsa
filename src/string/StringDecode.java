package string;

import java.util.ArrayList;
import java.util.List;

public class StringDecode {

    public static void main(String[] args) {
        int row = 2;
        String str = "hlowrd_el_ol";
        // int row = 3;
        // String str = "mnes__ya_____mi";
        int column = str.length() / row;
        if (str.length() % row != 0) {
            column++;
        }

        char[][] arr = new char[row][column];
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                char c = str.charAt(index++);
                if (c == '_') {
                } else {
                    arr[i][j] = c;
                }
            }
        }
        System.out.println();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < column; i++) {
            int r = 0;
            int c = i;
            while (r < row) {
                if (c < column) {
                    char ch = arr[r][c];
                    if (ch != '\u0000') {
                        sb.append(ch);
                    } else {
                        sb.append(' ');
                    }
                    c++;
                } else {
                    break;
                }
                r++;
            }
        }
        System.out.println(sb.toString());
    }
}
