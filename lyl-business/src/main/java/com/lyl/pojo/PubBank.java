package com.lyl.pojo;


public class PubBank {
    private Long id;

    private String bankName;

    private Short bankCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public Short getBankCode() {
        return bankCode;
    }

    public void setBankCode(Short bankCode) {
        this.bankCode = bankCode;
    }



}