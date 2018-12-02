package com.lyl.output;

/**
 * Created by lyl on 2016/9/11.
 */
public class Result {
    private String code;
    private String description;
    private Object result;

    public Result() {
    }

    public Result(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public Result(String code, String description, Object result) {
        this.code = code;
        this.description = description;
        this.result = result;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getResult() {
        return this.result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
