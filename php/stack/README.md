# Stack

Implement a Stack data structure. A stack supports adding and removing elements of any data type (although you can start with strings or integers). Elements are added/removed one at a time. An element is always added to the top of the stack. Only the top of the stack can be removed. This ordering of operations is known as Last In, First Out (LIFO).

The Stack supports the following operations:

**Push** adds an element to the top of the stack.\
**Pop** retrieves the most recently added element and removes it from the stack.\
**Peek** retrieves the most recently added element without removing it.\
**Size** returns the number of elements.\
**isEmpty** returns true when there are no elements in the stack.

## Language Notes

- PHP language level 7.1
- PHPUnit 9.5.2

Install project dependencies with the command
```
composer install
[or]
php composer.phar install
```

Run the unit tests with the command:
```
phpunit tests/StackTest.php
```
