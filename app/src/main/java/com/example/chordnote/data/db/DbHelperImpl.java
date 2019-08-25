package com.example.chordnote.data.db;


import android.database.sqlite.SQLiteDatabase;

import com.example.chordnote.data.db.model.DaoMaster;
import com.example.chordnote.data.db.model.DaoSession;
import com.example.chordnote.data.db.model.User;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DbHelperImpl implements DbHelper {

    private DaoSession session;

    public DbHelperImpl(DbOpenHelper helper) {
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        session = daoMaster.newSession();
    }

    @Override
    public long insertUser(User user) {
        return session.insertOrReplace(user);
    }

    @Override
    public void deleteUser(User user) {
        session.delete(user);
    }

    @Override
    public List<User> getUser(String email) {
        return session.queryRaw(User.class, "where email = ?", email);
    }

}
