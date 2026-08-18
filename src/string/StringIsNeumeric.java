package string;

class StringIsNeumeric {
    public static void main(String args[]) {
        String text = " ";
        if (text.matches("[0-9]+")) {
            System.out.println("Neumeric");
        } else {
            System.out.println("Non Neumeric");
        }
    }
}