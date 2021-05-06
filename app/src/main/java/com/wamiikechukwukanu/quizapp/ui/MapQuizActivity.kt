package com.wamiikechukwukanu.quizapp.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.wamiikechukwukanu.quizapp.R
import com.wamiikechukwukanu.quizapp.db.Database
import com.wamiikechukwukanu.quizapp.quizlogic.QuizLogic
import kotlinx.android.synthetic.main.activity_map_quiz.*

class MapQuizActivity : AppCompatActivity() {
    //    HELPER CLASS
    lateinit var quizLogic: QuizLogic
    lateinit var database: Database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        setContentView(R.layout.activity_map_quiz)

        quizLogic = QuizLogic(this)
        database = Database(applicationContext)

        val currentMapPosition = quizLogic.getCurrentSharedPreference()

        quizLogic.setButtons(currentMapPosition, first_btn, second_btn, third_btn, fourth_btn, fifth_btn, sixth_btn, seventh_btn, eight_btn, ninth_btn, tenth_btn, eleventh_btn, twelve_btn)


        getCurrentMapState(currentMapPosition)

        insertIntoRoomDataBase()

//        CHECK IF THE MAP NAME HAS BEEN ADDED TO THE DATA BASE BEFORE NOW
        if (quizLogic.checkIfSavedToDataBase()) {

//            SET SHARED PREF TO TRUE, BECAUSE DATABASE
            quizLogic.saveIntoDataBaseOnce(false)
        }


    }

    private fun getCurrentMapState(position: Int) {
        val positionImage = quizLogic.getPositionMap(position)
        Glide.with(this).load(positionImage).into(map_image_view)
    }

    private fun insertIntoRoomDataBase() {
        val i = database.insertFlagNameIntoDataBase(1, "z", "g", "a", "i", "r", "l", "e", "a", "y", "z", "f", "f")

        Log.d("WAMI", database.toString())
        if (i == true) {
            Toast.makeText(this, "INSERTED", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "NOT INSERTED", Toast.LENGTH_LONG).show()
        }
//        database.insertFlagNameIntoDataBase("p", "a", "o", "x", "l", "n", "g", "g", "o", "g", "a", "n")
//        database.insertFlagNameIntoDataBase( "b", "i", "y", "n", "n", "e", "g", "y", "v", "x", "a", "n")
//        database.insertFlagNameIntoDataBase("m", "o", "s", "t", "e", "a", "b", "w", "n", "w", "a", "k")
//        database.insertFlagNameIntoDataBase( "m", "o", "s", "t", "e", "a", "b", "w", "n", "w", "a", "k")
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//        arrayList.add(database.insertFlagNameIntoDataBase())
//
//        arrayList.add(FlagNameTable(6, " u ", " m ", " r ", " u ", " e ", " n ", " b ", " i ", " s ", " d ", " o ", " s "))
//        arrayList.add(FlagNameTable(7, " a ", " r ", " m ", " o ", " c ", " t ", " m ", " o ", " n ", " n ", " r ", " e "))
//        arrayList.add(FlagNameTable(8, " c ", " e ", " e ", " e ", " a ", " h ", " r ", " v ", " q ", " d ", " q ", " p "))
//        arrayList.add(FlagNameTable(9, " z ", " r ", " i ", " d ", " p ", " h ", " c ", " j ", " b ", " l ", " y ", " a "))
//        arrayList.add(FlagNameTable(10, " o ", " d ", " r ", " z ", " k ", " m ", " o ", " o ", " j ", " o ", " c ", " s "))
//        arrayList.add(FlagNameTable(11, "o", "v", "d", "i", "w", "c", "t", "o", "e", "e", "r", "i"))
//        arrayList.add(FlagNameTable(12, "t", "l", "r", "b", "o", "i", "u", "j", "d", "i", "m", "b"))
//        arrayList.add(FlagNameTable(13, "o", "p", "y", "t", "a", "y", "s", "e", "y", "g", "b", "j"))
//        arrayList.add(FlagNameTable(14, "r", "m", "e", "e", "r", "l", "c", "x", "t", "a", "j", "i"))
//        arrayList.add(FlagNameTable(15, "w", "w", "e", "t", "l", "s", "v", "i", "a", "n", "i", "g"))
//        arrayList.add(FlagNameTable(16, "i", "i", "p", "f", "o", "s", "t", "a", "h", "e", "j", "t"))
//        arrayList.add(FlagNameTable(17, "y", "x", "n", "k", "y", "t", "f", "a", "o", "g", "b", "f"))
//        arrayList.add(FlagNameTable(18, "c", "u", "i", "b", "a", "m", "w", "a", "t", "d", "p", "g"))
//        arrayList.add(FlagNameTable(19, "u", "n", "a", "g", "j", "a", "t", "h", "a", "x", "h", "x"))
//        arrayList.add(FlagNameTable(20, "b", "a", "b", "u", "r", "e", "n", "g", "s", "s", "i", "u"))
//        arrayList.add(FlagNameTable(21, "a", "n", "s", "s", "u", "u", "g", "e", "b", "i", "i", "a"))
//        arrayList.add(FlagNameTable(22, "p", "r", "a", "b", "f", "e", "k", "y", "n", "x", "q", "r"))
//        arrayList.add(FlagNameTable(23, "s", "t", "e", "e", "l", "m", "o", "h", "n", "w", "y", "o"))
//        arrayList.add(FlagNameTable(24, "e", "b", "a", "r", "e", "c", "i", "s", "i", "m", "l", "r"))
//        arrayList.add(FlagNameTable(25, "a", "r", "l", "t", "b", "a", "a", "y", "l", "m", "n", "i"))
//        arrayList.add(FlagNameTable(26, "r", "a", "s", "y", "g", "c", "a", "a", "m", "d", "w", "a"))
//        arrayList.add(FlagNameTable(27, "t", "d", "a", "m", "i", "w", "l", "m", "z", "w", "q", "a"))
//        arrayList.add(FlagNameTable(28, "b", "i", "m", "d", "j", "n", "d", "a", "l", "c", "j", "m"))
//        arrayList.add(FlagNameTable(29, "z", "t", "r", "n", "i", "a", "a", "n", "i", "m", "u", "a"))
//        arrayList.add(FlagNameTable(30, "r", "m", "i", "u", "i", "b", "s", "t", "u", "a", "l", "y"))
//        arrayList.add(FlagNameTable(31, "o", "c", "r", "m", "c", "c", "e", "l", "h", "x", "o", "o"))
//        arrayList.add(FlagNameTable(32, "o", "z", "c", "i", "b", "w", "u", "m", "q", "e", "m", "a"))
//        arrayList.add(FlagNameTable(33, "i", "n", "w", "m", "b", "i", "i", "a", "x", "a", "n", "x"))
//        arrayList.add(FlagNameTable(34, "p", "v", "i", "r", "m", "h", "n", "e", "s", "g", "q", "d"))
//        arrayList.add(FlagNameTable(35, "i", "i", "n", "g", "u", "w", "e", "a", "j", "v", "u", "r"))
//        arrayList.add(FlagNameTable(36, "o", "r", "e", "n", "y", "e", "i", "s", "i", "n", "u", "r"))
//        arrayList.add(FlagNameTable(37, "a", "a", "s", "t", "q", "d", "k", "r", "n", "w", "w", "v"))
//        arrayList.add(FlagNameTable(38, "s", "e", "l", "n", "e", "y", "j", "g", "a", "w", "s", "y"))
//        arrayList.add(FlagNameTable(39, "l", "e", "s", "e", "c", "s", "t", "y", "l", "h", "d", "y"))
//        arrayList.add(FlagNameTable(40, "l", "i", "n", "e", "r", "r", "e", "e", "p", "o", "a", "s"))
//        arrayList.add(FlagNameTable(41, "r", "r", "s", "j", "l", "z", "m", "o", "a", "i", "c", "a"))
//        arrayList.add(FlagNameTable(42, "s", "f", "u", "o", "a", "h", "r", "b", "t", "a", "i", "c"))
//        arrayList.add(FlagNameTable(43, "h", "s", "n", "s", "o", "d", "t", "a", "t", "u", "z", "u"))
//        arrayList.add(FlagNameTable(44, "s", "z", "a", "i", "k", "p", "u", "f", "c", "n", "d", "n"))
//        arrayList.add(FlagNameTable(45, "z", "a", "a", "l", "r", "z", "a", "n", "i", "n", "a", "t"))
//        arrayList.add(FlagNameTable(46, "g", "a", "o", "o", "t", "u", "n", "u", "j", "g", "d", "f"))
//        arrayList.add(FlagNameTable(47, "i", "d", "a", "t", "b", "u", "w", "t", "s", "n", "s", "i"))
//        arrayList.add(FlagNameTable(48, "g", "p", "e", "n", "e", "t", "a", "a", "g", "u", "d", "z"))
//        arrayList.add(FlagNameTable(49, "a", "x", "h", "w", "b", "i", "s", "z", "i", "a", "m", "d"))
//        arrayList.add(FlagNameTable(50, "a", "b", "z", "o", "a", "w", "i", "m", "e", "u", "b", "m"))
//
//
//
//


    }

}
