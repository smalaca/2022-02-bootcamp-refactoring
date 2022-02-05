package com.smalaca.taskamanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamDto {
    private Long id;
    private String name;
    private String codenameShort;
    private String codenameFull;
    private String description;
    private List<Long> userIds = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodenameShort() {
        return codenameShort;
    }

    @Deprecated
    public void setCodenameShort(String codenameShort) {
        this.codenameShort = codenameShort;
    }

    public String getCodenameFull() {
        return codenameFull;
    }

    @Deprecated
    public void setCodenameFull(String codenameFull) {
        this.codenameFull = codenameFull;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getUserIds() {
        return userIds;
    }

    public static class TeamDtoBuilder {
        public TeamDtoBuilder codename(String shortName, String fullName) {
            return codenameShort(shortName).codenameFull(fullName);
        }
    }
}
