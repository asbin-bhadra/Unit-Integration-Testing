package com.knoldus.request
import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import com.knoldus.validator.{CompanyValidator, EmailValidator}
import org.scalatest.flatspec.AnyFlatSpec

class CompanyImplIntegrationTest extends AnyFlatSpec {
  val companyReadDto = new CompanyReadDto
  val emailValidator = new EmailValidator
  val companyValidator = new CompanyValidator(companyReadDto, emailValidator)
  val companyImpl = new CompanyImpl(companyValidator)


  "Company" should "be valid" in {
    val googleCompany: Company = Company("Google", "google@gmail.com", "Noida")
    val result =  companyImpl.createCompany(googleCompany)
    assert(!result.isEmpty)
  }

  it should "be invalid as it already exists in DB" in {
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
    val result =  companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }

  it should "be invalid as email id is invalid" in {
    val googleCompany: Company = Company("Google", "googlegmail.com", "Noida")
    val result =  companyImpl.createCompany(googleCompany)
    assert(result.isEmpty)
  }

  it should "be invalid as email id is invalid and company already exists in DB" in {
    val knoldusCompany: Company = Company("Knoldus", "knoldusgmail.com", "Noida")
    val result =  companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }


}
