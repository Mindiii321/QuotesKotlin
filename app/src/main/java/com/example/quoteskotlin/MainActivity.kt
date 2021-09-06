package com.example.quoteskotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quoteskotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var array = ArrayList<Model>()
    private lateinit var binding: ActivityMainBinding // binding for avoiding findViewById
    private var index = 0 // index value of quotes list
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addQuestDataList()

        binding.tvNext.setOnClickListener {

            if (index < array.size - 1) {
                index++
                val newData = array[index]
                binding.quoteText.text = newData.text
                binding.quoteAuthor.text = newData.author
            }

        }

        binding.tvPrevious.setOnClickListener {
            //0

            if (index > 0) {
                index--
                val previousData = array[index]
                binding.quoteText.text = previousData.text
                binding.quoteAuthor.text = previousData.author
            }
        }

        binding.tvShare.setOnClickListener {

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, binding.quoteText.text.toString())
            startActivity(Intent.createChooser(intent, "choose one"))
        }
    }

    private fun addQuestDataList() {
        val model = Model("Iris Murdoch", "We can only learn to love by loving")
        val modelA = Model("Karen Clark", "Life is change. Growth is optional. Choose wisely")
        val modelB = Model("Wayne Dyer", "You'll see it when you believe it")
        val modelC = Model("William Shakespeare", "Having nothing, nothing can he lose.")
        val modelD = Model("Iris Murdoch", "We can only learn to love by loving")
        val modelE = Model("Publilius Syrus", "A rolling stone gathers no moss.")
        val modelF = Model("Publilius Syrus", "A rolling stone gathers no moss.")
        val modelG = Model("Iris Murdoch", "Today is the tomorrow we worried about yesterday")
        val modelH = Model("Naipaul", "The world is always in movement.g")
        val modelI = Model("Haddon Robinson", "What worries you masters you")
        val modelJ = Model("Budhha", "He is able who thinks he is able")
        val modelK = Model("Pearl Buck", "One faces the future with ones past.")
        val modelL = Model("Brian Tracy", "Goals are the fuel in the furnace of achievement.")
        val modelM = Model("Leonardo da Vinci", "Who sows virtue reaps honour")
        val modelN = Model("Chinese proverb", "Talk doesn't cook rice.")

        array.add(model)
        array.add(modelA)
        array.add(modelB)
        array.add(modelC)
        array.add(modelD)
        array.add(modelE)
        array.add(modelF)
        array.add(modelG)
        array.add(modelH)
        array.add(modelI)
        array.add(modelJ)
        array.add(modelK)
        array.add(modelL)
        array.add(modelM)
        array.add(modelN)

        val myValue = array[index]
        val str: String = myValue.author
        binding.quoteAuthor.text = str
        val str1: String = myValue.text
        binding.quoteText.text = str1

    }


}
