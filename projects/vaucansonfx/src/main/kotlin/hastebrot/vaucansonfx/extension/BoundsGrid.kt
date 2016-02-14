package hastebrot.vaucansonfx.extension

import javafx.geometry.Bounds

fun Bounds.toBoundsGrid(columns: Int, rows: Int) = BoundsGrid(this, columns, rows)

/**
 * Bounds subdivided into a grid.
 *
 * @property bounds Bounds to subdivide.
 * @property columns Number of columns.
 * @property rows Number of rows.
 * @constructor Creates a new grid.
 */
class BoundsGrid(val bounds: Bounds, val columns: Int, val rows: Int) {

    /**
     * Returns a cell within the grid.
     *
     * @param column Column within the grid.
     * @param row Row within the grid.
     * @return Bounds of the cell.
     */
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
