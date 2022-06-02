
# backendchallenge

## Başlıklar
* [Genel Bilgi](#genel-bilgi)
* [Kullanılan Teknolojiler](#kullanılan-teknolojiler)
* [Kullanım](#kullanım)
* [İletişim](#İletişim)

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
`NOTE:` Projeyi ayağı kaldırma ve servisleri kullandığım kısımları size "Company" nesnesi üzerinden göstermeye çalışacağım.


<img src="https://i.hizliresim.com/9tgwoqk.PNG?width=1329&height=683">

İlk olarak "entity" katmanında "Company" nesnesi için gerek olan fieldlar yazıldı. Tablo ilişkileri kuruldu. Lombok aracılığı ile "getter" ve "setter"lar otomatik olarak hazır hale getirildi.

<img src="https://i.hizliresim.com/pc2ycu2.PNG?width=1329&height=683">

Ardından veri erişim işlemleri için "repository" katmanında "CompanyRepository" classı içinde JpaRepository implementasyonu ile tüm ana CRUD işlemleri hazır hale getirildi.

<img src="https://i.hizliresim.com/6o4iw77.PNG?width=1329&height=683">

"application.properties" kısmında PostgreSQL tarafında tabloların oluşturulması ve veritabanı bağlantısı için gerekli adres bilgileri implementasyon edildi. Burada önemli ayrıntı spring.jpa.hibernate.ddl-auto=update kısmı projenin devamında "update" olarak tutuldu. Tablolaların oluşum aşamasında ilk başta "create" olarak kayıt edilmişti.
<img src="https://i.hizliresim.com/age656l.PNG?width=1329&height=683">

"service" katmanında gerekli "CompanyService" interfacesi yazıldı ve ardından "CompanyServiceImpl" classına implement edildi. Operasyonların içi gereken şekilde dolduruldu.

<img src="https://i.hizliresim.com/nte6zge.PNG?width=1329&height=683">

Artık "controller" katmanında "service"de yazmış olduğumuz operasyonları kullanarak CRUD operasyonlarını başarılı bir şekilde tamamlayabilmek kaldı. Burada bazı annotationlardan bahsetmek isterim.

@Controller : Bu annotation "CompanyController"ın bir controller olduğunu ifade eder. Yani Model classımız ve Thymeleaf yardımı ile oluşturduğumuz .html dosyalarımız arasında hangi endpointin neye göre çalışacağına karar vermesini sağlar.  
@GetMapping: HTTP protokolü ile gelen GET isteklerinin kontrolü için kullanılır.  
@PostMapping: HTTP protokolü ile gelen POST isteklerinin kontrolü için kullanılır.   
@ModelAttribute: View kısmında formlarımızı kullanabilmek amacıyla kullanırız.  
@PathVariable: Bu annotation ile URL'de bulunan değişkenleri (id gibi) güncelleme,silme vs. gibi metotlarımıza aktararak metodun görevini yapmasını sağlarız.  

<img src="https://i.hizliresim.com/8jg97hu.PNG ?width=1329&height=683">

Controller'da kullanılan annotationlardan biraz bahsetmeye çalıştım. Şimdi artık ister API ile istersek de MVC projemizin View kısmından gerekli CRUD operasyonlarının başarıyla çalıştığına dair örnek vermek isterim. Ben ilk olarak hiç değer girmemiş olduğum tablolarıma MVC'nin View kısmında birkaç örnek vermek istiyorum. (View kısmında Bootstrap 5.2 versiyonunu kullanarak basit tablo ve form yapılarını kullandım.) Tabii bunun için "BackendchallengeApplication.java" classımıza sağ tıklayarak "Run As" dedikten sonra "Java Application"a tıklayarak projeimizi ayağa kaldıralım. Biraz bekledikten sonra adres çubuğuna "http://localhost:8080/companies" yazarak boş olarak görüntülenen Şirketler Sayfasına gidelim.

<img src="https://i.hizliresim.com/dfwtgf8.PNG?width=1329&height=683">

Bu sayfadan "Add Company" butonuna tıklayarak ilk şirketimizi eklemek için formumuzu dolduralım.

<img src="https://i.hizliresim.com/5x317ts.PNG?width=1329&height=683">

Formumuzu bu şekilde sahte bilgiler ile doldurup "Ekle" butonuna bastıktan sonra http://localhost:8080/companies adresine tekrar route olacağız. Ve gelen görüntü şu şekilde olacaktır.

<img src="https://i.hizliresim.com/26p90oj.PNG?width=1329&height=683">

Şimdi ise eklediğimiz bu şirketin bilgilerinde güncellemeye gidelim. Şirket adını "A Yazılım Danışmanlık Şirketi" olarak değiştirdim. Sonraki görselde sonucu görelim.

<img src="https://i.hizliresim.com/3x6yp0i.PNG?width=1329&height=683">

Ve görselde görüldüğü gibi sonuç istediğimiz şekilde karşımızda bulunuyor.

<img src="https://i.hizliresim.com/jzfubnm.PNG?width=1329&height=683">

Şimdi ise API kısmında Postman yardımı ile delete ve getbyid operasyonlarını post ve get edelim. Ben şimdi 2 adet daha şirket ekleyeceğim ve API kısmında eklemiş olduğum şirketlere gerekli operasyonları uygulayacağım.

Görselde görüldüğü üzere adresimizi doğru şekilde yazdığımızda istenen veriye ulaşabildiğimizi görüyoruz. Burada bizi Result yapısı karşılıyor. Yaptığımız işlemlerin detayını burada return etmiş oluyoruz. Bize ekstra success ve message bilgisinin de geldiğini görüyoruz. Bu kısımlar yapılacak hata yönetimlerine göre istenen şekilde projenin backend kısmında set edilebilir.
<img src="https://i.hizliresim.com/ebfw2jo.PNG?width=1329&height=683">

Şimdi ise getirmiş olduğum nesneyi Postman aracılığı ile sileceğim. Görüldüğü üzere işlem başarı bilgisi olan success true olarak döndü. Şimdi tüm datayı çekerek id'si 2 olan nesnenin listeden silindiğini göreceğiz.

<img src="https://i.hizliresim.com/jf607d5.PNG?width=1329&height=683">

Tüm şirketleri listelemem sonucunda id'si 2 olan şirketin görülmediğini yani silme işleminin başarılı olduğunu görüyoruz.

<img src="https://i.hizliresim.com/8osac2z.PNG?width=1329&height=683">

## İletişim
Sorularınız için:
furkaanncetiin@gmail.com
[LinkedIn](https://www.linkedin.com/in/furkaancetiin/)

