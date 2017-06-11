/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.wealth.exchange.mail;

/**
 *
 * @author f4728548
 */

import java.net.URI;
import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.service.item.EmailMessage;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.property.complex.MessageBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ExchangeServiceMailUtil {
    
    private static Logger logger = LoggerFactory.getLogger(ExchangeServiceMailUtil.class);



    /**
     * send emial
     * @return
     */
    public static boolean sendEmail() {

        Boolean flag = false;
        try {
            ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2010_SP1); // your server version
            String fNumber = "f1111111";
            String pwd = "********";
            String domain = "fnbjnb01"; //origin
            ExchangeCredentials credentials = new WebCredentials(fNumber, pwd, domain); // change them to your email username, password, email domain
            //ExchangeCredentials credentials = new WebCredentials("338655@mylife.unisa.ac.za", "*******"); // change them to your email username, password, email domain
            //33865523@mylife.unisa.ac.za
            service.setCredentials(credentials);
            service.setUrl(new URI("https://webmail.frgs.co.za/EWS/Exchange.asmx")); //outlook.spacex.com change it to your email server address
            //service.setUrl(new URI("https://outlook.office365.com/EWS/Exchange.asmx")); //UNISA outlook.spacex.com change it to your email server address
            EmailMessage msg = new EmailMessage(service);
            msg.setSubject("Does this work???"); //email subject
            //msg.setBody(MessageBody.getMessageBodyFromText("This is a test!!! pls ignore it!")); //email body
            msg.setBody(MessageBody.getMessageBodyFromText("I don't have an mailbox on fnb and origin does not allow it!")); //email body
            
            String recipient = "Loyiso.mdutshane@fnb.co.za";
            msg.getToRecipients().add(recipient); //email receiver
//        msg.getCcRecipients().add("test2@test.com"); // email cc recipients
//        msg.getAttachments().addFileAttachment("D:\\Downloads\\EWSJavaAPI_1.2\\EWSJavaAPI_1.2\\Getting started with EWS Java API.RTF"); // email attachment
            msg.send(); //send email
            flag = true;
            System.out.println("\n\n>>>>Email send successfully.....<<<<\n\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;

    }


    public static void main(String[] args) {

        sendEmail();

    }
    
}
