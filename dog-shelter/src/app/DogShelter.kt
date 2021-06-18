/*
*   Created by Rudy PICARD
*   Kotlin  Dog shelter project
*
* */
package app
import utility.isNumber

class DogShelter {
    private lateinit var cages: Array<Boolean>
    private lateinit var dogColor: Array<String>
    private lateinit var dogName: Array<String>
    private lateinit var dogAlimentation: Array<String>
    private val colors = mutableSetOf<String>("Brown", "Black", "White", "Merle", "Grey", "Red", "Gold", "Blue", "Cream")
    private val breed = mutableSetOf<String>("Akita", "Alaskan malamute", "Australian shepherd", "Bassethound", "Beagle", "Border Collie", "Bulldog",
            "Cocker", "Dalmatian", "Husky")

    fun service(command: Array<String>) {
        if (!this::cages.isInitialized) {
            when (command[0]) {
                "create" -> if (isNull(command)) errorBounds() else reset(command[1])
                else -> println("No shelter created.") //throw Exception("No shelter created.") -> stop program
            }
        } else {
            when (command[0]) {
                "create" -> if (isNull(command)) errorBounds() else reset(command[1])
                "register" -> if (isNull(command, 1, 2)) errorBounds() else register(command[2], command[1], command[3], command[4])
                "leave" -> if (isNull(command)) errorBounds() else leave(command[1])
                "status" -> info(0, "")
                "reg_by_color" -> if (isNull(command)) errorBounds() else info(1, command[1])
                "spot_by_color" -> if (isNull(command)) errorBounds() else info(2, command[1])
                "spot_by_reg" -> if (isNull(command)) errorBounds() else info(3, command[1])
                "spot_by_alimentation" -> if (isNull(command)) errorBounds() else info(4, command[1])
                "print_known_colors" -> println(colors)
                "print_known_colors" -> println(breed) //last 2 used to test that mutable collections works
                "help" -> help()
            }
        }
    }

    private fun reset(number: String) {
        if (isNumber(number)) {
            cages = Array(number.toInt()) { true }
            dogColor = Array(number.toInt()) { "" }
            dogName = Array(number.toInt()) { "" }
            dogAlimentation = Array(number.toInt()) { "" }
            println("Created a shelter with $number free cages.")
        } else errorNumber(number)
    }

    private fun register(color: String, id: String, dogBreed: String, alimentation: String) {
        for (index in cages.indices) {
            if (!cages[index]) {
                if (dogName[index] == id) {
                    println("Please enter a unique name for the dog !")
                    return
                }
            }
        }
        for (index in cages.indices) {
            if (cages[index]) {
                println("A $color dog named $id is occuping cage ${index + 1}. It feeds on $alimentation")
                cages[index] = false
                dogColor[index] = color
                dogName[index] = id
                dogAlimentation[index] = alimentation
                if(!colors.contains(dogColor)) colors.add(dogColor[index])
                if(!breed.contains(dogBreed)) breed.add(dogBreed)
                return
            }
        }
        println("Sorry, all cages are occupied.")
    }

    private fun leave(number: String) {
        if (isNumber(number)) {
            if (number.toInt() <= cages.size) {
                if (cages[number.toInt() - 1]) println("There is no dog in cage $number.") else {
                    println("Cage $number is free.")
                    cages[number.toInt() - 1] = true
                }
            } else throw Exception("there is no cage number $number.")
        } else errorNumber(number)
    }

    // find: 0 = status, 1 = reg_by_color, 2 = spot_by_color, 3 = spot_by_reg
    private fun info(find: Int, search: String) {
        var results = ""

        for (index in cages.indices) {
            if (!cages[index]) {
                when (find) {
                    0 -> results += "Cage : ${index + 1}, dog name: ${dogName[index]}, dog color: ${dogColor[index]}\n"
                    1 -> if (dogColor[index].toLowerCase() == search.toLowerCase()) results += "${dogName[index]} "
                    2 -> if (dogColor[index].toLowerCase() == search.toLowerCase()) results += "${index + 1} "
                    3 -> if (dogName[index] == search) results += "${index + 1}"
                    4 -> if (dogAlimentation[index] == search) results += "${dogName[index]} "
                }
            }
        }
        if (results == "") {
            println(
                    when (find) {
                        0 -> "Cage is empty."
                        in 1..2 -> "No dogs with color $search were found."
                        else -> "No dogs with registration Name $search were found."
                    }
            )
        } else println(
                if (find == 0 || find == 3) results.trim() else results.trim().replace(" ", ", ")
        )
    }

    private fun help() {
        println(
                """
            register - Registers your dog. Please enter a unique Name, color (add number for multiple same names), breed and Alimentation.
                Example: "register Skywalker White Husky Croquettes"
            leave - removes a registered dog from a cage.
                Example: "leave 2"
            status - shows cages number, dog Name and color of any used cages
            reg_by_color - prints all registration numbers of dogs of a particular color, taking color as a parameter.
                Example: "reg_by_color brown"
            spot_by_color - prints the cage numbers for all dogs of a particular color.
                Example: "spot_by_color merle"
            spot_by_reg - returns the cage number of the dog based on its registration name
                Example: "spot_by_reg Diane"
            spot_by_alimentation - returns the dog names based on their alimentation
                Example: "spot_by_alimentation croquettes"
            create - creates a new shelter according to size received and erases previous one
                Example: "create 20" 
            "print_known_colors" - print all the known dog colors
                Example: "print_known_colors" 
            "print_known_breed" -print all the known dog breeds 
                Example: "print_known_breed" 
            exit - exits the program
        """.trimIndent()
        )
    }

    private fun errorBounds() = println("Not enough info given, try again please.. (use help for commands)")

    private fun errorNumber(number: String) = println("${number[1]} is not a cage number, try again please.. (use help for commands)")

    private fun isNull(string: Array<String>, num1: Int = 0, num2: Int = 1): Boolean {
        return string.getOrNull(num1) == null || string.getOrNull(num2) == null
    }
}

