package com.example.chordnote.data.db;

import com.example.chordnote.data.db.model.User;

import java.util.List;

public interface DbHelper {

    long insertUser(User user);

    void deleteUser(User user);

    List<User> getUser(String id);

}
