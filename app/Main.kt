/*
*   Created by Rudy PICARD
*   Kotlin  Dog shelter project
*
* */
package app
import utility.getNum
import utility.getString
import utility.splitToArray

fun main() {
    val myShelter = DogShelter()
    val dog = Dog("Skywalker", "White/Black", "Husky", "Croquettes")
    val create = "Please enter the number of places available in the shelter: "
    val commandText = "Please enter a command (help - for a list): "
    var command = arrayOf("create", getNum(create).toString())
    val registerDog = arrayOf("register", dog.toString())

    //dog is not registered when app launched

    do {
        myShelter.service(command)
        myShelter.service(registerDog)
        command = splitToArray(getString(commandText))
    } while (command[0] != "exit")
}