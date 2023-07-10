package com.springboot.blog.controller;

import com.springboot.blog.entity.Complaint;
import com.springboot.blog.payload.CategoryDto;
import com.springboot.blog.payload.ComplaintDto;
import com.springboot.blog.service.CategoryService;
import com.springboot.blog.service.ComplaintService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping("/complaint")
public class ComplaintController {

    private ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerComplaint( @RequestBody ComplaintDto complaintDto){
        complaintDto.setStatus("Open");
        complaintDto.setCategory("Technical");
        ComplaintDto savedComplaint = complaintService.registerComplaint(complaintDto);
        //sendEmail(savedComplaint);
        return new ResponseEntity<String>(savedComplaint.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/getAllComplaints")
    public ResponseEntity<List<ComplaintDto>> getComplaints(){
        return ResponseEntity.ok(complaintService.getAllComplaints());
    }

    @PostMapping("/updateComplaint")
    public ResponseEntity<ComplaintDto> updateComplaint( @RequestBody ComplaintDto complaintDto){
        ComplaintDto savedComplaint = complaintService.updateComplaint(complaintDto);
        return new ResponseEntity<ComplaintDto>(savedComplaint, HttpStatus.CREATED);
    }

    private void sendEmail(ComplaintDto complaintDto) {
        String senderEmail = "devkumarmebroadband@gmail.com";
        String senderPassword = "haqtbfsyunngfhno";

        // Recipient information
        String recipientEmail = "lovesorout@gmail.com";

        // User information
        String userName = "Dev Doe";
        String userEmail = "lovesorout@gmail.com";

        // Email subject and content
        String subject = "User Information";
        String content = "ComplaintId: "+complaintDto.getId()+ "\nUser Name: " + complaintDto.getName() +
                "\nUser Phone Number: " + complaintDto.getPhoneNumber() + "\nUser Email: " + complaintDto.getEmail()

                +"\nDescription: "+complaintDto.getDescription();

        // Gmail SMTP server configuration
        String smtpHost = "smtp.gmail.com";
        int smtpPort = 587;

        // Setup properties for the SMTP server
        Properties properties = new Properties();
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", smtpPort);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create a session with the SMTP server
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Create a new email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);
            message.setText(content);

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            System.out.println("Failed to send email. Error: " + e.getMessage());
        }
    }
}
