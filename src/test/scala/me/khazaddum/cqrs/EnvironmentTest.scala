package me.khazaddum.cqrs

import me.khazaddum.Tags.UnitTest
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class EnvironmentTest extends AnyFlatSpec with Matchers {

  "LocalEnvironment" should "load application.conf file" taggedAs UnitTest in {

    val environment = Environment.local()
    environment.token should be( "test-token" )

  }

}
