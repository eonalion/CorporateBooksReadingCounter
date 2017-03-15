package com.epam.library.domain;

/**
 *
 */
public class Book {
    private String brief;
    private String title;
    private int publishYear;
    private String author;

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("brief='").append(brief).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", publishYear=").append(publishYear);
        sb.append(", author='").append(author).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
