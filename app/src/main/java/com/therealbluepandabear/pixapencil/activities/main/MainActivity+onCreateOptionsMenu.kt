package com.therealbluepandabear.pixapencil.activities.main

import android.graphics.Color
import android.view.Menu
import com.therealbluepandabear.pixapencil.R
import com.therealbluepandabear.pixapencil.extensions.changeColor

fun MainActivity.extendedOnCreateOptionsMenu(_menu: Menu?): Boolean {
    val inflater = menuInflater
    inflater.inflate(R.menu.activity_main_top_app_menu, _menu)

   _menu!!.findItem(R.id.activityMainTopAppMenu_community_item).icon.changeColor(Color.parseColor("#0099cc"))

    return true
}