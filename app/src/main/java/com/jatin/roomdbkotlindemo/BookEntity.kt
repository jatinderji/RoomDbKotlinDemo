package com.jatin.roomdbkotlindemo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class BookEntity {

    @PrimaryKey(autoGenerate = true)
    var bookId : Int = 0

    @ColumnInfo(name = "bookName")
    var bName: String = ""

}