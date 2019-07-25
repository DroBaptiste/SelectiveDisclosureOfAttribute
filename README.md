# SelectiveDisclosureOfAttribute
###### By @MezredMenad and @DroBaptiste

This project is based on an internship made in 2019 in Reggio di Calabria, Italy

### Summary
* [How it works](#how-it-works) 
* [Components](#components) 
  * [Registration](#registration-pencil)   
  * [Consulting](#consulting-eyes) 
  * [Utility](#utility-wrench)   
    * [Assertion](#assertion)
    * [XML](#xml)
    * [CryptoUtils](#cryptoutils)
    * [Randomize](#randomize)
    * [Web3Utils](#Web3Utils)
   

# How it works

To use this java application with tomcat you first need to create a jsonfile ```config.json``` in your tomcat bin repository including a ```domain``` field your domain (for exemple https://myDomain.com).

# Components

## Registration :pencil:

The content of ```src/main/java/servlet/register``` is related to the Registration tool.

## Consulting :eyes:

The content of ```src/main/java/servlet/consult``` is related the Consulting tool.

## Utility :wrench:

the folder ```src/main/java/utils``` contains all the utility function.

##### Assertion

Assertion folder contains all the functions and class needed to create  assertions.

##### XML

XML folder contains all the classes and functions needed to manipulate XML files

##### CryptoUtils

CryptoUtils contain the function needed to hash the contain to place in the blockchain such as the assertion

##### Randomizer

This folder contains a function to generate random name that we use to place the assertion or generate a random challenge

##### Web3Utils

This folder contains the function we use to interact with ethereum blockchain using Web3j dependency.
