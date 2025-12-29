package com.business.intelligence.user.dto;

import com.business.intelligence.user.entity.RoleEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDTO {
    private Long id;
    private String name;

    public RoleDTO(RoleEntity role) {
        this.id = role.getId();
        this.name = role.getName();
    }
}