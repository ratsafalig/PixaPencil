package com.realtomjoney.pyxlmoose.listeners

import com.realtomjoney.pyxlmoose.models.Coordinates

interface CanvasFragmentListener {
    fun onPixelTapped(coordinatesTapped: Coordinates)
    fun onActionUp()
}