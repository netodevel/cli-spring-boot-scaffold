
# spring-boot-scaffold-kotlin

[![Join the chat at https://gitter.im/spring-boot-scaffold-kotlin/Lobby](https://badges.gitter.im/spring-boot-scaffold-kotlin/Lobby.svg)](https://gitter.im/spring-boot-scaffold-kotlin/Lobby?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
 [![bagde](https://codeship.com/projects/e4a1d8b0-8b71-0134-1c87-26c6b97868f1/status?branch=master)](https://codeship.com/projects/184622)

#About
Generate api scaffold kotlin with spring boot rest, creating a api rest with kotlin and spring boot in an easy and productive way.

Scaffold for java web, a clean generate with simple classes.
        
#Alert
In development. Help us! Make a fork!

#Requeriments
         
* java
* Spring Boot CLI (1.4.1 or higher):

#Install
 
    $ spring version
    Spring CLI v1.4.1.RELEASE

And install the Spring Scaffold plugin

    $ mvn install
    $ spring install br.com.netodevel:spring-scaffold-cli:0.0.1-SNAPSHOT


#Usage

    $ spring init my-project
    $ cd my-project
    $ spring scaffold -n User -p name:String email:String

#Structure

    __br
       __com
           __scaffold
                    MainApplication.java
                    __domain
                          User.kt
                    __repository
                          UserRepository.kt
                    __service
                          UserService.kt
                    __controller
                          UserController.kt


| HTTP Status   | Endpoints     | Function       |
| ------------- |:-------------:| -----:         |
| GET           | /users        | list all users |
| GET           | /users/{id}   | show user      |
| POST          | /users        | save user      |
| PUT           | {id}/users    | update user    |
| DELETE        | {id}/users    | delete user    |


###Acknowledgment
         
 * [Bruno Lima](https://github.com/brunodles)
 * [Ivan Marreta](https://github.com/ivanmarreta)
       

