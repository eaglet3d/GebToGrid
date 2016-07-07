# Example Geb and Gradle Project

This project was derived from geb/geb-example-gradle.

[![Build Status][build_status]](https://snap-ci.com/geb/geb-example-gradle/branch/master)

## Description

This is an example of incorporating Geb into a Gradle build. It shows the use of Spock and JUnit 4 tests.

The build is setup to work with Firefox, Chrome and PhantomJS. Have a look at the `build.gradle` and the `src/test/resources/GebConfig.groovy` files.

## Usage

The following command will launch the test with the individual browser:

    ./gradlew firefoxTest

To run with all, you can run:

    ./gradlew test

Replace `./gradlew` with `gradlew.bat` in the above examples if you're on Windows.

## Questions and issues

Please ask questions on [Geb user mailing list][mailing_list] and raise issues in [Geb issue tracker][issue_tracker].


[build_status]: https://snap-ci.com/geb/geb-example-gradle/branch/master/build_image "Build Status"
[mailing_list]: https://groups.google.com/forum/#!forum/geb-user
[issue_tracker]: https://github.com/geb/issues/issues
