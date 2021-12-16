package com.example.bin.tools

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.widget.TextView
import android.widget.Toast
import com.example.bin.R

fun Context.showDialog(
    cancelable: Boolean = false,
    cancelableTouchOutside: Boolean = false,
    builderFunction: AlertDialog.Builder.() -> Any
): Dialog {
    val builder = AlertDialog.Builder(this)
    builder.builderFunction()
    val dialog = builder.create()

    dialog.setCancelable(cancelable)
    dialog.setCanceledOnTouchOutside(cancelableTouchOutside)
    dialog.show()
    return dialog
}

fun Context.showToast(title: String? = null, text: String?) {
    val inflater = LayoutInflater.from(this)
    val layout: View = inflater.inflate(R.layout.custom_toast, null)
    val mTitle: TextView = layout.findViewById(R.id.title)
    val mText: TextView = layout.findViewById(R.id.text)
    if (title.isNullOrEmpty()) mTitle.visibility = GONE
    mText.text = text
    mTitle.text = title
    with(Toast(this)) {
        setGravity(Gravity.BOTTOM, 0,28)
        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}

fun AlertDialog.Builder.positiveButton(text: String = "OK", handleClick: (i: Int) -> Unit = {}) {
    this.setPositiveButton(text) { _, i -> handleClick(i) }
}

fun AlertDialog.Builder.negativeButton(text: String = "CANCEL", handleClick: (i: Int) -> Unit = {}) {
    this.setNegativeButton(text) { _, i -> handleClick(i) }
}

fun AlertDialog.Builder.neutralButton(text: String, handleClick: (i: Int) -> Unit = {}) {
    this.setNeutralButton(text) { _, i -> handleClick(i) }
}
