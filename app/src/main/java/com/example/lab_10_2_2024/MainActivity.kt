package com.example.lab_10_2_2024

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView:RecyclerView
    private lateinit var personAdapter:PersonAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val persons=mutableListOf<Person>()
        val firstNameEditText:EditText = findViewById(R.id.FirstName)
        val lastNameEditText:EditText = findViewById(R.id.LastName)
        val numberPhoneEditText:EditText = findViewById(R.id.numberPhone)
        val submitButton:Button = findViewById(R.id.Comfired)
        val tickItem:CheckBox = findViewById(R.id.checkBox)


        recyclerView = findViewById(R.id.recyclerView)
        personAdapter = PersonAdapter(persons)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = personAdapter

        var buttonRadioCheck = findViewById<RadioButton>(R.id.RadioMale)
        val groupRadio = findViewById<RadioGroup>(R.id.radioGroup)

        groupRadio.setOnCheckedChangeListener{
            group,checkID ->
            buttonRadioCheck = findViewById<RadioButton>(checkID)
        }

        submitButton.setOnClickListener {
            if(tickItem.isChecked){
                persons.add(Person(firstNameEditText.text.toString(),lastNameEditText.text.toString(),numberPhoneEditText.text.toString(),buttonRadioCheck.text.toString()))
                personAdapter = PersonAdapter(persons)
                recyclerView.adapter = personAdapter
            }else{
                tickItem.setTextColor(Color.RED)
            }
        }




    }
}