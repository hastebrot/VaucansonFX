package hastebrot.vaucansonfx.extension

import org.junit.Test
import kotlin.test.assertEquals

class BoundsGridTest {

    @Test
    fun `cell()`() {
        // given:
        val bounds = bounds(0.0, 10.0, 200.0, 300.0)
        val boundsGrid = bounds.toBoundsGrid(10, 10)

        // expect:
        assertEquals(bounds(  0.0,  10.0, 20.0, 30.0), boundsGrid.cell(0, 0))
        assertEquals(bounds( 20.0,  70.0, 20.0, 30.0), boundsGrid.cell(1, 2))
        assertEquals(bounds(180.0, 280.0, 20.0, 30.0), boundsGrid.cell(9, 9))
    }

    @Test
    fun `cell() out of bounds`() {
        // given:
        val bounds = bounds(0.0, 10.0, 200.0, 300.0)
        val boundsGrid = bounds.toBoundsGrid(10, 10)

        // expect:
        assertEquals(bounds(-20.0, -20.0, 20.0, 30.0), boundsGrid.cell(-1, -1))
        assertEquals(bounds(220.0, 340.0, 20.0, 30.0), boundsGrid.cell(11, 11))
    }

}