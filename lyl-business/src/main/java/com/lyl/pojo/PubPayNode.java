package com.lyl.pojo;

public class PubPayNode {
    private Long id;

    private String nodeNodecode;

    private String nodeNodename;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNodeNodecode() {
        return nodeNodecode;
    }

    public void setNodeNodecode(String nodeNodecode) {
        this.nodeNodecode = nodeNodecode == null ? null : nodeNodecode.trim();
    }

    public String getNodeNodename() {
        return nodeNodename;
    }

    public void setNodeNodename(String nodeNodename) {
        this.nodeNodename = nodeNodename == null ? null : nodeNodename.trim();
    }
}