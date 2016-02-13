package hastebrot.vaucansonfx.extension

import javafx.geometry.BoundingBox
import javafx.geometry.Bounds

fun bounds(minX: Double, minY: Double, width: Double, height: Double) =
    BoundingBox(minX, minY, width, height)

fun Bounds.toBoundsGrid(columns: Int, rows: Int) = BoundsGrid(this, columns, rows)

class BoundsGrid(val bounds: Bounds, val columns: Int, val rows: Int) {

    fun cell(column: Int, row: Int): Bounds {
        return bounds(
            bounds.minX + ((bounds.width / columns) * column),
            bounds.minY + ((bounds.height / rows) * row),
            bounds.width / columns,
            bounds.height / rows
        )
    }

}
