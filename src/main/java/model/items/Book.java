package model.items;

/**
 * Book models a Book, yes this is kinda obvious, I know
 * @author Dominik Martin Glogowski
 */
public class Book extends Item{
    private String author;
    private String topic;

    /**
     * Basic ctor
     * @param name
     * @param author
     * @param topic
     */
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
