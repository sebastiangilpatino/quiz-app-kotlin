package com.example.quizapp

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val radio1 = findViewById<RadioGroup>(R.id.mcq1)
        val check1 = findViewById<CheckBox>(R.id.checkBox)
        val check2 = findViewById<CheckBox>(R.id.checkBox2)
        val check3 = findViewById<CheckBox>(R.id.checkBox3)
        val check4 = findViewById<CheckBox>(R.id.checkBox4)
        val check5 = findViewById<CheckBox>(R.id.checkBox5)
        val btn1 = findViewById<Button>(R.id.button2)
        val resetButton = findViewById<Button>(R.id.button)

        btn1.setOnClickListener {
            // 1. Create an object for AlertDialog by passing the current context object
            val builder = AlertDialog.Builder(this@MainActivity)
            // 2. Set the basic information for the builder object
            builder.setTitle("Alert Message")
            var flag = check1.isChecked && check4.isChecked && check5.isChecked
            if (radio1.checkedRadioButtonId == R.id.radioButton3 && flag) {
                builder.setMessage(
                    "Current Date: " + LocalDate.now() + " Time submitted"
                            + LocalTime.now() + " Score: " + 100
                )
            } else if (radio1.checkedRadioButtonId == R.id.radioButton3 && !flag){
                builder.setMessage(
                    "Current Date: " + LocalDate.now() + " Time submitted"
                            + LocalTime.now() + " Score: " + 50
                )
            }else if (radio1.checkedRadioButtonId != R.id.radioButton3 && flag){
                builder.setMessage(
                    "Current Date: " + LocalDate.now() + " Time submitted"
                            + LocalTime.now() + " Score: " + 50
                )
            }else{
                builder.setMessage(
                    "Current Date: " + LocalDate.now() + " Time submitted"
                            + LocalTime.now() + " Score: " + 0
                )
            }
            builder.setIcon(R.drawable.alerticon)
            // 3. Performing positive action on clicking Yes button
            // Parameters : dialogInterface object of dialogInterface, which is integer id for the button onClick method
            // DialogInterface -> Interface that defines a dialog-type class that can be shown, dismissed, or canceled, and may have buttons that can be clicked.
            builder.setPositiveButton("Yes") { dialogInterface, which ->
                Toast.makeText(
                    applicationContext,
                    "It's a positive action click by which id : $which",
                    Toast.LENGTH_SHORT
                ).show()
                dialogInterface.dismiss() // dismiss the dialog
                finish() // to destroy the activity
            }
            // 4. Performing Cancel action on clicking Cancel button
            builder.setNegativeButton("Cancel") { dialogInterface, which ->
                Toast.makeText(
                    applicationContext,
                    "It's a positive action click by which id : $which",
                    Toast.LENGTH_SHORT
                ).show()
                dialogInterface.dismiss() // dismiss the dialog, but activity is still alive
            }
            // 5. Finally, make the alert dialog using builder
            val dialog: AlertDialog = builder.create()
            // 6. Display the alert dialog on app interface
            dialog.show()
        }


        resetButton.setOnClickListener {
            radio1.clearCheck()
            check1.isChecked = false;
            check2.isChecked = false;
            check3.isChecked = false;
            check4.isChecked = false;
            check5.isChecked = false;

        }

    }
}