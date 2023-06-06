package logicadenegocios;

import java.util.ArrayList;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import javax.mail.util.ByteArrayDataSource;
import logicadenegocios.ReporteBitacoraBase;
import logicadenegocios.Bitacora;

public class Email {
    private String emailAddressTo;
    private String msgSubject;

    final String USER_NAME = "atitup2023@gmail.com";
    final String PASSWORD = "uokmwfsjsbieizqw";
    final String FROM_ADDRESS = "atitup2023@gmail.com";

    public Email() {
    }

    public void createAndSendEmail(String emailAddressTo, String msgSubject, Document document, ArrayList<Bitacora> bitacoras) throws DocumentException {
        this.emailAddressTo = emailAddressTo;
        this.msgSubject = msgSubject;
        sendEmailMessage(document, bitacoras);
    }

    private void sendEmailMessage(Document document, ArrayList<Bitacora> bitacoras) throws DocumentException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USER_NAME, PASSWORD);
            }
        });

        try {
            // Generate the PDF file
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, outputStream);
            document.open();
            // Generate the content of the PDF
            ReporteBitacoraBase reporteBitacora = new ReporteBitacoraBase(bitacoras);
            reporteBitacora.generarReporte(document);
            document.close();

            // Create the email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM_ADDRESS));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailAddressTo));
            message.setSubject(msgSubject);

            // Create the email body part with the PDF attachment
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("PDF adjunto.");
            MimeMultipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // Attach the PDF content to the email
            messageBodyPart = new MimeBodyPart();
            DataSource source = new ByteArrayDataSource(outputStream.toByteArray(), "application/pdf");
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName("report.pdf");
            multipart.addBodyPart(messageBodyPart);

            // Set the email content with the PDF attachment
            message.setContent(multipart);

            // Send the email
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
