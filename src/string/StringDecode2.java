package string;

public class StringDecode2 {

    public static void main(String[] args) {
        int row = 2;
        String str = "hlowrd_el_ol";
        //String str = "mnes__ya_____mi";
        System.out.println(str.length());
        int column = str.length() / row;
        if (str.length() % row != 0) {
            column++;
        }

        System.out.println(column);
        int n = row * column;
        char[] arr = new char[n];
        int ii = 0;
        for (char c : str.toCharArray()) {
            if (c == '_') {
                ii++;
                continue;
            } else {
                arr[ii] = c;
                ii++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < column;) {
            char ch = arr[i];
            int cc = 0;
            if (ch != '\u0000') {
                sb.append(ch);
            } else {
                sb.append(' ');
            }
            int r = 1;
            //while(r<row) {
                
            //}
            int nextCharI = i + column + 1;
            if (nextCharI < n) {
                char ch2 = arr[nextCharI];
                if (ch2 != '\u0000') {
                    sb.append(ch2);
                } else {
                    sb.append(' ');
                }
            }
            i++;
        }
        System.out.println(sb.toString());
    }

}
