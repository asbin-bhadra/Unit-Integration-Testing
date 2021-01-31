package com.knoldus.Password

import org.scalatest.flatspec.AnyFlatSpec

class PasswordImplTest extends AnyFlatSpec {

  val password= new PasswordImpl()

  "Password" should "have all necessary features" in {
    val result = password.isValidPassword("Scala@543")
    assert(result)
  }

  it should "not contain any space" in {
    val result = password.isValidPassword("SCAL A@543")
    assert(!result)
  }

  it should "contain at least one digit" in {
    val result = password.isValidPassword("Scala@")
    assert(!result)
  }

  it should "contain minimum 8 Characters" in {
    val result= password.isValidPassword("Scala@")
    assert(!result)
  }

  it should "contain maximum 15 Characters" in {
    val result = password.isValidPassword("Scala@1234&87662666266626")
    assert(!result)
  }

  it should "contain at least one Lowercase Character" in {
    val result = password.isValidPassword("SCALA23%$")
    assert(!result)
  }

  it should "contain at least one Uppercase Character" in {
    val result = password.isValidPassword("scala2*56")
    assert(!result)
  }

  it should "contain at least one Special Character" in {
    val result = password.isValidPassword("Scala543")
    assert(!result)
  }

}