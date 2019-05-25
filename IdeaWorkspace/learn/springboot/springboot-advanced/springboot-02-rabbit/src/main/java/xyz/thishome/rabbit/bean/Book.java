package xyz.thishome.rabbit.bean;

public class Book {

    private String name;
    private String auther;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", auther='" + auther + '\'' +
                '}';
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public Book(String name, String auther) {
        this.name = name;
        this.auther = auther;
    }
}
