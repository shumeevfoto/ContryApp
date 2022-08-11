package com.second.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope

import com.second.myapplication.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searshButton.setOnClickListener{
            val nameContry = binding.contryNameEditText.text.toString()


            lifecycleScope.launch {
                try {
                    val contries = restContriesApi.getContryByName(nameContry)
                    val contry = contries[0]

                    binding.ccontryNameTextView.text = contry.name
                    binding.capitalTextView.text = contry.capital
                    binding.areaTextView.text = FormatNumberContry(contry.area)
                    binding.populationTextView.text = FormatNumberContry(contry.population)
                    binding.langTextView.text = languageToString(contry.languages)

//                    loadSvg(binding.imageView, contry.flag)

                    binding.resultLayout.visibility = View.VISIBLE
                    binding.statusLayout.visibility = View.INVISIBLE
                }catch (e:Exception){
                    binding.statustextView.text = "Страна не найдена"
                    binding.statusimageView.setImageResource(R.drawable.ic_baseline_error_24)
                    binding.resultLayout.visibility = View.INVISIBLE
                    binding.statusLayout.visibility = View.VISIBLE
                }
            }


            }

        }
    }


