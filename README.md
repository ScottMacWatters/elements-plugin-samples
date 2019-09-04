# elements-plugin-samples

Elements is a Java application framework that leverages Groovy to configure and associate independent Java classes into a single runnable provision. 

Elements is a rich framework with many complicated features built in. These are very valuable for larger applications, but many users of Elements do not need every potential feature offered. 

At its core, Elements is a simple way to start applicaitons using groovy configuration files. This shows an example of that using an Elements Gradle Plugin to quickly start the application. 

To learn more about elements, check it out on github here: https://github.com/futehkao/elements

# Notable Files

This project contains two java classes which are configured and run independently of eachother using Elements. These java classes are:

* HelloWorld -- This class simply logs a configured message at a configured interval
* HelloAPI -- This class uses standard JAX-RS annotations to expose a very simple web service. 

# Startup Basics

Launching an Elements application is done using the Main class here:
* net.e6tech.elements.common.launch.Launch (https://github.com/futehkao/elements/blob/master/common/src/main/java/net/e6tech/elements/common/launch/Launch.java)

This class will start the provided launch script (variable "launch") and start the application. 

Using the Elements Gradle plugin, there are a few ways to start the application:
* From Gradle, tasks will be created from any launch scripts in the project. See the gradle plugin for details on configuring this further
* From installDist: run installDist and in the build/install/{app-name}/bin directory, there will be launch scripts created
* From distTar/distZip: Run these, distribute to a necessary server, extract and run using scripts in the bin directory. 

In this example, there are 3 different launch scripts provided:
* Main -- Starts the API & Hello World Logger
* NoAtoms -- Starts the API only
* NoApi -- Starts the Hello World Logger only

# Startup Flow

For this example, let's assume you start using the main script at this location:
* conf/provisioning/sm/dev/main.groovy

This script sets the environment to 'dev' and runs the script  conf/provisioning/sm/etc/launch.groovy. It is generally good practice to set environment and other environment-specific variables here (or run environment-specific scripts), then pass off the majority of the work to a script in the /etc/ directory. For projects with many environments and many provisions for the same environment, this allows for maximum code sharing between dev/prod/uat and other environments to ensure consistent testing. 

In the /etc/launch.groovy script, it does the following:
* Establishes system properties
  * Currently, only logging is configured this way as it has a path to the log4j2.xml file
* Configures Preboot steps 
  *  Currently empty
* Configures Boot steps 
  *  Currently empty
* Configures After Boot steps 
  *  This adds the /atoms/ and /restful/ directories to run after boot. 

The net result of this is that the applicaiton starts with the following 3 things configured:
* Logging
* HelloWorld
* JaxRS server running the HelloAPI
