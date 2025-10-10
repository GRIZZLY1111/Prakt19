package com.example.criminalintent

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.criminalintent.Crime.Crime
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import java.util.Date
import java.util.Locale

class CrimeFragment: Fragment() {
    private lateinit var crime: Crime
    private lateinit var titleField: EditText
    private lateinit var dateButton: FloatingActionButton
    private lateinit var crimetext: TextView
    private lateinit var solvedCheckBox: CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = Crime(title = "", date = Date())
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle? ): View?
    { val view = inflater.inflate(R.layout.fragment_crime, container, false)
        titleField = view.findViewById(R.id.crime_title) as EditText
        dateButton = view.findViewById(R.id.crime_date) as FloatingActionButton
        solvedCheckBox = view.findViewById(R.id.crime_solved) as CheckBox
        crimetext = view.findViewById(R.id.crime_text) as TextView
        crimetext.apply { text = crime.date.toString() }
        return view
    }
    override fun onStart() {
        super.onStart()
        val titleWatcher = object : TextWatcher
        {
            override fun beforeTextChanged(
                sequence: CharSequence?,
                start: Int, count: Int,
                after: Int
            ) {
                // Это пространство оставлено пустым специально
            }
            override fun onTextChanged(
                sequence: CharSequence?,
                start: Int, before: Int,
                count: Int
            ) {
                crime.title =sequence.toString()
            }
            override fun
                    afterTextChanged(sequence: Editable?) {
                        // И это
            }
        }
        titleField.addTextChangedListener(titleWatcher)
        solvedCheckBox.setOnCheckedChangeListener { _, isChecked ->
            crime.isSolved = isChecked
            val message = if (isChecked) {
                "Преступление отмечено как решённое"
            } else {
                "Преступление отмечено как нерешённое"
            }
            if (isChecked){
                dateButton.isClickable=true
            }
            else{
                dateButton.isClickable=false
            }
            Snackbar.make(requireView(), message, Snackbar.LENGTH_SHORT).show()
        }
        val date = Date()
        val format = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale("ru"))
        val formateDate = format.format(date)
        crimetext.text = formateDate
    }
}