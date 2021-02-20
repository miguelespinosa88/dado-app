package edu.itesm.dados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import kotlin.random.Random
import kotlin.random.nextUInt

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tira_dado()
    }

    fun tira_dado(){
        var tiros=1
        var cont1=0
        var cont2=0
        roll_dice.setOnClickListener {
            tiros++
            if (tiros<=7){
                val rand = Random.nextInt(1,7) //Se pone de 1-7 para que el 6 salga
                //.rem (2) se utiliza para obtener el módulo de la variable tiros
                if (tiros.rem(2)==1){ //Jugador 2
                    cont2=cont2+rand
                    mensaje.text="Tiro # ${tiros-(tiros/2)-1} del jugador 2: $rand puntos"
                }
                else{ //Jugador 1
                    cont1=cont1+rand
                    mensaje.text="Tiro # ${tiros-(tiros/2)} del jugador 1 : $rand puntos"
                }
            }
            else {
                if (cont1<cont2){
                    mensaje.text="Gana el jugador 2 con $cont2 puntos"
                }
                else if (cont2<cont1){
                    mensaje.text="Gana el jugador 1 con $cont1 puntos"
                }
                else {
                    mensaje.text="Hubo un empate"
                }
                tiros=1 //Se reinician la variables
                cont1=0
                cont2=0
            }
        }
    }
}