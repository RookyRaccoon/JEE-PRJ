# Java Enterprise Edition Final Project - V1 *(1.0.0)*

## Team members

The team behind this project is composed of:
* [Camille Briand *(AmiralBl3ndic)*](https://github.com/AmiralBl3ndic)
* [Elodie Dehache *(RookyRaccoon)*](https://github.com/RookyRaccoon)
* [Jules Lagny *(RaEace)*](https://github.com/RaEace)


## How to setup and use the project

This project needs a bit of configuration (database connection configuration) to work, so be sure to follow these steps

### V 1.x.x

**In the first version of the project, the database connection was set thanks to the `web/WEB-INF/db.properties` file**

To make the database connection work, please modify the db.properties file accordingly to the database you want to connect to

```properties
dbUrl      = REPLACE_ME__DATABASE_JDBC_URL
dbUser     = REPLACE_ME__DATABASE_USER
dbPassword = REPLACE_ME__DATABASE_PASSWORD
jdbcDriver = com.mysql.jdbc.Driver
```

As you can see, this file awaits configuration, and you only have to plug in the right database url, database user and password
as well as the JDBC driver to use.
This is an example of good configuration with a locally hosted MySQL database:

```properties
dbUrl      = jdbc:mysql://localhost:3306/JEEPRJ
dbUser     = jee
dbPassword = jee
jdbcDriver = com.mysql.jdbc.Driver
``` 

### V 2.x.x

**In the second version of the project, the database connection is managed by the persistence provider, in this case [RedHat's Hibernate](https://hibernate.org/)**

The configuration for this version is a little more complicated, but still fairly simple:

1. Open the `src/java/META-INF/persistence.xml` file which contains the database configuration
2. Locate the following lines in this file:

```xml
<property name="javax.persistence.jdbc.driver" value="REPLACE_ME__JDBC_DRIVER" />
<property name="javax.persistence.jdbc.url" value="REPLACE_ME__DATABASE_JDBC_URL" />
<property name="javax.persistence.jdbc.user" value="REPLACE_ME__DATABASE_USER" />
<property name="javax.persistence.jdbc.password" value="REPLACE_ME__DATABASE_PASSWORD" />
```

3. As for [V1.x.x](#v-1xx), you just have to replace everything prefixed with "REPLACE_ME__":

3.1. Replace `REPLACE_ME__JDBC_DRIVER` with the classname of the JDBC driver to use

3.2. Replace `REPLACE_ME__DATABASE_JDBC_URL` with the JDBC url of the database you want to connect to

3.3. Replace `REPLACE_ME__DATABASE_USER` with the database user to use

3.4. Replace `REPLACE_ME__DATABASE_PASSWORD` with the password of the database user you just set 


Example of what your setup should look like for a locally hosted MySQL database:
```xml
<property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />
<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/JEEPRJ" />
<property name="javax.persistence.jdbc.user" value="jee" />
<property name="javax.persistence.jdbc.password" value="jee" />
```

## Tools

This project was built using the following tools:

* **[IntelliJ IDEA](https://www.jetbrains.com/idea/)** - IDE
* **[SonarQube](https://www.sonarqube.org)** - Code quality analysis
* **[Git](https://git-scm.com)** *(Obviously)* - Source Code Management
* **[GitHub](https://github.com)** *(Obviously too)* - Git repo hosting
* **[Azure DevOps](https://dev.azure.com)** - Git repo hosting, Agile project management tool, CI/CD
* **[Amazon Web Services](https://aws.amazon.com/)** - Web application hosting and cloud database solution (*[Elastic Beanstalk](https://aws.amazon.com/fr/elasticbeanstalk/) and [RDS](https://aws.amazon.com/fr/rds/)*)
* **[Docker](https://www.docker.com)** - Container system *(used for SonarQube)*


## Libraries

For this project, the following libraries were used:

* **[Lombok](https://projectlombok.org)** Lightweight library to improve readability in Java Beans thanks
  to a simple annotations system

* **[HikariCP](https://github.com/brettwooldridge/HikariCP)** Solid, high-performance, JDBC connection pool to prevent database server from crashing

## External Resources ("Special thanks to...")

For this project, the following external resources were used:

* **[Architect-UI](https://architectui.com/#/) admin panel template**
    
    This template is based on the [Bootstrap 4 CSS and JavaScript framework](https://getbootstrap.com)
    and comes  with the ["Stroke Icons 7"](https://themes-pixeden.com/font-demos/7-stroke/) 
    icons font embedded in it.
    
* **[Stroke Icons 7 (Pe-7s)](https://themes-pixeden.com/font-demos/7-stroke/) icons pack**

    This icons pack/font is a series of iOS 7 inspired vector icons in a custom@font-face
    icon font that can be styled dynamically using CSS. Those retina ready icons have a
    very modern style that will beautifully complement any project.

