package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.graphics.Rect
import android.view.View

fun Activity.hideKeyboard() {
    if (currentFocus == null) View(this) else currentFocus?.let { hideKeyboard(it) }
}

fun Activity.isKeyboardOpen(): Boolean{
    val rootView = findViewById<View>(android.R.id.content)
    val rect = Rect()
    rootView.getWindowVisibleDisplayFrame(rect)
    val heightDiff = rootView.height - rect.height()
    val err = this.dpToPx(20F)

    return heightDiff > err
}

fun Activity.isKeyboardClosed(): Boolean = !this.isKeyboardOpen()