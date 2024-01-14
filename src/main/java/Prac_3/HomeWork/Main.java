package Prac_3.HomeWork;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Student studentForSave = new Student("Ivan", 22, 4.2);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("hw.txt"))) {
            oos.writeObject(studentForSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Student studentForLoad = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("hw.txt"))) {
            studentForLoad = (Student) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(studentForSave);
        System.out.println(studentForLoad);
        // Поле GPA инициализируется 0.0 потому что оно transient - не сериализуется.

        JsonMapper objectMapper = new JsonMapper();
        File fileJson = new File("json.json");

        Student studentForSaveJson = new Student("Alex", 19, 5);
        objectMapper.writeValue(fileJson, studentForSaveJson);
        Student studentForLoadJson = objectMapper.readValue(fileJson, Student.class);

        System.out.println(studentForSaveJson);
        System.out.println(studentForLoadJson);


        XmlMapper xmlMapper = new XmlMapper();
        File fileXml = new File("xml.xml");

        Student studentForSaveXml = new Student("Rox", 21, 3.9);
        xmlMapper.writeValue(fileXml, studentForSaveXml);
        Student studentForLoadXml = xmlMapper.readValue(fileXml, Student.class);

        System.out.println(studentForSaveXml);
        System.out.println(studentForLoadXml);

    }
}