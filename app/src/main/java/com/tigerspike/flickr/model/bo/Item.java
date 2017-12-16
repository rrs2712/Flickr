package com.tigerspike.flickr.model.bo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tigerspike.flickr.utils.DefaultValues;

public class Item {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("media")
    @Expose
    private Media media;
    @SerializedName("date_taken")
    @Expose
    private String dateTaken;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("published")
    @Expose
    private String published;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("author_id")
    @Expose
    private String authorId;
    @SerializedName("tags")
    @Expose
    private String tags;

    /**
     * No args constructor for use in serialization
     */
    public Item() {
    }

    /**
     * @param tags
     * @param author
     * @param dateTaken
     * @param title
     * @param description
     * @param link
     * @param published
     * @param media
     * @param authorId
     */
    public Item(String title, String link, Media media, String dateTaken, String description, String published, String author, String authorId, String tags) {
        super();
        this.title = title;
        this.link = link;
        this.media = media;
        this.dateTaken = dateTaken;
        this.description = description;
        this.published = published;
        this.author = author;
        this.authorId = authorId;
        this.tags = tags;
    }

    public String getTitle() {
        return (title.trim() == "") ? DefaultValues.ITEM_TITLE : title.trim();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public String getDateTaken() {
        return (dateTaken.trim() == "") ? DefaultValues.ITEM_DATE_TAKEN : dateTaken.trim();
    }

    public void setDateTaken(String dateTaken) {
        this.dateTaken = dateTaken;
    }

    public String getDescription() {
        return (description.trim() == "") ? DefaultValues.ITEM_DESCRIPTION : description.trim();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", media=" + media +
                ", dateTaken='" + dateTaken + '\'' +
                ", description='" + description + '\'' +
                ", published='" + published + '\'' +
                ", author='" + author + '\'' +
                ", authorId='" + authorId + '\'' +
                ", tags='" + tags + '\'' +
                '}';
    }
}
