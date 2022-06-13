package com.chufan;

public class NovelPage {
    int ID;
    int ChapterID;
    String Name;
    String Url;
    String ContentUrl;
    String Text;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getChapterID() {
        return ChapterID;
    }

    public void setChapterID(int chapterID) {
        ChapterID = chapterID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUrl() {
        return Url;
    }

    @Override
    public String toString() {
        return "NovelPage{" +
                "ID=" + ID +
                ", ChapterID=" + ChapterID +
                ", Name='" + Name + '\'' +
                ", Url='" + Url + '\'' +
                ", ContentUrl='" + ContentUrl + '\'' +
                ", Text='" + Text + '\'' +
                '}';
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getContentUrl() {
        return ContentUrl;
    }

    public void setContentUrl(String contentUrl) {
        ContentUrl = contentUrl;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
