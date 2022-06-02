
# backendchallenge

## Başlıklar
* [Genel Bilgi](#genel-bilgi)
* [Kullanılan Teknolojiler](#kullanılan-teknolojiler)
* [Kullanım](#kullanım)
* [Pages](#pages)
* [Technologies Used](#technologies-used)
* [Associated Project](#associated-Project)
* [Contributions](#contributions)
* [Contact](#contact)

## Genel Bilgi
backendchallenge projesi Java 17 ile geliştirilmiş bir MVC projesidir. Ayrıca proje içinde REST API yapısı da mevcuttur. 
`NOTE:` Bu uygulama örnek bir uygulamadır. Bu yüzden, uygulama içinde kullanılan bilgiler gerçeği yansıtmamaktadır.

## Kullanılan Teknolojiler
Projede kullanılan teknolojiler [Spring Initializr](https://start.spring.io/) aracılığı ile oluşturuldu. Kullanmış olduğum teknolojileri aşağıdaki "pom.xml" dosyası içinde görebilirsiniz.  

 ```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.7.0</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>enoca</groupId>
	<artifactId>backendchallenge</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>backendchallenge</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>
	</build>

</project>

 ```

## Kullanım
Paket kurulumu ardından katmanlar görselde görüldüğü gibi oluşturuldu.
<img src="[https://media.discordapp.net/attachments/767148733380689920/966462502684741702/anasayfa.png](https://i.hizliresim.com/9tgwoqk.PNG)?width=1329&height=683">


## Pages
<p align="center">Main Page</p>

<img src="https://media.discordapp.net/attachments/767148733380689920/966462502684741702/anasayfa.png?width=1329&height=683">
<p align="center">Car Detail</p>
<img src="https://media.discordapp.net/attachments/767148733380689920/966462515095687198/cardetail.png?width=1334&height=683">
<p align="center">Rental Detail</p>
<img src="https://media.discordapp.net/attachments/767148733380689920/966645968940449892/unknown.png?width=1329&height=683">
<p align="center">Cart Summary</p>
<img src="https://media.discordapp.net/attachments/767148733380689920/966462525971509318/cartsummary.png?width=1329&height=683">
<p align="center">Payment With Saved Credit Card</p>
<img src="https://media.discordapp.net/attachments/767148733380689920/966462534880231494/customercreditcard.png?width=1334&height=683">
<p align="center">Payment With Another Credit Card</p>
<img src="https://media.discordapp.net/attachments/767148733380689920/966462538969677844/othercreditcard.png?width=1333&height=683">
<p align="center">Payment Loading Screen</p>
<img src="https://media.discordapp.net/attachments/767148733380689920/966462545038802975/paymentlloading.png?width=1331&height=683">
<p align="center">Save Credit Card</p>
<img src="https://media.discordapp.net/attachments/767148733380689920/966462507021643876/asktosave.png?width=1334&height=683">
<p align="center">Payment Successful</p>
<img src="https://media.discordapp.net/attachments/767148733380689920/966462549598036028/paymentsuccesful.png?width=1329&height=683">
<p align="center">Admin Main Page</p>
<img src="https://media.discordapp.net/attachments/767148733380689920/966462492534521856/admin-mainpage.png?width=1333&height=683">
<p align="center">Car Management</p>
<img src="https://media.discordapp.net/attachments/767148733380689920/966462519151558706/car-management.png?width=1329&height=683">

**You can view and test other pages by installing the application.**


## Associated Project
The frontend of this project [RecapCarProject](https://github.com/furkaancetiin/RecapCarProject)
## Contributions

Thanks to dear  [Engin Demiroğ](https://github.com/engindemirog)  for his contributions.

## Contact
For your questions:
furkaanncetiin@gmail.com
[LinkedIn](https://www.linkedin.com/in/furkaancetiin/)

