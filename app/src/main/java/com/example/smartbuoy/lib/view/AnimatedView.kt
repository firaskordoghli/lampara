package com.example.smartbuoy.lib.view

import android.animation.Animator
import android.content.Context
import com.example.smartbuoy.R

internal interface AnimatedView {

    val selectAnimator: Animator
    val deselectAnimator: Animator

    fun getItemTransitionYValue(context: Context) =
            -(context.resources?.getDimension(R.dimen.fluidBottomNavigationItemTranslationY) ?: 0f)

    fun getItemOvershootTransitionYValue(context: Context) =
            getItemTransitionYValue(context) * 11 / 10
}