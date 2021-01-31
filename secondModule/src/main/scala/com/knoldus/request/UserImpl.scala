package com.knoldus.request

import com.knoldus.models.User
import com.knoldus.validator.UserValidator

class UserImpl(userValidator: UserValidator) {

  // Create User if company is exist
  def createUser(user: User): Option[String] = {
    if (userValidator.userIsValid(user)) Option(user.emailId)
    else None
  }
}
