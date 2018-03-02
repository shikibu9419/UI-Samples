package com.example.shikibu.ui_samples

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class ExampleModel(
    @PrimaryKey var id: Long = 0,
    var title: String = "",
    var detail: String = ""
): RealmObject(){}