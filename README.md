# Solution Company WebApp

### Setup project on IntelliJ

* Open project in IntelliJ

* maven clean, maven install

* add Tomcat runner and your environment variables

![](images/img1.PNG)
![](images/img2.PNG)

* make sure to have the right configuration by picking your tomcat server and deployment artifact


  ![](images/img4.PNG)
  ![](images/img5.PNG)


* add in Pom username and password so the tests can run

![](images/img3.PNG)

### Run project with Jenkins

* Download https://www.jenkins.io/download/ and make sure to install everything

* Create a new element freestyle project and configure it how you want

![](images/img7.PNG)

* Connect it with your github reporitory

![](images/img8.PNG)
![](images/img9.PNG)

* choose commands you want

![](images/img10.PNG)

* save your configure and run it

### Result:

![](images/img6.PNG)