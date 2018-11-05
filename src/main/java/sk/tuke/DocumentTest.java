package sk.tuke;

import org.springframework.context.annotation.Bean;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DocumentTest {

  @Bean
  public HelloWorld hello() {return  new HelloWorldImpl();}

//  @Bean
//  public MyApplication myApplication (HelloWorld helloWorld) {return  new MyApplication(helloWorld);}

  @Bean
  public DocumentBuilderFactory documentBuilderFactory() {
    return  DocumentBuilderFactory.newInstance();
  }

  @Bean
  public DocumentBuilder documentBuilder (DocumentBuilderFactory documentBuilderFactory) throws  Exception {
    return  documentBuilderFactory.newDocumentBuilder();
  }

//  @Bean
//  public Document document (DocumentBuilder documentBuilder)


}
