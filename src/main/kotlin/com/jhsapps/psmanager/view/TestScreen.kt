package com.jhsapps.psmanager.view

import com.jhsapps.psmanager.model.BOJ
import javafx.scene.Parent
import javafx.scene.paint.Color
import javafx.scene.text.Font
import tornadofx.*
import tornadofx.vbox

class TestScreen: View(){
    override val root: Parent = scrollpane {
        vbox {
            title = "PS Manager"

            paddingAll = 15.0
            spacing = 15.0

            label {
                text = "BOJ"
                font = Font(25.0)
            }

            tableview<BOJ.Problem> {
                column("ID", BOJ.Problem::idProperty)
                column("Name", BOJ.Problem::nameProperty)
                column("Tier", BOJ.Problem::tierProperty).cellFormat {
                    text = it.toString()

                    style {
                        textFill = when(it.split(" ")[0]){
                            "Bronze" -> Color.BROWN
                            "Silver" -> Color.SILVER
                            "Gold" -> Color.GOLD
                            "Platinum" -> Color.LIGHTSEAGREEN
                            "Diamond" -> Color.LIGHTSKYBLUE
                            else -> Color.BLACK
                        }
                        backgroundColor += Color.WHITE
                    }

                    font = Font(15.0)
                }

                // Test Item
                items.addAll(
                        BOJ.Problem(1001, "Bronze", "Bronze IV"),
                        BOJ.Problem(1002, "Silver", "Silver IV"),
                        BOJ.Problem(1003, "Gold", "Gold IV"),
                        BOJ.Problem(1004, "Platinum", "Platinum IV"),
                        BOJ.Problem(1005, "Diamond", "Diamond IV")
                )

                isFitToHeight = true
            }
        }
    }
}