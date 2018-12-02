package com.lyl.dao;

import java.util.List;

public interface PermissionDAO {
    List<String> findPermissionsByRolename(String rolename);
}