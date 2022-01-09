/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.framework.core.base.application

import android.util.Log
import timber.log.Timber

class TimberInitializer : AppInitializer {
    override fun init(application: CoreApplication<*>) {
        if (application.appConfig().isDev()) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(FireBaseCrashlyticsTree())
        }
    }

    internal class FireBaseCrashlyticsTree : Timber.Tree() {
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            when (priority) {
                Log.VERBOSE, Log.DEBUG -> return
            }
            /**
             * THROW FIREBASE CRASHLYTICS EXCEPTION
             * **/
            // val exception = t ?: Exception(message)
//            Firebase.crashlytics.log(message)
//            Firebase.crashlytics.setCustomKey(tag.toString(), message)
//            Firebase.crashlytics.recordException(exception)
        }
    }
}