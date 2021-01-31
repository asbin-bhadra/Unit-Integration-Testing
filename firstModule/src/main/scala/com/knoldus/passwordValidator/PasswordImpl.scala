package com.knoldus.Password

class PasswordImpl{
  
  // It validate if a given combination is valid for password or not
  def isValidPassword(password: String): Boolean ={
    var regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.\\S)(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$"
    return password.matches(regex)
  } 
}
