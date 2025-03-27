Below are the steps I followed to create the project from scratch. Please ensure dependencies are updated before importing and running the project.

Prerequisites:
Java JDK – I used jdk-24_windows-x64_bin
Maven – I used apache-maven-3.9.9-bin
Eclipse IDE (Ensure the following plugins are installed):
    Cucumber
    TestNG
    
Steps to Set Up and Run the Project:
1. Extract the ZIP file and import the extracted project in Eclipse using "Projects from File System or Archive."
2. If not already converted, right-click the project node → Configure → Convert to Cucumber Project.
3. Open CMD, navigate to the folder where pom.xml is located, and run: - mvn clean install
4. In Eclipse, right-click the project node → Maven → Update Project (Check "Force Update of Snapshots/Releases").
5. To run the test case:
6. Navigate to src/test/java/com.wu.automation.runners/TestRunner.java
7. Right-click TestRunner.java → Run As → TestNG Test.
8. Test results will be displayed in the Eclipse console. The generated report can be found at: target/cucumber-reports/cucumber.html


Automated Scenarios:
I have automated both Task 1 (Primary) and Task 2 (Optional). By default, the TestRunner file only executes Task 1 (Primary).

To switch between tasks, update the features path in TestRunner.java:

Task 1 (Primary):
features = "src/test/resources/features/pay_bills.feature"

Task 2 (Optional):
features = "src/test/resources/features/locations.feature"

OR to run both tasks in a sequence use below

features = "src/test/resources/features

If you have any questions or face any difficulties, feel free to reach out.
