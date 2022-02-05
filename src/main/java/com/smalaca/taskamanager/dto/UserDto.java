package com.smalaca.taskamanager.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
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

    public static class UserDtoBuilder {
        public UserDtoBuilder phone(String prefix, String number) {
            return phonePrefix(prefix).phoneNumber(number);
        }
    }
}
