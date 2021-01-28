package me.khazaddum.scalacheck

import java.util.UUID

import me.khazaddum.UnitTest
import org.scalacheck.{ Arbitrary, Gen }
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ScalaCheckTest extends AnyFlatSpec with Matchers {

  behavior of "Generator"

  it should "be created from basic builder" taggedAs UnitTest in {

    val AccountNumberGen: Gen[String] = for {
      no <- Gen.choose( 1L, 99999999L )
    } yield "%08d".format( no )

    AccountNumberGen.sample.isDefined shouldBe true

  }

  it should "be created from a custom Generator trait" taggedAs UnitTest in {

    trait Generator[A] {
      def gen: Gen[A]
      def arb: Arbitrary[A] = Arbitrary.apply( gen )
      def sample: A = gen.sample.get
    }

    object AccountNumberGenerator extends Generator[String] {
      val gen: Gen[String] = for {
        no <- Gen.choose( 1L, 99999999L )
      } yield "%08d".format( no )
    }

    AccountNumberGenerator.gen.sample.isDefined shouldBe true
    AccountNumberGenerator.sample.length shouldBe 8

  }

  it should "be created from a case class" taggedAs UnitTest in {

    case class Account( no: String, balance: Double )

    val AccountGenerator: Gen[Account] = for {
      no <- Gen.choose( 1L, 99999999L ).map( "%08d".format( _ ) )
      balance <- Gen.choose[Double]( 1, 1000000 )
    } yield Account( no, balance )

    AccountGenerator.sample.isDefined shouldBe true

  }

  behavior of "Misc Generators"

  it should "include ''" taggedAs UnitTest in {
    /*
    val gen =
    val gen = Gen.calendar
    val gen = Gen.finiteDuration
    val gen = Gen.duration
    */
  }

  behavior of "Number Generators"

  it should "include ''" taggedAs UnitTest in {
    /*
    val gen = Gen.posNum
    val gen = Gen.negNum
    val gen = Gen.chooseNum
    */
  }

  behavior of "String Generators"

  it should "include ''" taggedAs UnitTest in {
    /*
    val gen = Gen.identifier
    val gen = Gen.numStr
    val gen = Gen.alphaUpperStr
    val gen = Gen.alphaLowerStr
    val gen = Gen.alphaStr
    val gen = Gen.alphaNumStr
    val gen = Gen.asciiStr
    val gen = Gen.asciiPrintableStr
    */
  }

  behavior of "Character Generators"

  it should "include ''" taggedAs UnitTest in {
    /*
    val gen = Gen.numChar
    val gen = Gen.alphaUpperChar
    val gen = Gen.alphaLowerChar
    val gen = Gen.alphaChar
    val gen = Gen.alphaNumChar
    val gen = Gen.asciiChar
    val gen = Gen.asciiPrintableChar
    */
  }

  it should "include 'alphaUpperChar'" taggedAs UnitTest in {

    val NameGenerator: Gen[String] = for {
      upperChar <- Gen.alphaUpperChar.map( _.toString )
      chars <- Gen.listOfN( 10, Gen.alphaLowerChar ).map( _.mkString )
    } yield s"$upperChar$chars"

    NameGenerator.sample.isDefined shouldBe true

  }

  behavior of "List Generators"

  it should "include ''" taggedAs UnitTest in {
    /*
    val gen = Gen.buildableOfN
    val gen = Gen.buildableOf
    val gen = Gen.nonEmptyBuildableOf
    val gen = Gen.containerOfN
    val gen = Gen.containerOf
    val gen = Gen.nonEmptyContainerOf
    val gen = Gen.listOf
    val gen = Gen.nonEmptyListOf
    val gen = Gen.mapOf
    val gen = Gen.nonEmptyMap
    val gen = Gen.mapOfN
    val gen = Gen.nonEmptyMap
    val gen = Gen.mapOfN
    val gen = Gen.infiniteStream
    val gen = Gen.someOf
    val gen = Gen.atLeastOne
    val gen = Gen.resultOf
    val gen = Gen.function0
    */
  }

  it should "include 'listOfN'" taggedAs UnitTest in {

    val EmailGenerator: Gen[String] = for {
      name <- Gen.listOfN( 10, Gen.alphaLowerChar ).map( _.mkString )
      domain <- Gen.listOfN( 10, Gen.alphaLowerChar ).map( _.mkString )
    } yield s"$name@$domain"

    EmailGenerator.sample.isDefined shouldBe true

  }

  it should "include 'oneOf'" taggedAs UnitTest in {

    val CurrencyGenerator: Gen[String] = for {
      value <- Gen.oneOf( "BRL", "CAD", "COP", "EUR" )
    } yield value

    CurrencyGenerator.sample.isDefined shouldBe true

  }

  it should "include 'pick'" taggedAs UnitTest in {

    val CurrenciesGenerator: Gen[Seq[String]] = for {
      values <- Gen.pick( 3, List( "AUD", "BRL", "CAD", "CNY", "COP", "EUR" ) )
    } yield values

    CurrenciesGenerator.sample.isDefined shouldBe true

  }

  behavior of "Generator Combinators"

  it should "include ''" taggedAs UnitTest in {
    /*
    val gen = Gen.fail
    val gen = Gen.choose
    val gen = Gen.sequence
    val gen = Gen.delay
    val gen = Gen.parameterized
    val gen = Gen.sized
    val gen = Gen.size
    val gen = Gen.resize
    val gen = Gen.oneOf
    val gen = Gen.option
    val gen = Gen.some
    val gen = Gen.frequency
    val gen = Gen.freqTuple
    */
  }

  it should "include 'const'" taggedAs UnitTest in {

    val UuidGenerator: Gen[UUID] = for {
      _ <- Gen.const( () )
    } yield UUID.randomUUID()

    UuidGenerator.sample.isDefined shouldBe true

  }

}