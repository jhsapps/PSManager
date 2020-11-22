package com.jhsapps.psmanager.model

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.getValue
import tornadofx.setValue

class BOJ(handle: String) {

    val handleProperty = SimpleStringProperty(handle)
    var handle by handleProperty

    class Problem(id: Int, name: String, tier: String) {
        val idProperty = SimpleIntegerProperty(id)
        var id by idProperty

        val nameProperty = SimpleStringProperty(name)
        var name by nameProperty

        val tierProperty = SimpleStringProperty(tier)
        var tier by tierProperty
    }
}