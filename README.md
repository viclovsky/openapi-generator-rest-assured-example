# openapi-generator-rest-assured

## Quick Start
* Add maven plugin with latest version into pom.xml. Don't forget <inputSpec> in configuration tag with OAS specification:
```xml
 <plugin>
      <groupId>org.openapitools</groupId>
      <artifactId>openapi-generator-maven-plugin</artifactId>
      <version>4.2.3</version>
     <executions>
         <execution>
             <goals>
                 <goal>generate</goal>
             </goals>
             <configuration>
                 <!--Your input oas-->
                 <inputSpec>${project.basedir}/src/main/resources/oas.json</inputSpec>
                 <output>${project.build.directory}/generated-sources/openapi-generator</output>
                 <generatorName>java</generatorName>
                 <configOptions>
                    <dateLibrary>java8</dateLibrary>
                 </configOptions>
                 <library>rest-assured</library>
                 <skipValidateSpec>true</skipValidateSpec>
                 <skipIfSpecIsUnchanged>false</skipIfSpecIsUnchanged>
                 <generateApiDocumentation>false</generateApiDocumentation>
                 <generateModelDocumentation>false</generateModelDocumentation>
                 <apiPackage>${default.package}.api</apiPackage>
                 <modelPackage>${default.package}.model</modelPackage>
                 <invokerPackage>${default.package}</invokerPackage>
                 <!--Custom templates for client and tests-->
                 <templateDirectory>${project.basedir}/src/main/resources/tеmplates</templateDirectory>
             </configuration>
         </execution>
     </executions>
 </plugin>
```
See [openapi-generator-maven-plugin](https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-maven-plugin) for detail configuration.

* Add necessary dependencies for API client:
```xml
     <dependency>
         <groupId>io.</groupId>
         <artifactId>-annotations</artifactId>
         <version>${-core-version}</version>
     </dependency>
     <dependency>
         <groupId>io.rest-assured</groupId>
         <artifactId>rest-assured</artifactId>
         <version>${rest-assured.version}</version>
     </dependency>
     <dependency>
         <groupId>com.google.code.gson</groupId>
         <artifactId>gson</artifactId>
         <version>${gson-version}</version>
     </dependency>
     <dependency>
         <groupId>io.gsonfire</groupId>
         <artifactId>gson-fire</artifactId>
         <version>${gson-fire-version}</version>
     </dependency>
     <dependency>
         <groupId>com.squareup.okio</groupId>
         <artifactId>okio</artifactId>
         <version>${okio-version}</version>
     </dependency>
     <dependency>
         <groupId>com.google.code.findbugs</groupId>
         <artifactId>jsr305</artifactId>
         <version>${jsr305}</version>
     </dependency>
```
* Add necessary dependencies for 'templates' for tests:
```xml
     <dependency>
         <groupId>junit</groupId>
         <artifactId>junit</artifactId>
         <version>${junit.version}</version>
     </dependency>
```

* Run ```mvn clean compile``` for generation of API client(s) and tests

* As soon as generated code has been placed in target (```/openapi-generator-rest-assured/api-client/target/generated-sources/openapi-generator/src/main```), you can use it to write your tests. Moreover 'templates' for tests will be generated (```/openapi-generator-rest-assured/api-client/target/generated-sources/openapi-generator/src/test```).

* The simplest test with junit4 looks like below (see [GetInventoryTest](https://github.com/viclovsky/openapi-generator-rest-assured/blob/master/api-tests/src/test/java/com/viclovsky/example/oas/client/restassured/junit4/GetInventoryTest.java))

* Simple junit5 test with inject client was added for demonstration (see [GetInventoryTest](https://github.com/viclovsky/openapi-generator-rest-assured/blob/master/api-tests/src/test/java/com/viclovsky/example/oas/client/restassured/junit5/GetInventoryTest.java))
