package com.example.chordnote.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity(nameInDb = "periods")
public class Period {
    @Id(autoincrement = true)
    private Long id;

    @NotNull
    @Property(nameInDb = "book_id")
    private long bookId;

    @NotNull
    @Property(nameInDb = "period_name")
    private String title;

    @Property(nameInDb = "chapter_name")
    private String chapterName;

    @ToMany(referencedJoinProperty = "periodId")
    private List<Question> questionList;

    @ToMany(referencedJoinProperty = "periodId")
    private List<Comment> commentList;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 115121895)
    private transient PeriodDao myDao;

    @Generated(hash = 2102751941)
    public Period(Long id, long bookId, @NotNull String title, String chapterName) {
        this.id = id;
        this.bookId = bookId;
        this.title = title;
        this.chapterName = chapterName;
    }

    @Generated(hash = 379344760)
    public Period() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getBookId() {
        return this.bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChapterName() {
        return this.chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 452438228)
    public List<Question> getQuestionList() {
        if (questionList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            QuestionDao targetDao = daoSession.getQuestionDao();
            List<Question> questionListNew = targetDao
                    ._queryPeriod_QuestionList(id);
            synchronized (this) {
                if (questionList == null) {
                    questionList = questionListNew;
                }
            }
        }
        return questionList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1378007343)
    public synchronized void resetQuestionList() {
        questionList = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1791684919)
    public List<Comment> getCommentList() {
        if (commentList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CommentDao targetDao = daoSession.getCommentDao();
            List<Comment> commentListNew = targetDao._queryPeriod_CommentList(id);
            synchronized (this) {
                if (commentList == null) {
                    commentList = commentListNew;
                }
            }
        }
        return commentList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1195658147)
    public synchronized void resetCommentList() {
        commentList = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 185990869)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPeriodDao() : null;
    }
}
