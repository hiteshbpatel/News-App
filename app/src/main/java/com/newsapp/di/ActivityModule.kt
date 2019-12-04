package com.newsapp.di

import com.newsapp.ui.newslist.NewsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    // News
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): NewsActivity

}
