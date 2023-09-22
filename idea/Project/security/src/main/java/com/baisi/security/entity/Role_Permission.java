package com.baisi.security.entity;

import lombok.Data;

@Data
public class Role_Permission {
    Integer id;
    Integer permission;
    Integer role_id;
}
