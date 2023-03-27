package dev.fidelhuarcaya.msemails.controller;

import dev.fidelhuarcaya.msemails.dto.request.EmailRequest;
import dev.fidelhuarcaya.msemails.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emails/")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    //this api send simple email
    @CrossOrigin({ "http://localhost:4200/","https://fidelhuarcaya.dev/" })
    @PostMapping("/send")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request) {

        System.out.println(request);
        boolean result = this.emailService.sendEmail(request.getTema(), request.getMensaje(), request.getEmail());
        if (result) {

            return ResponseEntity.ok("Email Properly Sent Successfully... ");

        } else {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("email sending fail");
        }
    }
/*
    //this api send email with file
    @PostMapping("/sendemailattachement")
    public ResponseEntity<?> sendEmailWithAttachment(@RequestBody EmailRequest request)
    {
        System.out.println(request);

        boolean result = this.emailService.sendWithAttachment(request.getSubject(), request.getMessage(), request.getTo());

        if(result){

            return  ResponseEntity.ok("Sent Email With Attchment Successfully... ");

        }else{

            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("attachment email sending fail");
        }

    }

    //this api send email with html content
    @PostMapping("/sendemailhtml")
    public ResponseEntity<?> sendEmailHtml(@RequestBody EmailRequest request)
    {
        System.out.println(request);


        boolean result = this.emailService.sendHtmlTemplate(request.getSubject(), request.getMessage(), request.getTo());

        if(result){

            return  ResponseEntity.ok("Sent Email With HTML template style Successfully... ");

        }else{

            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("html template style email sending fail");
        }
    }

    //this api send email with inline image
    @PostMapping("/sendemailinlineimage")
    public ResponseEntity<?> sendEmailWithInlineImage(@RequestBody EmailRequest request)
    {
        System.out.println(request);


        boolean result = this.emailService.sendEmailInlineImage(request.getSubject(), request.getMessage(), request.getTo());

        if(result){

            return  ResponseEntity.ok("Sent Email With Inline Image Successfully... ");

        }else{

            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("inline image email sending fail");
        }
    }
*/
}
