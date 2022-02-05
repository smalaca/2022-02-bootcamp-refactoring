package com.smalaca.taskamanager.dto;

import lombok.Getter;

@Getter
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String phoneNumber;
    private String phonePrefix;
    private String emailAddress;
    private String teamRole;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Deprecated
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPhoneNumber(String prefix, String number) {
        phonePrefix = prefix;
        phoneNumber = number;
    }

    public void setPhonePrefix(String phonePrefix) {
        this.phonePrefix = phonePrefix;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setTeamRole(String teamRole) {
        this.teamRole = teamRole;
    }
}
