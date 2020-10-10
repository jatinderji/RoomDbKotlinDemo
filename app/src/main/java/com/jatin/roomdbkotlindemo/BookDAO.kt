package com.jatin.roomdbkotlindemo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BookDAO {

    @Insert
    fun saveBook(bookEntity: BookEntity)

    @Query("Select * from BookEntity")
    fun getBooks() : List<BookEntity>

    @Query("delete from BookEntity where bookId= :id")
    fun deleteBook(id : Int)

    @Query("update BookEntity set bookName='New' where bookId= :id")
    fun updateBook(id : Int)

}
