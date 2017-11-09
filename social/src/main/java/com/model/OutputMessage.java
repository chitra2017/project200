package com.model;

public class OutputMessage {

    private String from;
    private String to;
    private String text;
  

    public OutputMessage(final String from, String to, final String text) {

        this.from = from;
        this.to=to;
        this.text = text;
        
       
    }

    public String getText() {
        return text;
    }

  

    public String getFrom() {
        return from;
    }

	public String getTo() {
		return to;
	}

	
}