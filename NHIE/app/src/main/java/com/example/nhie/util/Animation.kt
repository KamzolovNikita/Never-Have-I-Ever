package com.example.nhie.util

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Color
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.res.ResourcesCompat
import com.example.nhie.R

object Animation {
    fun animatedTextClick(text: TextView) {
        val animator = ObjectAnimator.ofFloat(text, View.ALPHA, 0.2f, 0.4f, 0.6f, 0.8f, 1f)
        animator.duration = 360
        animator.interpolator = AccelerateDecelerateInterpolator()
        animator.start()
    }

    fun animatedButtonClick(button: AppCompatButton) {
        val anim = ValueAnimator()
        anim.setIntValues(
            ResourcesCompat.getColor(
                button.resources,
                R.color.semi_transparent_white,
                null
            ), Color.WHITE
        )
        anim.setEvaluator(ArgbEvaluator())
        anim.addUpdateListener { valueAnimator ->
            button.setTextColor(
                (valueAnimator.animatedValue as Int)
            )
        }
        anim.duration = 250
        anim.start()
    }
}