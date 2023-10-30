# SO-mvn-question
mvn 3.1.2/3.6.1 bug (or maybe feature)

This repo is related to SO question https://stackoverflow.com/questions/77360885/maven-dependency-plugin-3-6-started-to-find-new-used-undeclared-dependencies

Shortly: mvn clean install works differently for versions prior to 3.6.+ (in my case 3.1.2, but others also) and 3.6.+ (3.6.0, 3.6.1) 

to test run (will fail)
mvn clean install

then uncomment in pom.xml 3.1.2 version and do the same (will work)
mvn clean install
