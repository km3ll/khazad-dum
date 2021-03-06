# middle-earth

![statementcoverage](https://img.shields.io/badge/statement%20coverage-100.00%25-brightgreen.svg)![statementcoverage](https://img.shields.io/badge/branch%20coverage-100.00%25-brightgreen.svg)

## Table of contents

* [packages](#packages)
* [commands](#commands)
* [tools](#tools)
* [references](#references)

### packages

- akka-http
- cqrs
- eventstore
- frdm
- gatling
- protobuf
- scaffeine
- scalacheck 

### commands

```
sbt me
sbt "testOnly -- -n unit"
sbt "testOnly -- -n component"

sbt gatling:test
sbt "gatling:testOnly me.khazaddum.gatling.AppSimulation"
```

### tools

- jmeter
- postman
- swagger

### references

- [akka-http](https://doc.akka.io/docs/akka-http/current/server-side/low-level-api.html)
- [cats](https://typelevel.org/cats/)
- [circe](https://circe.github.io/circe/)
- [functional and reactive domain modeling](https://github.com/debasishg/frdomain)
- [gatling](https://gatling.io/docs/current/extensions/sbt_plugin/)
- [jmeter user-manual](https://jmeter.apache.org/usermanual/index.html)
- [jmeter controllers](https://www.guru99.com/controllers-in-jmeter.html)
- [sbt-protoc](https://github.com/thesamet/sbt-protoc)
- [scaffeine cache](https://github.com/blemale/scaffeine)
- [scalacheck](https://github.com/typelevel/scalacheck/blob/master/doc/UserGuide.md)
- [scala-logging](https://github.com/lightbend/scala-logging)
- [scalatest](https://www.scalatest.org/user_guide)
- [scoverage](https://github.com/scoverage/sbt-scoverage)
- [shields-io](https://shields.io/category/coverage)
- [swagger](https://editor.swagger.io/)
- [the neophyte's guide to scala](https://danielwestheide.com/blog/the-neophytes-guide-to-scala-part-8-welcome-to-the-future/)
