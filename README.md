# TestAutomation

https://techcrunch.com adresinde ana sayfa ve haber sayfalarından biri için bir birim testi yazdım. ilgili kod;

- Ana sayfadaki "Son Haberler" listesi için şunları doğruluyor;

* Her haberin yazarı olup olmadığını,
* Her haberin görüntüsü olup olmaması durumunu,

- Daha sonra "Son Haberler" listesindeki haberlerden birine tıklayarak içeriğin tamamına ulaşır ve ardından doğrulama yapar;

* Tarayıcı başlığının haber başlığı ile aynı olup olmadığını,
* Haber içeriği içinde bulunan bağlantıların sayısını,

Kod, Selenium Framework ve testNG kütüphanesi ile Java kullanılarak yazılmıştır.

*****

I have written a unit test for the main page and one of the news page in https://techcrunch.com. This code does the following:

For “The Latest News” list in the mainpage, it verifies;

a. if each news has an author
b. if each news has an image

Then it clicks one of the news from “The Latest News” list to reach the full content and then it verifies;

a. if the browser title is the same with the news title
b. if there are links within the news content

The code is written using Java with Selenium Framework and JUnit library.
