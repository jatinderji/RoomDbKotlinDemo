package com.jatin.roomdbkotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var db = Room.databaseBuilder(applicationContext,AppDb::class.java,"BookDb").build()

        create.setOnClickListener {
                val thread = Thread{
                    var bookEntity = BookEntity()
                    bookEntity.bName = "Android Kotlin"
                    db.bookDao().saveBook(bookEntity)
                }
            thread.start()
        }

        read.setOnClickListener {
            val thread = Thread{
                db.bookDao().getBooks().forEach(){
                    Log.i("DBAPP","${it.bookId} : ${it.bName}")
                }
            }
            thread.start()
        }

        delete.setOnClickListener {
            val thread = Thread{
                db.bookDao().deleteBook(2)
            }
            thread.start()
        }

        update.setOnClickListener {
            val thread = Thread{
                db.bookDao().updateBook(3)
            }
            thread.start()
        }

    }
}