package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/** Tämä luokka tekee kaiken, mitä pitää tapahtua, kun
 * sovellus käynnistyy. TÄssä tapauksessa: luo näkymän
 * activity.mainista,hakee napin sieltä id:n avulla ja
 * luo sille clicklistenerin, joka kutsuu nopan heitto
 * funktiota
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
        //heitä noppa kun sovellus aukeaa
       rollDice()
    }

    /** Tämä funktio kertoo mitä tapahtuu kun rollDicea kutsutaan
     * luo Noppa-instanssin: heittää sitä ja kirjoittaa tulkosen
     * textviewhun.
     */
    private fun rollDice() {
        //luodaan noppa-instanssi
        val myDice = Dice(6)
        //heitetään noppaa
        val diceRoll = myDice.roll()
        //etsitään imageview näkymästä
        val diceImage: ImageView = findViewById(R.id.imageView)
        //valitaan oikea kuva
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }
}

/** Tämä on Noppa luokka joka määrittelle nopan
 * Eli käytännössä pelkän heittofunktion
 */
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}