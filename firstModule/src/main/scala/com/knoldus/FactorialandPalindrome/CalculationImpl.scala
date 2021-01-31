package com.knoldus
import java.io.IOException

trait Calculation{
  def isPalindrome(number: Int): Boolean
  def getFactorial(digit: Int): Int
}


class CalculationImpl extends Calculation{

    // It will return if a number is palindrome or not
    def isPalindrome(number: Int): Boolean = {

        // Negetive number not allowed
        if(number<0)
            throw new IllegalArgumentException("Negetive number not allowed")

        var copy_number: Int = number
        var remainder = 0
        var reverse = 0

        while (copy_number > 0) {
            remainder = copy_number % 10
            reverse = reverse * 10 + remainder
            copy_number = copy_number / 10
        }

        if (reverse == number)
            true
        else
            false

    }
    // It will return factorial of a number
    def getFactorial(number: Int): Int={

        // Negetive number not allowed
        if(number<0)
            throw new IllegalArgumentException("Negetive number not allowed") 

        var result: Int = 1
        for (increment <- 2 to number) {
            result *= increment
        }
        result
    }
}


