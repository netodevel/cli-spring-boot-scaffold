# spring-boot-scaffold-kotlin

#About
Generate api scaffold kotlin with spring boot rest, create api rest with kotlin and spring boot easy and productive.


#Alert
In development, help us make a fork!

#Requeriments
         
* java
* nodejs


#Install
         npm install spring-boot-api-scaffold@0.0.1

#Usage

###Create project

         cli -spring g new my-project

###Generate model
   
        cli -spring g model User mail:String password:String

###Generate repository

        cli -spring g repository User 

###Generate service
        
        cli -spring g service User
        
###Generate controller

        cli -spring g controller User
        
###Generate scaffold

        cli -spring g scaffold User mail:String password:String

###Todo

* validates types variables
* validates exists project,class
* set package to generate
* install linux/windows single package node
* gradle support
* generate Test JUnit @SpringBootTest
* sample using scaffold
* remove prefix cli

###Acknowledgment
         
 * [Bruno Lima](https://github.com/brunodles)
 * [Ivan Marreta](https://github.com/ivanmarreta)
       

