package hastebrot.vaucansonfx.extension

import javafx.geometry.BoundingBox

fun bounds(minX: Double, minY: Double, width: Double, height: Double) =
    BoundingBox(minX, minY, width, height)
