/*
*   Created by Rudy PICARD
*   Kotlin  Dog shelter project
*
* */
package app
import utility.*

fun main() {
    val myShelter = DogShelter()
    val dog = Dog("Skywalker", "White/Black", "Husky", "Croquettes")
    val create = "Please enter the number of places available in the shelter: "
    val commandText = "Please enter a command (help - for a list): "
    var command = arrayOf("create", getNum(create).toString())
    val registerDog = arrayOf("register", dog.toString())

    //dog is not registered whan app launch

    do {
        myShelter.service(command)
        myShelter.service(registerDog)
        command = splitToArray(getString(commandText))
    } while (command[0] != "exit")
}