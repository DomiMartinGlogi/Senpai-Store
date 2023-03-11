package model.items;

public class Book extends Item{
    private String author;
    private String topic;

    public Book(String name, String author, String topic) {
        super(name);
        this.author = author;
        this.topic = topic;
    }

    public String getAuthor() {
        return author;
    }

    public String getTopic() {
        return topic;
    }
}
