package com.lyl.pojo;

public class ZjjzCnapsBankinfo {
    private Long id;

    private String bankno;

    private String status;

    private String bankclscode;

    private String citycode;

    private String bankname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankno() {
        return bankno;
    }

    public void setBankno(String bankno) {
        this.bankno = bankno == null ? null : bankno.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getBankclscode() {
        return bankclscode;
    }

    public void setBankclscode(String bankclscode) {
        this.bankclscode = bankclscode == null ? null : bankclscode.trim();
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname == null ? null : bankname.trim();
    }
}