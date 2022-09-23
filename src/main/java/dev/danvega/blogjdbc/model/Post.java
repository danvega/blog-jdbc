package dev.danvega.blogjdbc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class Post {
    @Id
    private Integer id;
    private String title;
    private String content;
    private Integer authorId;
    private LocalDateTime publishedOn;
    private LocalDateTime updatedOn;
    @Transient
    private Author author = null;
    @Transient
    private List<Comment> comments = new ArrayList<>();

    public Post(Integer id, String title, String content, Integer authorId, LocalDateTime publishedOn, LocalDateTime updatedOn) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.publishedOn = publishedOn;
        this.updatedOn = updatedOn;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public LocalDateTime getPublishedOn() {
        return publishedOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", authorId=" + authorId +
                ", publishedOn=" + publishedOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
