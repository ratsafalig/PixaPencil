package com.realtomjoney.pyxlmoose.activities.canvas

import android.graphics.drawable.ColorDrawable
import com.realtomjoney.pyxlmoose.algorithms.RectangleAlgorithm
import com.realtomjoney.pyxlmoose.models.Coordinates

fun CanvasActivity.rectangleToolOnPixelTapped(coordinatesTapped: Coordinates, hasBorder: Boolean) {

    val rectangleAlgorithmInstance: RectangleAlgorithm = if (!hasBorder) {
        RectangleAlgorithm(canvasInstance.myCanvasViewInstance.pixelGridViewBitmap, canvasInstance.myCanvasViewInstance.currentBitmapAction!!, getSelectedColor())
    } else {
        RectangleAlgorithm(canvasInstance.myCanvasViewInstance.pixelGridViewBitmap, canvasInstance.myCanvasViewInstance.currentBitmapAction!!, (binding.activityCanvasColorSecondaryView.background as ColorDrawable).color, (binding.activityCanvasColorPrimaryView.background as ColorDrawable).color)
    }

    if (!rectangleMode_hasLetGo) {
        if (!first) canvasInstance.myCanvasViewInstance.undo()
        canvasInstance.myCanvasViewInstance.bitmapActionData.add(canvasInstance.myCanvasViewInstance.currentBitmapAction!!)
        first = false
    } else {
        canvasInstance.myCanvasViewInstance.currentBitmapAction = null
        rectangleMode_hasLetGo = false
        first = true
    }

    if (rectangleOrigin == null) {
        rectangleOrigin = coordinatesTapped
    } else {
        rectangleAlgorithmInstance.compute(rectangleOrigin!!, coordinatesTapped)
    }
}