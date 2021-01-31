package com.knoldus.db

import com.knoldus.models.User
import scala.collection.immutable.HashMap

 class UserReadDto {

  // Dummy data for user
  val user1: User = User("Koushik","Dhar","knoldus","koushik@gmail.com","password")
  val user2: User = User("Suman","Saha","knoldus","suman.saha@knoldus.com","password")


  val users: HashMap[String, User] = HashMap("Koushik" -> user1, "Suman" -> user2)
  
  // It will return user name if exist
  def getUserByName(name: String): Option[User] = users.get(name)
}
