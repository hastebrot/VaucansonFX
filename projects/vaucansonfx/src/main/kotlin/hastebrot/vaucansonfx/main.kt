package hastebrot.vaucansonfx

import javafx.application.Application
import javafx.application.Platform
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
            root.scene.setOnKeyReleased {
                when (it.code) {
                    KeyCode.ESCAPE -> (root.scene.window as Stage).close()
                    else -> Unit
                }
            }
            centerOnHalfScreen(root.scene.window)
        }
    }

    fun centerOnHalfScreen(window: Window) {
        val halfScreen = Screen.getPrimary().bounds.width / 2.0
        val stageLeft = (halfScreen - window.width) / 2.0
        window.x = stageLeft
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
