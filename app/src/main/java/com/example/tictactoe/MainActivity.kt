package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Script
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random as Random1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buclick(view: View) {
        val buselected = view as Button
        var cellID = 0
        when (buselected.id) {
            R.id.bu1 -> cellID = 1
            R.id.bu2 -> cellID = 2
            R.id.bu3 -> cellID = 3
            R.id.bu4 -> cellID = 4
            R.id.bu5 -> cellID = 5
            R.id.bu6 -> cellID = 6
            R.id.bu7 -> cellID = 7
            R.id.bu8 -> cellID = 8
            R.id.bu9 -> cellID = 9
        }
        Toast.makeText(this, "cellID: " + cellID, Toast.LENGTH_LONG).show()
        playGame(cellID, buselected)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activeplayer = 1

    private fun playGame(cellID: Int, buselected: Button) {
        if (activeplayer == 1) {
            buselected.text = "X"
            buselected.setBackgroundColor(Color.parseColor("#009193"))
            player1.add(cellID)
            activeplayer = 2
            AutoPlay()
        } else {
            buselected.text = "0"
            buselected.setBackgroundColor(Color.parseColor("#006593"))
            player2.add(cellID)
            activeplayer = 1
        }
        buselected.isEnabled = false

        checkWinner()
    }

    private fun AutoPlay() {
        val emptyCells = ArrayList<Int>()
        for (cellID in 1..9){
            if (!(player1.contains(cellID) || player2.contains(cellID))){
                emptyCells.add(cellID)
        }}
          val r = Random1
        val randIndex = r.nextInt(emptyCells.size-0)+0
        val cellID = emptyCells[randIndex]

        var buSelected:Button
        when(cellID){
            1->buSelected=bu1
            2-> buSelected=bu2
            3-> buSelected=bu3
            4-> buSelected=bu4
            5-> buSelected=bu5
            6-> buSelected=bu6
            7-> buSelected=bu7
            8-> buSelected=bu8
            9-> buSelected=bu9
            else -> buSelected = bu1

        }

        playGame(cellID,buSelected)
    }


    private fun checkWinner() {
        var winner = -1
        //row1
        if (player1.contains(1)&&player1.contains(2)&&player1.contains(3)){
            winner == 1
    }
        if (player2.contains(1)&&player2.contains(2)&&player2.contains(3)){
            winner == 2
        }
        //row2
        if (player1.contains(4)&&player1.contains(5)&&player1.contains(6)){
            winner == 1
        }
        if (player2.contains(4)&&player1.contains(5)&&player1.contains(6)){
            winner == 2
        }
        //row3
        if (player1.contains(7)&&player1.contains(8)&&player1.contains(9)){
            winner == 1
        }
        if (player2.contains(7)&&player2.contains(8)&&player2.contains(9)){
            winner == 2
        }

        // col 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner=2
        }



        // col 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner=1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner=2
        }


        // col 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner=2
        }

        //diagonal
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner=2
        }

        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner=1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner=2
        }
        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this, "Player 1 wins the game", Toast.LENGTH_LONG).show()
            } else if(winner == 2) {
                Toast.makeText(this, "Player 2 wins the game", Toast.LENGTH_LONG).show()
            }
        }
        else{
            Toast.makeText(this,"Game Draws",Toast.LENGTH_LONG).show()
        }
    }

}