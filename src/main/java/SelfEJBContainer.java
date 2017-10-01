import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlType;
import java.io.*;
import java.util.Scanner;

public class SelfEJBContainer {

    private static Calculator calculator;
    private static String DEFAULT_PATH ="src/main/java/resources/";

    public static void main(String... args) throws IOException {
        EJBContainer ejbContainer = EJBContainer.createEJBContainer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of the file message");
        String fileName = scanner.nextLine();
        String filePath = DEFAULT_PATH+fileName;
        Object object = null;
        File file = new File(filePath);
        System.out.println(file.getAbsolutePath());
        BufferedReader br = new BufferedReader(new FileReader(file.getAbsoluteFile()));
        String line = null;
        while ((line = br.readLine())!= null)
        {
            System.out.println(line);
        }
        try {

            object = ejbContainer.getContext().lookup("java:global/ejb/Calculator");
            calculator = (Calculator) object;



            System.out.println(calculator.add(10,3));

            ejbContainer.close();
        } catch (NamingException e) {
            e.printStackTrace();
            System.out.println("Error occurred "+e.getMessage());
        }


    }
}

