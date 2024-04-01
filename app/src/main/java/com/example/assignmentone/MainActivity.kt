package com.example.assignmentone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // The list of prominent persons in history is defined and stored in "historicalFigures" using a case-structure type of function called "mapOf()"
    private val historicalFigures = mapOf(
        95 to "Nelson Mandela",
        60 to "Diego Maradona",
        55 to "Julius Caesar",
        82 to "Pele",
        39 to "Martin Luther King",
        81 to "Queen Victoria",
        56 to "Abraham Lincoln",
        74 to "Muhammed Ali",
        52 to "William Shakespeare",
        76 to "Albert Einstein"

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // The ageInput, Result, generate button and clear button are fetched from the activity main into this window and assigned to variables so that actions are assigned to them through this window
        val ageInput: EditText = findViewById(R.id.AgeInput)
        val generateButton: Button = findViewById(R.id.generate)
        val clearButton: Button = findViewById(R.id.clear)
        val resultText: TextView = findViewById(R.id.Result)

        // The code below assigns an action to the generateButton which matches the input from the user to the list of historical figures using "if statements"
        generateButton.setOnClickListener {

        // The information entered by the user is converted into a string and stored in "ageString" making the variable easier to manipulate
            val ageString = ageInput.text.toString()

            val emptyPrompt = "Please enter an age"
        // The value entered by the user is evaluated using an if statement, to check if the variable "ageString" is empty, meaning the user has not entered in a value, whereby a prompt to enter in a value will be displayed
            if (ageString.isEmpty()) {
                resultText.text = emptyPrompt
            } else {

        // This section of code is executed when the ageString variable is not empty and contains a value, ageString is then processed by the "toIntOrNull" function so that the number entered is processed as an integer or an empty space
        // if the user has entered in a character other than a number such as a letter or symbol then an empty space will be stored in "userAge", if the user has entered in a number then the value will be stored as an integer in "userAge"

                val userAge = ageString.toIntOrNull()
                val ageRangePrompt = "Enter an age between 20-100"

        // In this section userAge is either an integer or an empty space
        // If the userAge is an empty space or an integer outside of the range of 20-100 a prompt will be displayed to the user to insert an age in the range of 20-100

                if (userAge == null || userAge !in 20..100) {
                    resultText.text = ageRangePrompt
                } else {

        // This is the else section of the if statement now that userAge is within the range of 20-100
        // The integer in userAge is matched with the identical age in the "historicalFigures" list and the name linked to the age in the list


        // The matched age is now stored in "name"
                    val name = historicalFigures[userAge]

        // The name and age of the person of history is stored in "match" ready to be displayed as a result to the user
                    val match = "The person you are matched with is: " + name + ", with the age of " + userAge

        // in this section "name" (the age entered by the user) is within the required range and is evaluated by an if statement if it matches with any age in the list of ages in the "historicalFigures" list
        // if the variable "name" (the age entered by the user) does not match with any age in the "historicalFigures" list it will be stored as a null because it will not match with any age in the list

        // if "name" matches with an age in the "historical figures list, a value will be stored in the variable "name" meaning the if statement condition will be met and the variable "match" containing the result of the matching age will be displayed in resultText textView
                    if (name != null) {

        // resultText is a textView used to display results/prompts/error-messages to the user, in this case the variable "match containing the result will be displayed here to the user
                        resultText.text = match
                    } else {

        // the variable "name" will be stored with a null if it does not match with any age in the list "historicalFigures" meaning the condition in the if statement will not be met and the else section of the if statement will be executed
        // in this section of the if statement the resultText textview will display a variable "noResult" alerting the user that the age entered does not match with any person in the list

                        val noResult = "There is no name associated with this age"
                        resultText.text = noResult

        // the "generateButton" action is concluded

                    }
                }
            }
        }

        // an action is being assigned to the "clearButton"
        clearButton.setOnClickListener {
        // once the "clearButton" is clicked the "ageInput" textView where the user enters an age is cleared using the "clear()" function
        // simultaneously the "resultText" textView is assigned with an empty string " " clearing the textView
            ageInput.text.clear()
            resultText.text = ""
        // upon execution of the "clearButton" the user is allowed to re-use the history app
        // the "clearButton" action is concluded

        }
    }
}
