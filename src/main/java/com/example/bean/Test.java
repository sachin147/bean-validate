package com.example.bean;


import com.example.constraint.ValidName;
import org.apache.commons.lang3.StringUtils;

class User {

    private Long id;
    private String familyName;
    @ValidName(value = "@userService.getName(#this.id)")
    private String givenName;
    private String email;
    private String nickName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}

public class Test {
    public static void main(String args[]) {
        User user = new User();
        user.setFamilyName("Sachin");
        user.setGivenName("Tiwari");
        user.setNickName("+91134534646");
        if(StringUtils.isNotBlank(user.getEmail()) & StringUtils.isNotBlank(user.getNickName())) {
            user.setNickName(user.getNickName());
        } else if(StringUtils.isNotBlank(user.getFamilyName())  & StringUtils.isNotBlank(user.getGivenName())) {
            user.setNickName(new StringBuilder().append(user.getGivenName()).append(" ").append(user.getFamilyName()).toString());
        } else {
            user.setNickName("NA");
        }
        System.out.println(user.getNickName());
    }
}

