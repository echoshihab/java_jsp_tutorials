package com.example;

public class TestResponse
{
    private String responseTitle;
    private String responseBody;

    public TestResponse(String responseTitle, String responseBody) {
        this.responseTitle = responseTitle;
        this.responseBody = responseBody;
    }

    public String getResponseTitle() {
        return responseTitle;
    }

    public void setResponseTitle(String responseTitle) {
        this.responseTitle = responseTitle;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }




}
