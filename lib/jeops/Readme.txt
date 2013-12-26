                                README

          JEOPS - The Java Embedded Object Production System
                          Version 2.1 beta 1

* Introduction
* Features
* System Requirements
* Installation
* License

Introduction

     Thank you for downloading JEOPS - the Java Embedded Object
     Production System. JEOPS is a tool which aims to provide the
     declarativeness of production rules to the Java language. By
     providing such a capability, the creation of applications that
     require some level of "intelligence", such as intelligent agents,
     is facilitated due to the separation of the reasoning and the
     procedural aspects of the system.

Features

     JEOPS implements a first-order, forward-chaining inference engine
     that can be embedded into Java applications. In contrast to other
     production systems available, the facts that can be stored in the
     knowledge base are not simple named tuples - any Java object can
     be stored as a fact, which gives the developer a higher degree of
     freedom to chose which aspects of the reasoning should be coded
     as rules, and which can be embodied into the objects themselves.

     JEOPS also allows the user to select the conflict resolution
     policy to be applied when more than one rule can be instantiated
     at the same time. If the predefined policies do not suit the
     user needs, there is the possibility of implementing a new one,
     without affecting the remaining of the system.

     The complete list of features of JEOPS are described in the user
     manual, which is available online in the following URL:
            http://www.cin.ufpe.br/~csff/jeops/manual
     The manual also contains some sample applications build using
     JEOPS, in order to provide the users a more thorough feel of how
     to use the system.

System Requirements

     JEOPS was developed entirely in Java. This makes it ready to be
     used in virtually any hardware platform or operational system
     that supports a Java Virtual Machine. JEOPS v2.1 can be used
     only with Java version 1.2.x and above; JEOPS v2.0 can be
     used with Java 1.1.x.

Installation

     JEOPS is divided into two subsystems: the Compiler and
     the Runtime Environment. The compiler is used to translate
     the rules into java files, and the runtime environment
     embodies the classes the generated java file needs. The
     compiler is needed for the development of the application,
     but only the runtime environment needs to be deployed with
     the application. It is the same division that happens with
     the JDK/JRE packages, distributed by Sun.

     To install the JEOPS Compiler, you should extract the
     JEOPS.jar file from the ZIP file that can be obtained from
     JEOPS Home Page (in http://www.cin.ufpe.br/~csff/jeops).
     Then, you must place it into the CLASSPATH environment
     variable. For example, if you extract it into the directory
     C:\jdk\classes, including the following line in the end of
     the AUTOEXEC.BAT will set the system to work with the JEOPS
     Compiler:

     set CLASSPATH=%CLASSPATH%;C:\jdk\classes\JEOPS.jar

     Under unix/linux systems, if the file was extracted into the
     /usr/local/bin/classes directory, the following command will set
     the classpath environment variable so that JEOPS Compiler can be
     used:

     setenv CLASSPATH=$CLASSPATH:/usr/local/bin/classes/JEOPS.jar

     Actually, the syntax of the command above can be slightly
     different, depending on the unix shell that is being used.

     In the same way, installing the JEOPS Runtime Environment can be
     done by extracting the JeopsRE.jar file and putting it into the
     classpath environment variable.

License

     JEOPS is distributed under the GNU Lesser General Public License.
     Please refer to the License.txt file packaged with JEOPS for the
     complete license terms.

--------------------------------------------------------------------
JEOPS is research product developed in the Center of Informatics of
the Federal University of Pernambuco. The latest version of the
original product, as well as its source code and sample applications
can be obtained at http://www.cin.ufpe.br/~csff/jeops
