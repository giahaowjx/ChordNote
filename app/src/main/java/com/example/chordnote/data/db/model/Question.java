package com.example.chordnote.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;


@Entity(nameInDb = "questions")
public class Question {

    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "period_id")
    private long periodId;

    @Property(nameInDb = "question_text")
    private String questionText;

    @Property(nameInDb = "question_img_url")
    private String imgUrl;

    @ToMany(referencedJoinProperty = "questionId")
    private List<Option> optionList;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 891254763)
    private transient QuestionDao myDao;

    @Generated(hash = 1377708210)
    public Question(Long id, long periodId, String questionText, String imgUrl) {
        this.id = id;
        this.periodId = periodId;
        this.questionText = questionText;
        this.imgUrl = imgUrl;
    }

    @Generated(hash = 1868476517)
    public Question() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getPeriodId() {
        return this.periodId;
    }

    public void setPeriodId(long periodId) {
        this.periodId = periodId;
    }

    public String getQuestionText() {
        return this.questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1773152342)
    public List<Option> getOptionList() {
        if (optionList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            OptionDao targetDao = daoSession.getOptionDao();
            List<Option> optionListNew = targetDao._queryQuestion_OptionList(id);
            synchronized (this) {
                if (optionList == null) {
                    optionList = optionListNew;
                }
            }
        }
        return optionList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1801972530)
    public synchronized void resetOptionList() {
        optionList = null;
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
    @Generated(hash = 754833738)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getQuestionDao() : null;
    }
}
