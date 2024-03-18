package Start;

import javax.swing.*;
import javax.swing.text.html.parser.Parser;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Scanner;
import acter.User;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.xml.sax.SAXException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Main
{
    static {
        new DOMConfigurator().doConfigure("log/log4j.xml",LogManager.getLoggerRepository());
    }
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        String XMLFile = "files/info.xml";
        String XSDFile = "files/info.xsd";

        String lenguege = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(lenguege);

        User us = new User("hello", "qwerty");
        us.setCards("4321", 43);
        us.setCards("1243", 17);
        us.setCards("3421", 92);
        us.setCards("1234", 9);

        try{
            Schema schema = factory.newSchema(new File(XSDFile));
            Validator validator = schema.newValidator();
            Source source = new StreamSource(XMLFile);
            validator.validate(source);
            LOG.info("All correct");
        }
        catch (SAXException e){
            LOG.error(XMLFile+" SAX error "+e.getMessage());
        }
        catch (IOException e){
            LOG.error("IO error"+e.getMessage());
        }

        ObjectMapper map = new ObjectMapper();

        File myUser = new File("User.json");
        try{
            map.writeValue(myUser, us);
            LOG.info("Correct creat file (User.json)");
        }
        catch (Exception x){
            LOG.error("Not create file (User.json)");
        }

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            ParserHand parser = new ParserHand();
            reader.setContentHandler(parser);
            reader.parse("files/info.xml");
            LOG.info(XMLFile + " IS VALID PARSE");
        } catch (SAXException e) {
            LOG.error(XMLFile + " SAX error " + e.getMessage());
        } catch (IOException e) {
            LOG.error("IO error " + e.getMessage());
        }

        LOG.info("Start");

        String chois = "";
        User user;

        try{
            System.out.println("Enter 1 if you want desirialize user");
            chois = (new Scanner(System.in)).next();

            if(!chois.equals("1"))
                throw new Exception();

            user = map.readValue(myUser, User.class);
        }
        catch (Exception e){
            user = null;
        }

        while(true){
            System.out.println("1) Log in");
            System.out.println("2) Show card");
            System.out.println("3) Show all");
            System.out.println("4) End");
            System.out.print("Enter your chois: ");

            chois = (new Scanner(System.in)).next();

            try {
                if (chois.equals("1")) {
                    String name;
                    String password;

                    System.out.print("Enter your name: ");
                    name = (new Scanner(System.in)).next();
                    if (name.equals(""))
                        throw new Exception();

                    System.out.print("Enter your password: ");
                    password = (new Scanner(System.in)).next();
                    if (password.equals(""))
                        throw new Exception();

                    user = new User(name, password);

                    user = CreatCard(user);

                    continue;
                } else if (chois.equals("2")) {
                    if (user == null)
                        throw new Exception();

                    user.ShowMyCard();
                    continue;

                } else if (chois.equals("3")) {
                    if (user == null)
                        throw new Exception();

                    user.ShowMyInfo();
                    continue;

                } else if (chois.equals("4")) {
                    break;
                }

                throw new Exception();
            }
            catch (Exception e)
            {
                System.out.println("Error try again");
            }
        }

        System.out.println("Good By");
    }
    public static User CreatCard(User user){
        String chois;

        while (true){
            System.out.println("1) Add new card");
            System.out.println("end");
            chois = (new Scanner(System.in)).next();

            if(!chois.equals("1"))
                break;

            System.out.print("Enter your card pincod: ");
            String pin = (new Scanner(System.in)).next();
            System.out.print("Enter your card cash: ");
            double cash = (new Scanner(System.in)).nextDouble();

            user.setCards(pin, cash);
        }
        return user;
    }
}