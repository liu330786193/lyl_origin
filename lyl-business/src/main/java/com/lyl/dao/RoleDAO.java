package com.lyl.dao;

import java.util.List;

public interface RoleDAO {
    List<String> findRolesByUsername(String username);
}