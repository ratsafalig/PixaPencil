package com.therealbluepandabear.pixapencil.activities.main

import android.content.Intent
import com.therealbluepandabear.pixapencil.activities.canvas.CanvasActivity
import com.therealbluepandabear.pixapencil.database.AppData
import com.therealbluepandabear.pixapencil.models.PixelArt
import com.therealbluepandabear.pixapencil.utility.StringConstants

fun MainActivity.extendedOnCreationTapped(param: PixelArt) {
    AppData.pixelArtDB.pixelArtCreationsDao().getAllPixelArtCreations().observe(this) {
        startActivity(
            Intent(context, CanvasActivity::class.java)
                .putExtra(StringConstants.IndexExtra, it.indexOf(param))
                .putExtra(StringConstants.ProjectTitleExtra, param.title)
        )
    }
}