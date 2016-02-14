package hastebrot.vaucansonfx.extension

import javafx.geometry.Point2D
import javafx.geometry.Pos
import org.junit.Test
import kotlin.test.assertEquals

class BoundsTest {

    @Test
    fun alignPoint_with_positions() {
        // given:
        val bounds = bounds(100.0, 1000.0, 200.0, 2000.0)

        // expect:
        assertEquals(Point2D(100.0, 1000.0), bounds.alignPoint(Pos.TOP_LEFT))
        assertEquals(Point2D(200.0, 1000.0), bounds.alignPoint(Pos.TOP_CENTER))
        assertEquals(Point2D(300.0, 1000.0), bounds.alignPoint(Pos.TOP_RIGHT))
        assertEquals(Point2D(100.0, 2000.0), bounds.alignPoint(Pos.CENTER_LEFT))
        assertEquals(Point2D(200.0, 2000.0), bounds.alignPoint(Pos.CENTER))
        assertEquals(Point2D(300.0, 2000.0), bounds.alignPoint(Pos.CENTER_RIGHT))
        assertEquals(Point2D(100.0, 3000.0), bounds.alignPoint(Pos.BOTTOM_LEFT))
        assertEquals(Point2D(200.0, 3000.0), bounds.alignPoint(Pos.BOTTOM_CENTER))
        assertEquals(Point2D(300.0, 3000.0), bounds.alignPoint(Pos.BOTTOM_RIGHT))
    }

    @Test
    fun alignPoint_with_positionFactors() {
        // given:
        val bounds = bounds(100.0, 1000.0, 200.0, 2000.0)

        // expect:
        assertEquals(Point2D(100.0, 1000.0), bounds.alignPoint(Point2D(0.0, 0.0)))
        assertEquals(Point2D(200.0, 1000.0), bounds.alignPoint(Point2D(0.5, 0.0)))
        assertEquals(Point2D(300.0, 1000.0), bounds.alignPoint(Point2D(1.0, 0.0)))
        assertEquals(Point2D(100.0, 2000.0), bounds.alignPoint(Point2D(0.0, 0.5)))
        assertEquals(Point2D(200.0, 2000.0), bounds.alignPoint(Point2D(0.5, 0.5)))
        assertEquals(Point2D(300.0, 2000.0), bounds.alignPoint(Point2D(1.0, 0.5)))
        assertEquals(Point2D(100.0, 3000.0), bounds.alignPoint(Point2D(0.0, 1.0)))
        assertEquals(Point2D(200.0, 3000.0), bounds.alignPoint(Point2D(0.5, 1.0)))
        assertEquals(Point2D(300.0, 3000.0), bounds.alignPoint(Point2D(1.0, 1.0)))
    }

    @Test
    fun computePositionFactors_with_positions() {
        // expect:
        assertEquals(Point2D(0.0, 0.0), computePositionFactors(Pos.TOP_LEFT))
        assertEquals(Point2D(0.5, 0.0), computePositionFactors(Pos.TOP_CENTER))
        assertEquals(Point2D(1.0, 0.0), computePositionFactors(Pos.TOP_RIGHT))
        assertEquals(Point2D(0.0, 0.5), computePositionFactors(Pos.CENTER_LEFT))
        assertEquals(Point2D(0.5, 0.5), computePositionFactors(Pos.CENTER))
        assertEquals(Point2D(1.0, 0.5), computePositionFactors(Pos.CENTER_RIGHT))
        assertEquals(Point2D(0.0, 1.0), computePositionFactors(Pos.BOTTOM_LEFT))
        assertEquals(Point2D(0.5, 1.0), computePositionFactors(Pos.BOTTOM_CENTER))
        assertEquals(Point2D(1.0, 1.0), computePositionFactors(Pos.BOTTOM_RIGHT))
    }

}
