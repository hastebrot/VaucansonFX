package hastebrot.vaucansonfx

import javafx.application.Application
import javafx.application.Platform
import javafx.scene.layout.StackPane
import javafx.stage.Screen
import javafx.stage.Window
import tornadofx.App
import tornadofx.View
import tornadofx.label

class Main : View() {
    override val root = StackPane()

    init {
        root.setPrefSize(500.0, 500.0)
        root.label("Hello World!")
        Platform.runLater {
            centerOnHalfScreen(root.scene.window)
        }
    }

    fun centerOnHalfScreen(window: Window) {
        val halfScreen = Screen.getPrimary().bounds.width / 2.0
        val stageLeft = (halfScreen - window.width) / 2.0
        window.x = stageLeft
    }
}

class MainApp : App() {
    override val primaryView = Main::class
}

fun main(args: Array<String>) {
    Application.launch(MainApp::class.java)
}
