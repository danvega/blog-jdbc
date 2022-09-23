package dev.danvega.blogjdbc.model;

import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Transient;

import java.time.LocalDateTime;

public final class Comment {

        private String name;
        private String content;
        private LocalDateTime publishedOn;
        private LocalDateTime updatedOn;
        @Transient
        Post post;

        public Comment(String name, String content) {
                this(name, content, LocalDateTime.now(), LocalDateTime.now());
        }

        @PersistenceCreator
        public Comment(String name, String content, LocalDateTime publishedOn, LocalDateTime updatedOn) {
                this.name = name;
                this.content = content;
                this.publishedOn = publishedOn;
                this.updatedOn = updatedOn;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getContent() {
                return content;
        }

        public void setContent(String content) {
                this.content = content;
        }

        public LocalDateTime getPublishedOn() {
                return publishedOn;
        }

        public void setPublishedOn(LocalDateTime publishedOn) {
                this.publishedOn = publishedOn;
        }

        public LocalDateTime getUpdatedOn() {
                return updatedOn;
        }

        public void setUpdatedOn(LocalDateTime updatedOn) {
                this.updatedOn = updatedOn;
        }

        public void print() {
                System.out.println("I am comment by " + getName() + " on post " + post.getTitle());
        }

        @Override
        public String toString() {
                return "Comment{" +
                        "name='" + name + '\'' +
                        ", content='" + content + '\'' +
                        ", publishedOn=" + publishedOn +
                        ", updatedOn=" + updatedOn +
                        '}';
        }
}
