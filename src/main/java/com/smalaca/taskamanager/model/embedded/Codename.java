package com.smalaca.taskamanager.model.embedded;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class Codename {
    private final String shortName;
    private final String fullName;
}
