package com.example.chordnote.di.component;

import com.example.chordnote.di.module.ActivityModule;
import com.example.chordnote.di.scope.PerActivity;
import com.example.chordnote.ui.booklist.BookListActivity;
import com.example.chordnote.ui.collectcomments.CollectCommentActivity;
import com.example.chordnote.ui.collectdynamics.CollectDynamicActivity;
import com.example.chordnote.ui.login.LoginActivity;
import com.example.chordnote.ui.main.MainActivity;
import com.example.chordnote.ui.main.discover.DiscoverFragment;
import com.example.chordnote.ui.main.me.MeFragment;
import com.example.chordnote.ui.main.study.StudyFragment;
import com.example.chordnote.ui.mydynamics.MyDynamicActivity;
import com.example.chordnote.ui.period.PeriodActivity;
import com.example.chordnote.ui.period.comment.CommentFragment;
import com.example.chordnote.ui.period.periodcontent.PeriodContentFragment;
import com.example.chordnote.ui.period.question.QuestionFragment;
import com.example.chordnote.ui.register.RegisterActivity;
import com.example.chordnote.ui.splash.SplashActivity;
import com.example.chordnote.ui.userinfo.UserInfoActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(LoginActivity activity);

    void inject(SplashActivity activity);

    void inject(MainActivity activity);

    void inject(RegisterActivity activity);

    void inject(MeFragment fragment);

    void inject(StudyFragment fragment);

    void inject(UserInfoActivity activity);

    void inject(DiscoverFragment fragment);

    void inject(PeriodActivity activity);

    void inject(CollectDynamicActivity activity);

    void inject(MyDynamicActivity activity);

    void inject(BookListActivity activity);

    void inject(PeriodContentFragment fragment);

    void inject(CommentFragment fragment);

    void inject(QuestionFragment fragment);

    void inject(CollectCommentActivity activity);
}
