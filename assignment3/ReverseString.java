package Assignment3;

public class ReverseString {
    public String reverse(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        char[] str = s.toCharArray();
        int length = s.length();
        reverseString(str, 0, length - 1);

        int last = -1;
        for (int i = 0; i <= length; i++) {
            if (i == length || str[i] == ' ') {
                if (i - last > 1) {
                    reverseString(str, last + 1, i - 1);
                }
                last = i;
            }
        }
        return new String(str);


    }
    public void reverseString(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start++] = str[end];
            str[end--] = temp;
        }
    }
    public static void main(String args[]) {
        ReverseString rs = new ReverseString();
        String s = "The sky is blue";
        System.out.println(rs.reverse(s));
    }
}
