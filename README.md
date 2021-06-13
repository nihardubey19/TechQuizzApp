# TechQuizzApp

This is a GUI desktop application built in Java using Swing and Oracle(server).<br>
Java with Swing works as a frontend part and Oracle sql Database works as as Backend.<br>

### Softwares Used :
    * Netbeans 8.2
    * Oracle 14g
    
In this Java Application, I have made a Quiz application which can be used to take exam in colleges, schools, and etc.
In this application, we have two panels:

1. Admin Panel
2. Student Panel

In Admin Panel,  the admin is allowed to set a Paper of different types of subjects, whichever he/she also edit the paper
whenever it required. Admin can register Student to take exam and also Admin can view Score of a particular Student or All
Students.

Now we move towards Student Panel, Student take exam using choose the subjects and Exam-id and the he/she allows to take the exam.
Once the test is finished he/she cannot be retake the same exam. The best part of the application is that, we don't have to create the result of the students.
As the student finishes the exam it will automatically generate the result and store it in the database. So,it reduces a lot of human efforts.
After all student can also seen his scores and Also Update his Password in his Panel.

****************************************************************************************

## Prerequisites for Running this Application in Client side

You must have JRE which is (Java Runtime Environment) and Oracle 14g or updated Database.<br>
Otherwise it will not run because all the java applications run on JVM which is present in JRE,  and cannot be installed directly the JVM. JRE is different from each OS.

Whenever you clone this application first you import the dmp file of this application which is present in ...TechQuizzApp/TechQuizzApp/src/ ..into oracle sql Database.

*  By using the command imp and then followed by database user, password  example :    imp username/password

 *  ps : before write the above command you must create the user in Oracle sql
 
have a look, how you will do this ->

![Image of oracle sql](https://github.com/nihardubey19/TechQuizzApp/blob/master/TechQuizzApp/src/techquizapp/Images/Screenshot%20(1833).png)

After all, the copy of dmp (crash dump file) will be stored in your user, or in otherwords all the tables are copied to your user.


Then Finally you can run this Amazing TechQuizzApp Java Desktop Application!

