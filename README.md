
# spring-boot-scaffold

[![Join the chat at https://gitter.im/spring-boot-scaffold-kotlin/Lobby](https://badges.gitter.im/spring-boot-scaffold-kotlin/Lobby.svg)](https://gitter.im/spring-boot-scaffold-kotlin/Lobby?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
 [![bagde](https://codeship.com/projects/e4a1d8b0-8b71-0134-1c87-26c6b97868f1/status?branch=master)](https://codeship.com/projects/184622)

#About
Generate api scaffold with spring boot rest, creating a api rest with and spring boot in an easy and productive way.

Scaffold for java/kotlin web, a clean generate with simple classes.


        
#Alert
In development. Help us! Make a fork!

#Requeriments
         
* java
* Spring Boot CLI (1.4.1 or higher):

#Install
 
    $ spring version
    Spring CLI v1.4.1.RELEASE

And install the Spring Scaffold plugin

    $ git clone https://github.com/NetoDevel/cli-spring-boot-scaffold.git
    $ cd spring-boot-scaffold
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
                          User.java
                    __repository
                          UserRepository.java
                    __service
                          UserService.java
                    __controller
                          UserController.java


| HTTP Status   | Endpoints     | Function       |
| ------------- |:-------------:| -----:         |
| GET           | /users        | list all users |
| GET           | /users/{id}   | show user      |
| POST          | /users        | save user      |
| PUT           | /users        | update user    |
| DELETE        | {id}/users    | delete user    |


#Documentation

|Commands   |Parameters                                 |Examples
| ------------- |:-------------:                         | -------------:  
| spring model  | -n className -p parameters -l language | spring model -n User -p name:String -l (java or kotlin)
| spring repository  | -n className  -l language         | spring repository -n User -l (java or kotlin)
| spring service  | -n className  -l language            | spring service -n User -l (java or kotlin)
| spring controller  | -n className  -l language         | spring controller -n User -l (java or kotlin)
| spring scaffold  | -n className -p parameters -l language | spring scaffold -n User -p name:String -l (java or kotlin)


#License

    The MIT License (MIT)

    Copyright (c) 2016 Felipe Oliveira

    Permission is hereby granted, free of charge, to any person obtaining a 
    copy of this software and associated documentation files (the "Software"), 
    to deal in the Software without restriction, including without limitation 
    the rights to use, copy, modify, merge, publish, distribute, sublicense, 
    and/or sell copies of the Software, and to permit persons to whom the Software is 
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included 
    in all copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
    INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR 
    PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE 
    FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
    ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

###Acknowledgment
         
 * [Bruno Lima](https://github.com/brunodles)
 * [Ivan Marreta](https://github.com/ivanmarreta)
       

