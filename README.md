Pre-requisite to run tests
-----------------------------------
1. Maven should be available on PC.
2. PC is configured with maven home and Java home.

To run test via command prompt
-----------------------------------
1. Pull the framework to your local directory
2. Open command prompt.
3. cd to the directory where the framework is located.
4. Do "mvn compile" (to compile the framework and download all dependencies)
5. Do "mvn install test" (to run all tests)

NOTE:
-----------------------------------
Cart.feature test is failing as expected due the functionality NOT being present on the web application.