package com.smalaca.taskamanager.model.embedded;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class UserName {
    private final String firstName;
    private final String lastName;
}
