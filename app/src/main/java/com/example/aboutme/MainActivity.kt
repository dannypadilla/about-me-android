package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var editNicknameText: EditText
    lateinit var nicknameTextView: TextView
    lateinit var doneButton: Button
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editNicknameText = findViewById(R.id.nickname_edit)
        nicknameTextView = findViewById(R.id.nickname_text) // docs are incorrect was nickname_edit

        doneButton = findViewById(R.id.done_button)
        doneButton.setOnClickListener{
            addNickname(it)
        }

        nicknameTextView.setOnClickListener {
            updateNickname(it)
            //addNickname(it)
        }

    }

    private fun updateNickname(view: View) {
        editNicknameText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE
        editNicknameText.getText().clear()
        editNicknameText.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editNicknameText, 0)
    }

    private fun addNickname(view: View) {
        nicknameTextView.text = editNicknameText.text
        editNicknameText.visibility = View.GONE
        doneButton.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

    }

}
