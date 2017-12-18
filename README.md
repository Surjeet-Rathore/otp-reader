Gradle Dependency: 
1. Add the AAR file: 1.Click File > New Module.
2.Click Import readotp.aar Package then click Next.
3.Enter the location of the AAR file then click Finish.2. Make sure the library is listed at the top of your settings.gradle file, as shown here for a library named "my-library-module": include ':app', ':readotp' 3. Open the app module's build.gradle file and add a new line to the dependencies block as shown in the following snippet: dependencies {     compile project(':readotp') } 
4. Using default configuration: UsePermissions.getInstance().permissions(MainActivity.this);SMSReceiver.requestData(this,"network provider"); Override  messageBody(message)
