package com.knoldus.validator
import org.scalatest.flatspec.AnyFlatSpec

class EmailValidatorTest extends AnyFlatSpec {
  val emailValidator = new EmailValidator
  "email" should "have alphanumeric recipient name in lowercase and/or uppercase " in {
    var result: Boolean = emailValidator.emailIdIsValid("asbin@knoldus.com")
    assert(result == true)
  }

  it should "valid when with starting numbers" in {
    var result: Boolean = emailValidator.emailIdIsValid("191020307002asbin@knoldus.com")
    assert(result == true)
  }
  it should "valid when recipient name has dot and underscore" in {
    var result: Boolean = emailValidator.emailIdIsValid("191020307002.asbin-bhadra@knoldus.com")
    assert(result == true)
  }

  it should "invalid with missing @" in {
    var result: Boolean = emailValidator.emailIdIsValid("asbinknoldus.com")
    assert(result == false)
  }

  it should "invalid with starting with special symbols except dot and underscore" in {
    var result: Boolean = emailValidator.emailIdIsValid("*/asbin@knoldus.com")
    assert(result == false)
  }

  it should "invalid with space in between" in {
    var result: Boolean = emailValidator.emailIdIsValid("asbin @knoldus.com")
    assert(result == false)
  }

  it should "invalid with missing top level domain" in {
    var result: Boolean = emailValidator.emailIdIsValid("asbin@gmail")
    assert(result == false)
  }

  it should "invalid with missing main domain" in {
    var result: Boolean = emailValidator.emailIdIsValid("asbin@.com")
    assert(result == false)
  }

  it should "invalid when wrong top level domain except .com/.org/.net" in {
    var result: Boolean = emailValidator.emailIdIsValid("asbin@gdgu.live")
    assert(result == false)
  }

  it should "invalid with more than one top level domain" in {
    var result: Boolean = emailValidator.emailIdIsValid("asbin@knoldus.com.net")
    assert(result == false)
  }

  it should "invalid with double dots after domain name" in {
    var result: Boolean = emailValidator.emailIdIsValid("gaurav@knoldus..com")
    assert(result == false)
  }
}
