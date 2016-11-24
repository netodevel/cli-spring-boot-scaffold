 [![bagde](https://codeship.com/projects/e4a1d8b0-8b71-0134-1c87-26c6b97868f1/status?branch=master)](https://codeship.com/projects/184622)
# spring-boot-scaffold-kotlin

[![Join the chat at https://gitter.im/spring-boot-scaffold-kotlin/Lobby](https://badges.gitter.im/spring-boot-scaffold-kotlin/Lobby.svg)](https://gitter.im/spring-boot-scaffold-kotlin/Lobby?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

#About
Generate api scaffold kotlin with spring boot rest, creating a api rest with kotlin and spring boot in an easy and productive way.

Scaffold for java web, a clean generate with simple classes.



#Architecture

           __br
              __com
                  __scaffold
                           MainApplication.java
                           __domain
                                 Model.kt
                           __repository
                                 Repository.kt
                           __service
                                 Service.kt
                           __controller
                                 Controller.kt
        
#Alert
In development. Help us! Make a fork!

#Requeriments
         
* java

#Install 

 Acess the branch [install](https://github.com/NetoDevel/spring-boot-scaffold-kotlin/tree/install)


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
* gradle support
* generate Test JUnit @SpringBootTest
* sample using scaffold
* remove prefix cli

###Acknowledgment
         
 * [Bruno Lima](https://github.com/brunodles)
 * [Ivan Marreta](https://github.com/ivanmarreta)
       

