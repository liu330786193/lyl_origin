package com.lyl.response;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

/**
 * 
 * @author xk
 * 响应
 */
public class Response {

    private static final String OK = "ok";

    private static final String ERROR = "error";

    @JsonProperty("code")
    @JsonSerialize(include = Inclusion.NON_NULL)
    private Integer code;

    @JsonProperty("description")
    @JsonSerialize(include = Inclusion.NON_NULL)
    private String description ;

    @JsonProperty("result")
    @JsonSerialize(include  = Inclusion.NON_NULL)
    private Object  result ;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Response() {
        super();
    }

    public Response(Integer code) {
        this.code = code;
    }

    public Response(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Response(Integer code, String description, Object result) {
        this.code = code;
        this.description = description;
        this.result = result;
    }

    public static Response ok(Object result){
        return new Response(0, OK, result);
    }

    public static Response okNoResult(){
        return new Response(0, OK);
    }

    public static Response errorNoResult(){
        return new Response(1, ERROR);
    }

    public static Response errorWithDesc(String msg){
        return new Response(1, msg);
    }

    public static Response error(Object result){
        return new Response(1, ERROR, result);
    }

}
