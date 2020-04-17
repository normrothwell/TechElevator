/*
    Example of a multi-line comment just like in C#/Java
*/

// Single line comment

/**
 * Functions start with the word function.
 * They don't have a return type and the naming convention is camel-case.
 */
function variables() {
  console.log('JavaScript');
  let myStrVariable = "A really neat String variable";
  let myNumVariable = 3;
  let myNumberVariable = 99;
  let myBoolVariable = false;

  let myArray = [3, 4, 32, 12];

  const constant = 7.28;

  let arrayWithDifferentTypes = [3.14, 'pi', '3.14', true];
  let first = arrayWithDifferentTypes[0];
  let second = arrayWithDifferentTypes[1];
  let third = arrayWithDifferentTypes[2];
  let fourth = arrayWithDifferentTypes[3];

  console.log(typeof first);
  console.log(typeof second);
  console.log(typeof third);
  console.log(typeof fourth);


}

/**
 * Functions can also accept parameters.
 * Notice the parameters do not have types.
 * @param {Number} param1 The first number to display
 * @param {Number} param2 The second number to display
 */
function printParameters(param1 = 1, param2 = 999) {

  console.log(`The value of parameter 1 is ${param1}`);
  console.log(`The value of parameter 2 is ${param2}`);

}

/**
 * Compares two values x and y.
 * == is loose equality
 * === is strict equality
 * @param {Object} x
 * @param {Object} y
 */
function equality(x, y) {

  console.log(' x == y ' + (x==y));
  console.log(' x === y ' + (x===y));

}

/**
 * Each value is inherently truthy or falsy.
 * false, 0, '', null, undefined, and NaN are always falsy
 * everything else is always truthy
 * @param {Object} x The object to check for truthy or falsy,
 */
function falsy(x) {

  if (x) {
    console.log(x + ' is truthy');
  }
  else {
    console.log (x + ' is falsy');
  }

}

/**
 *  Objects are simple key-value pairs
    - values can be primitive data types
    - values can be arrays
    - or they can be functions
*/
function objects() {

  const person = {
    firstName: 'Bobby',
    lastName: 'Tables',
    age: 7,
    employees: ['Bob Ross', 'Big McLargehuge', 'Punch Hardkick', 'Slap Beeefstick'],
    toString: function() {
      return this.firstName + ' ' + this.lastName + ' ' + this.employees;
    }
  }
console.log(person.firstName + ' ' + person.lastName);
console.log(person.employees);
console.log(person.toString());
}

/*
########################
Function Overloading
########################

Function Overloading is not available in Javascript. If you declare a
function with the same name, more than one time in a script file, the
earlier ones are overriden and the most recent one will be used.
*/

function Add(num1, num2) {
  return num1 + num2;
}

function Add(num1, num2, num3) {
  return num1 + num2 + num3;
}

/*
########################
Math Library
########################

A built-in `Math` object has properties and methods for mathematical constants and functions.
*/

function mathFunctions() {
  console.log("Math.PI : " + Math.PI);
  console.log("Math.LOG10E : " + Math.LOG10E);
  console.log("Math.abs(-10) : " + Math.abs(-10));
  console.log("Math.floor(1.99) : " + Math.floor(1.99));
  console.log("Math.ceil(1.01) : " + Math.ceil(1.01));
  console.log("Math.random() : " + Math.random());
}

/*
########################
String Methods
########################

The string data type has a lot of properties and methods similar to strings in Java/C#
*/

function stringFunctions(value) {

  let myStr = 'The lamp';

  console.log(myStr.length);
  console.log(myStr.substring(4, 6));
  console.log(myStr.substring(4));


  /*
    Other Methods
        - split(string)
        - substr(number, number)
        - substring(number, number)
        - toLowerCase()
        - trim()
        - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String
    */
}
