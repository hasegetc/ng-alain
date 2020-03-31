# Grails ng-alain Profile

## Introduce

grails ng-alain  profile is integrate grails restful api and [an-algin](<https://ng-alain.com/zh>). the an-algin is out-of-box UI solution for enterprise applications, let developers focus on business, built on the design principles developed by [Ant Design](https://ant.design/)

I holp it can auto generate curd views and restapi with a command

## How to use

- git clone https://github.com/hasegetc/ng-alain.git

- cd ng-alain

- ./gradlew publishToMavenLocal

- install grails and ant-design environment

- grails create-app grails-alain-test --profile=org.grails.profiles:ng-alain:0.9.1.BUILD-SNAPSHOT

- cd grails-alain-test/client and run `npm install` to make sure js dependecy install

- create a domain class, for example, Address.groovy

- cd grails-alain-test/server

- run grails ng-alain-curd Address to generate curd componets or grails ng-alain-list Address、 grails ng-alain-view Address、grails ng-alain-edit Address to generator single views

## Todo

now the generator views's field is not changed by the grails model file,  next step I hope it can generator views based on the grails model file, and I was work on it

