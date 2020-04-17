/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 */

 function returnChicken(){
     return "chicken";
 }

/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 *
 * @param {any} value the value to print to the console
 */

 function printToConsole(value){
     console.log(value);
 }

/**
 * Write a function called multiplyTogether that multiplies two numbers together. But 
 * what happens if we don't pass a value in? What happens if the value is not a number?
 *
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 */

 function multiplyTogether(first, second){
     return first * second;
 }

 
/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 */

 function multiplyNoUndefined(first = 0, second = 0){

    return first * second;
 }


/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */

 function scopeTest(){
     let inScope = true;
        {
            var scopeBlock = inScope;
        }
        if (scopeBlock == inScope){
            console.log('var gives it scope');
        }else {
            console.log("They don't match");
        }
 }

/**
 * JSDoc Example
 *
 * Take the details of a person and create an English readable sentence
 * that uses that information to describe them. We join the quirks together
 * with the separator, or `, ` by default.
 *
 * @param {string} name the name of the person we're describing
 * @param {number} age the age of the person
 * @param {string[]} [listOfQuirks] a list of funny quirks that we'll list out
 * @param {string} [separator=', '] the string to separate the quirks by
 * @returns {string} the full descriptive string
 */

 function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', '){

    let description = `${name} is currently ${age} years old. Their quirks are: `;
    return description + listOfQuirks.join(separator);
 }

/**
 * Takes an array and, using the power of anonymous functions, generates
 * their sum.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */

 function sumAll(numToSum){
     return numToSum.reduce((num, total) => {return total + num});
 }


//long way

 let instruction = function(num, total){
     return total + num;
 }

 function sumAll2(numToSum){
     return numToSum.reduce(instruction);
 }


/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */

 function filterMultiple(filterArray){
     return filterArray.filter((filtered) => {return filtered%3 == 0});
 }

 //long way

 let filterInstructions = function(num){
     return (num%3 == 0);
 }

 function allDivisible (numArray){
     return numArray.filter(filterInstructions);
 }
