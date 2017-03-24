package com.epam.library.entity;

import java.util.Objects;

/**
 *
 */
public class Book implements IDatabaseEntity {
    private int id;
    private String title;
    private String author;
    private String brief;
    private int publishYear;

    public Book() {
    }

    public Book(String title, String author, String brief, int publishYear) {
        this.title = title;
        this.author = author;
        this.brief = brief;
        this.publishYear = publishYear;
    }

    public Book(int id, String title, String author, String brief, int publishYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.brief = brief;
        this.publishYear = publishYear;
    }

    public Book(Book book) {
        this.id = id;
        this.title = book.title;
        this.author = book.author;
        this.brief = book.brief;
        this.publishYear = book.publishYear;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return id == book.id &&
                publishYear == book.publishYear &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(brief, book.brief);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, brief, publishYear);
    }
}
