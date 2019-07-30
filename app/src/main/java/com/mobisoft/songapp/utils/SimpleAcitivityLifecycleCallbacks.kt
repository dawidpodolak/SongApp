package com.mobisoft.songapp.utils

import android.app.Activity
import android.app.Application
import android.os.Bundle

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
interface SimpleActivityLifecycleCallbacks : Application.ActivityLifecycleCallbacks {
    override fun onActivityPaused(activity: Activity) = Unit

    override fun onActivityStarted(activity: Activity) = Unit

    override fun onActivityDestroyed(activity: Activity) = Unit

    override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle) = Unit

    override fun onActivityStopped(activity: Activity) = Unit

    override fun onActivityCreated(activity: Activity, bundle: Bundle?) = Unit

    override fun onActivityResumed(activity: Activity) = Unit
}