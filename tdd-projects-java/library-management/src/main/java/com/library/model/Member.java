package com.library.model;

public class Member {
    private String name;
    private String memberId;

    // Constructors, getters, and setters
    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }
}
