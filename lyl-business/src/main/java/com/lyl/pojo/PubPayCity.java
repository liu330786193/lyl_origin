package com.lyl.pojo;

public class PubPayCity {
    private Long id;

    private String cityAreacode;

    private String cityAreaname;

    private String cityAreatype;

    private String cityNodecode;

    private String cityTopareacode1;

    private String cityTopareacode2;

    private String cityTopareacode3;

    private String cityOraareacode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityAreacode() {
        return cityAreacode;
    }

    public void setCityAreacode(String cityAreacode) {
        this.cityAreacode = cityAreacode == null ? null : cityAreacode.trim();
    }

    public String getCityAreaname() {
        return cityAreaname;
    }

    public void setCityAreaname(String cityAreaname) {
        this.cityAreaname = cityAreaname == null ? null : cityAreaname.trim();
    }

    public String getCityAreatype() {
        return cityAreatype;
    }

    public void setCityAreatype(String cityAreatype) {
        this.cityAreatype = cityAreatype == null ? null : cityAreatype.trim();
    }

    public String getCityNodecode() {
        return cityNodecode;
    }

    public void setCityNodecode(String cityNodecode) {
        this.cityNodecode = cityNodecode == null ? null : cityNodecode.trim();
    }

    public String getCityTopareacode1() {
        return cityTopareacode1;
    }

    public void setCityTopareacode1(String cityTopareacode1) {
        this.cityTopareacode1 = cityTopareacode1 == null ? null : cityTopareacode1.trim();
    }

    public String getCityTopareacode2() {
        return cityTopareacode2;
    }

    public void setCityTopareacode2(String cityTopareacode2) {
        this.cityTopareacode2 = cityTopareacode2 == null ? null : cityTopareacode2.trim();
    }

    public String getCityTopareacode3() {
        return cityTopareacode3;
    }

    public void setCityTopareacode3(String cityTopareacode3) {
        this.cityTopareacode3 = cityTopareacode3 == null ? null : cityTopareacode3.trim();
    }

    public String getCityOraareacode() {
        return cityOraareacode;
    }

    public void setCityOraareacode(String cityOraareacode) {
        this.cityOraareacode = cityOraareacode == null ? null : cityOraareacode.trim();
    }
}