package test;

public class Main {

    public static void main(String[] args) {
        String str = "  sdd./ ds../a";
        System.out.println(str.replaceAll("\\.{1,2}\\/",""));
    }
}
