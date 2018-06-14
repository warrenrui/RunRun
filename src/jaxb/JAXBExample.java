package jaxb;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBExample {
    public static void main(String[] args) {
        marshaller();
        // unmarshaller();
    }

    public static void marshaller() {
        Customer customer = new Customer();
        customer.setId(100);
        customer.setName("customer");
        customer.setAge(23);
        customer.setSex("female");

        try {
            File file = new File("F:/ProjectsBak/CodeForStudy/src/jaxb/xmlFile.xml");
            // 初始化JAXBContext.JAXBContext类提供的JAXB API的客户端的入口点。
            // 它提供一个抽象的用于管理XML / Java绑定的必要信息，以实现JAXB绑定框架行动：解组，编组和验证。
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

            /*
             * 对象转换成XML. JAXB marshalling例子，将customer对象转换成XML文件。
             * jaxbMarshaller.marshal()包含了许多重载方法，选择符合输出要求的方法。
             */
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(customer, file);
            jaxbMarshaller.marshal(customer, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public static void unmarshaller() {
        try {
            File file = new File("F:/ProjectsBak/CodeForStudy/src/jaxb/xmlFile.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

            /*
             * XML转换成对象. JAXB unmarshalling例子，将XML文件内容转换成customer对象。
             * jaxbMarshaller.unmarshal()包含了许多重载方法，选择符合输出要求的方法。
             */
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Customer customer2 = (Customer) jaxbUnmarshaller.unmarshal(file);
            System.out.println(customer2.getAge());
            System.out.println(customer2.getId());
            System.out.println(customer2.getName());

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}