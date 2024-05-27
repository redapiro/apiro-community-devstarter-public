
APIRO DEV STARTER

* main class is au.com.acme.ApiroCustomBoot
* use JAVA SDK 21 or 22 (fyi we use temurin sdk packages you do not have to)
* if on unix we recommend SDKMAN for SDK management: https://sdkman.io/
* if on unix a convenience script to run mongo via docker is provided runMongoViaDocker.sh
* note - mongo MUST be run as a sharded cluster or replica set to support transactions. runMongoViaDocker.sh runs a repl set
* you MUST set the Java System Properties and Env variables outlined below or Apiro will not boot
* GIT1 configs are to bootstrap the public examples you may remove them and/or add your own writeable git repo
----

The following VM args must be set to bootstrap Apiro:

-Xmx6g -XX:+UseZGC -XX:+ZGenerational  --add-modules java.se --add-exports java.base/jdk.internal.ref=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.nio=ALL-UNNAMED --add-opens java.base/sun.nio.ch=ALL-UNNAMED --add-opens java.management/sun.management=ALL-UNNAMED --add-opens java.base/java.util=ALL-UNNAMED --add-opens jdk.management/com.sun.management.internal=ALL-UNNAMED

optionally, add the following java sysprops:

*the following may be set to kick off a feed or feeds automatically after bootstrap:
-Dimportfeed=<FEED_NAME> or ALL to run feeds at startup

*if making use of Selenium based web scraping have chrome installed and set chromedriver
-Dwebdriver.chrome.driver=<PATH TO CHROMEDRIVER>

*if using teseeract ocr set path to tesseract jna libraries
-Djna.library.path=<PATH TO TESSERACT LIBS>

----

The following environment variables should be set to bootstrap Apiro:

# seed to generate sys secret encryption key - do not change of you want to bootstrap examples
# because GIT1_PASS is encrypted by theis seed
APIRO_SYS_SECRET=knlfdafpjiu49q3tuhuhfa98uryu8twhaiehf8twiufahp849rhwafewr43wrfwe
# seed to generate jwt encryption key - you may change this
APIRO_JWT_SECRET=sdfgdfgsdfkgji5j09yt45gktrspogk0e9090gk0w9se0erfdogk490095635465
# generates a test admin apikey to call apii without loggin in
# can call api with headers apiKey=testkey and apiSecret=<APIRO_ADMINKEYSECRET>
# only for dev - do not use in prod
APIRO_ADMINKEYSECRET=93718395736384984363
APIRO_ADMINEMAIL=<YOUR EMAIL>;
APIRO_ADMINPW=pass123!
APIRO_ADMINUSER=admin

APIRO_INSTANCEID=DEV_STARTER

SPRING_PROFILES_ACTIVE=local
SPRING_DATA_MONGODB_URI=<MONGO URL> mongodb://localhost/apiro

GIT1_NAME=APIRO_EXAMPLES
GIT1_READONLY=true
GIT1_URL=https://github.com/redapiro/apiro_examples.git
GIT1_USER=apiropublic
GIT1_PASS=SFA3W75PcDXPDI/YYtJfDggwazLiwe33ePKqDskR1K8jAfVMCYnVoE/QqjTa5UkusRb+de9GzwmeQPOHVqiyYZOifc52Tn/7jtUU96W6toAdPnHCk+KanssMV0SdhxIp
GIT1_BRANCH=version1
GIT1_PREFIX=/config/

# GIT2_X -> your git repo - replace the above if you don't want to bootstrap examples

in addition apiro needs a scratchpad work directory to put temporary files so set this env variable:
APIRO_WORKDIR - an empty directory apirto uses for a few things it needs to generate files for

and, if using ExecutionDomains functionality set this env variable to a maven home directory:
MAVEN_HOME - points to a maven install home


