package hastebrot.vaucansonfx

import hastebrot.vaucansonfx.extension.alignBounds
import hastebrot.vaucansonfx.extension.toBounds
import hastebrot.vaucansonfx.extension.toBoundsGrid
import javafx.application.Application
import javafx.application.Platform
import javafx.geometry.Pos
import javafx.scene.input.KeyCode
import javafx.scene.layout.StackPane
import javafx.stage.Screen
import javafx.stage.Stage
import javafx.stage.Window
import tornadofx.App
import tornadofx.Controller
import tornadofx.View
import tornadofx.label

class Main : View() {
    override val root = StackPane()

    private val controller by inject<MainController>()

    init {
        with(root) {
            setPrefSize(500.0, 500.0)
            label("Hello World")
        }

        println(controller.foo())

        Platform.runLater {
            registerWindowCloseKey(root.scene.window)
            centerOnLeftHalfScreen(root.scene.window)
        }
    }

    fun registerWindowCloseKey(window: Window) {
        window.scene.setOnKeyReleased {
            when (it.code) {
                KeyCode.ESCAPE -> (window as Stage).close()
                else -> Unit
            }
        }
    }

    fun centerOnLeftHalfScreen(window: Window) {
        val screenBounds = Screen.getPrimary().toBounds()
        val windowBounds = window.toBounds()
        val boundsGrid = screenBounds.toBoundsGrid(2, 1)
        val newWindowBounds = boundsGrid.cell(0, 0).alignBounds(windowBounds, Pos.CENTER)
        window.x = newWindowBounds.minX
        window.y = newWindowBounds.minY
    }
}

class MainController : Controller() {
    fun foo() = "foo"
}

class MainApp : App() {
    override val primaryView = Main::class
}

fun main(args: Array<String>) {
    Application.launch(MainApp::class.java)
}
