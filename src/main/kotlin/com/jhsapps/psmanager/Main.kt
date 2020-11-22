package com.jhsapps.psmanager

import com.jhsapps.psmanager.view.TestScreen
import javafx.application.Platform
import javafx.stage.Screen
import javafx.stage.Stage
import javafx.stage.StageStyle
import tornadofx.*
import java.awt.SystemTray

fun main(){
    launch<MainApp>()
}

class MainApp: App(TestScreen::class) {
    override fun start(stage: Stage) {
        Platform.setImplicitExit(false)

        stage.setOnCloseRequest {
            println("bye~")

            if(!SystemTray.isSupported()) return@setOnCloseRequest
        }

        val screen = Screen.getPrimary()
        val screenWidth = screen.bounds.width
        val screenHeight = screen.bounds.height

        val stageWidth = 500.0
        val stageHeight = 800.0

        stage.initStyle(StageStyle.UTILITY)

        stage.width = stageWidth
        stage.height = stageHeight
        stage.x = screenWidth - stageWidth
        stage.y = 0.0

        stage.isResizable = false
        stage.isAlwaysOnTop = true

        super.start(stage)
    }
}
