# Dog Shelter app

Creates a dog shelter with as many cages as specified by the user, and allows the user to add, remove and list dogs already there.  
Usage: run the app, give a number of available cages and then start using commands below.

## Usage

```kotlin
register - Registers your dog.
    Example: "register Skywalker White Husky Croquettes Male"
leave - removes a registered dog from a cage.
    Example: "leave 2"
status - shows cages number, dog Name and color of any used cages 
reg_by_color - prints all dogs of a particular color.
    Example: "reg_by_color brown"
spot_by_color - prints the cages numbers for dogs of a given color.
    Example: "spot_by_color merle"
spot_by_reg - returns the cage number of a dog based on the given name.
    Example: "spot_by_reg Diane"
reg_by_alimentation - returns the dog names based on their alimentation 
    Example: "spot_by_alimentation croquettes"
reg_by_sex - returns the dog names based on their sex
    Example: "spot_by_sex female"
reg_by_breed - returns the dog names based on their breed
    Example: "spot_by_breed husky"
create - creates a new shelter according to size received and erases previous one
    Example: "create 20"
"print_known_colors" - print all the known dog colors
        Example: "print_known_colors"
"print_known_breed" -print all the known dog breeds
        Example: "print_known_breed"
exit - exits the program
```

## Versions
1 - create - register - leave dogs drom the shelter  
2- registered by color - spot by color & registration  
3 - Collection + dog colors & breeds & nutrition + exception cage not exist+ data class  
4 - complete TODOs

## Authors
Rudy Picard

//TODO: high order function, ~~data class~~, delegation  
//TODO: smart cast + ~~collection~~ + extention + ~~exceptions~~ + lambda + coroutine + ~~scope function ~~ 
~~TODO: Enum colors for the dogs (ex: blue is not a dog color)~~  
~~TODO: Enum for dog breed~~ + ~~getter by dog breed ~~ 
~~TODO: add dog  nutrition when a dog is registered~~ + ~~getter by food type~~  
//TODO: ~~add dog sex~~, age, price and reservatoin