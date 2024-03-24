package com.example.questionnaire

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.questionnaire.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindingMain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)

        with (bindingMain) {

            // Button - opens InfoActivity
            btnApply.setOnClickListener {
                val intent = Intent(this@MainActivity, InfoActivity::class.java)

                if (etAge.text.toString().isNotEmpty()) {
                    intent.putExtra(NAME_KEY, etFirstName.text.toString())
                    intent.putExtra(LASTNAME_KEY, etLastName.text.toString())
                    intent.putExtra(PATRONYMIC_KEY, etPatronymic.text.toString())
                    intent.putExtra(AGE_KEY, etAge.text.toString())
                    intent.putExtra(HOBBY_KEY, etHobby.text.toString())
                    startActivity(intent)
                    tvAddInfo.text = getString(R.string.tvAddInfo)
                } else {
                    tvAddInfo.text = getString(R.string.warnUser)
                }
            }

            // button - clears all editTexts
            btnClear.setOnClickListener {
                etLastName.text.clear()
                etFirstName.text.clear()
                etPatronymic.text.clear()
                etAge.text.clear()
                etHobby.text.clear()
            }
        }
    }

    // keys used for intents
    companion object {
        const val NAME_KEY = "name"
        const val LASTNAME_KEY = "lastName"
        const val PATRONYMIC_KEY = "patronymic"
        const val AGE_KEY = "age"
        const val HOBBY_KEY = "hobby"
    }
}