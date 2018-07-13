package com.howtographql.hackernews;
public class Link {
    
    private final String url;
    private final String description;
    private final String id;

    public Link(String id, String url, String description) {
        this.url = url;
        this.description = description;
        this.id = id;
    }
    
    public Link(String url, String description){
    	this(null,url,description);
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }
    
    public String getId() {
    	return id;
    }
}