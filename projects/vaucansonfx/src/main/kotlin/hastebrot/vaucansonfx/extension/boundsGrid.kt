package hastebrot.vaucansonfx.extension

import javafx.geometry.BoundingBox
import javafx.geometry.Bounds

fun bounds(minX: Double, minY: Double, width: Double, height: Double) =
    BoundingBox(minX, minY, width, height)

fun Bounds.toBoundsGrid(columns: Int, rows: Int) = BoundsGrid(this, columns, rows)

class BoundsGrid(val bounds: Bounds, val columns: Int, val rows: Int) {

    fun cell(column: Int, row: Int): Bounds {
        val width = bounds.width / columns
        val height = bounds.height / rows
        return bounds(
            bounds.minX + (width * column),
            bounds.minY + (height * row),
            width,
            height
        )
    }

}
