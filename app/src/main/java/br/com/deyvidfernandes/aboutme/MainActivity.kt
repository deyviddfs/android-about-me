package br.com.deyvidfernandes.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputBinding
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import br.com.deyvidfernandes.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Declara variavel para atraibuir databinding
    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Deyvid Fernandes")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        //Define a activity que será instanciada
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

//        val btDone: Button = findViewById(R.id.bt_done)
//        btDone.setOnClickListener {
//            addNickname(it)
//        }
        binding.btDone.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
//        val etNickname:EditText = findViewById(R.id.et_nickname)
//        val tvNickname:TextView = findViewById(R.id.tv_nickname)
//
//        tvNickname.text = etNickname.text
//        etNickname.visibility = View.GONE //Hide Edit Text
//        view.visibility = View.GONE  //Hide button
//        tvNickname.visibility = View.VISIBLE  //Show textview

        binding.apply {
//            tvNickname.text = etNickname.text
            myName?.nickname = etNickname.text.toString()
            invalidateAll()
            etNickname.visibility = View.GONE //Hide Edit Text
            view.visibility = View.GONE  //Hide button
            tvNickname.visibility = View.VISIBLE  //Show textview
        }

//        binding.apply é o mesmo que isso
//        binding.tvNickname.text = binding.etNickname.text
//        binding.etNickname.visibility = View.GONE //Hide Edit Text
//        view.visibility = View.GONE  //Hide button
//        binding.tvNickname.visibility = View.VISIBLE  //Show textview

        //Hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}