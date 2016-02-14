package hastebrot.vaucansonfx.extension

import javafx.geometry.BoundingBox
import javafx.geometry.Bounds
import javafx.geometry.HPos
import javafx.geometry.Point2D
import javafx.geometry.Pos
import javafx.geometry.VPos

fun bounds(minX: Double, minY: Double, width: Double, height: Double): Bounds =
    BoundingBox(minX, minY, width, height)

fun Bounds.alignPoint(position: Pos) =
    alignPoint(computePositionFactors(position))

fun Bounds.alignPoint(positionFactors: Point2D): Point2D {
    val pointX = lerp(minX, maxX, positionFactors.x)
    val pointY = lerp(minY, maxY, positionFactors.y)
    return Point2D(pointX, pointY)
}

fun Bounds.alignBounds(bounds: Bounds, position: Pos) {

}

internal fun computePositionFactors(position: Pos): Point2D {
    val positionX = computePositionX(position.hpos)
    val positionY = computePositionY(position.vpos)
    return Point2D(positionX, positionY)
}

private fun lerp(start: Double, end: Double, factor: Double) =
    start + ((end - start) * factor)

private fun computePositionX(hPos: HPos) = when (hPos) {
    HPos.LEFT -> 0.0
    HPos.CENTER -> 0.5
    HPos.RIGHT -> 1.0
    else -> throw AssertionError("Unhandled horizontal position")
}

private fun computePositionY(vPos: VPos) = when (vPos) {
    VPos.TOP -> 0.0
    VPos.BASELINE, VPos.CENTER -> 0.5
    VPos.BOTTOM -> 1.0
    else -> throw AssertionError("Unhandled vertical position")
}
