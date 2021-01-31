package com.knoldus
import org.scalatest.flatspec.AnyFlatSpec

class CalculationImplTest extends AnyFlatSpec{
    val obj = new CalculationImpl
    "Factorial" should "be possitive" in {
        var result: Int= obj.getFactorial(5)
        assert(result == 120)
    }

    it should "through IllegalArgumentException if negetive number provided" in {
        assertThrows[IllegalArgumentException] {
            obj.getFactorial(-6)
        }
    }
    it should "return 1 if 0 is provided" in {
        var result: Int= obj.getFactorial(0)
        assert(result == 1)
    }
    it should "return 1 if 1 is provided" in {
        var result: Int= obj.getFactorial(1)
        assert(result == 1)
    }


    "Palindrome" should "return true if given number is palindrome" in {
        var result: Boolean= obj.isPalindrome(101)
        assert(result == true)
    }
    it should "return false if given number is not palindrome" in {
        var result: Boolean= obj.isPalindrome(100)
        assert(result == false)
    }
    it should "through IllegalArgumentException if negetive number provided" in {
        assertThrows[IllegalArgumentException] {
        obj.isPalindrome(-6)
        }
    }
}