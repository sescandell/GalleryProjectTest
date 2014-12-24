package org.sescandell.galleryproject.Model;

public class Picture {

    protected String Name;
    protected String SourceUrl;

    public Picture(String name) {
        Name = name;
        SourceUrl = "http://lorempixel.com/1024/768/abstract/?v=" + name;
    }

    public String getName() {
        return Name;
    }

    public String getSourceUrl() {
        return SourceUrl;
    }

}
