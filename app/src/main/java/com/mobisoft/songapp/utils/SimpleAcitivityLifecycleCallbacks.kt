package com.mobisoft.songapp.utils

import android.app.Activity
import android.app.Application
import android.os.Bundle

/**
 * @author Dawid Podolak
 * Created at 2019-07-29
 */
interface SimpleActivityLifecycleCallbacks : Application.ActivityLifecycleCallbacks {
    override fun onActivityPaused(activit: Activity) = Unit

    override fun onActivityStarted(activit: Activity) = Unit

    override fun onActivityDestroyed(activit: Activity) = Unit

    override fun onActivitySaveInstanceState(activit: Activity, bundle: Bundle) = Unit

    override fun onActivityStopped(activit: Activity) = Unit

    override fun onActivityCreated(activit: Activity, bundle: Bundle?) = Unit

    override fun onActivityResumed(activit: Activity) = Unit
}