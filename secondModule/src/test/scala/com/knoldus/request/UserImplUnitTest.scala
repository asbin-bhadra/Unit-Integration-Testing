package com.knoldus.request
import com.knoldus.models.{Company, User}
import org.scalatest.flatspec.AnyFlatSpec
import com.knoldus.validator.UserValidator
import org.mockito.MockitoSugar.{mock, when}

class UserImplUnitTest extends AnyFlatSpec {

  val mockedUserValidate = mock[UserValidator]
  val user1: User = User("suraj","Sharma","knoldus","suraj@knoldus.com","password")
  val user2: User = User("Koushik","Dhar","knoldus","koushik@gmail.com","password")
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  "User" should "be valid" in {
    val userImpl = new UserImpl(mockedUserValidate)
    when(mockedUserValidate.userIsValid(user2)) thenReturn (true)
    val result = userImpl.createUser(user2)
    assert(!result.isEmpty)
  }

  it should "be not valid" in {
    val userImpl = new UserImpl(mockedUserValidate)
    when(mockedUserValidate.userIsValid(user1)) thenReturn (false)
    val result = userImpl.createUser(user1)
    assert(result.isEmpty)
  }
}
