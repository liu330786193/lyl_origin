package com.lyl.dao;

import com.lyl.pojo.User;

import java.util.List;

public interface UserDAO {
  User findByName(String name);

  List<User> findAllUsers();
}