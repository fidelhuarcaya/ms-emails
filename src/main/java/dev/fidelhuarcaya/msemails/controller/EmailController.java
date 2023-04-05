package dev.fidelhuarcaya.msemails.controller;

import dev.fidelhuarcaya.msemails.dto.request.EmailRequest;
import dev.fidelhuarcaya.msemails.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/emails")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @PostMapping("/send")
    public Mono<ResponseEntity<String>> sendEmail(@RequestBody EmailRequest request) {
        return emailService.sendEmail(request.getName() + "-" + request.getEmail(),
                        request.getMessage(),
                        request.getEmail())
                .flatMap(success -> {
                    if (success) {
                        return Mono.just(ResponseEntity.ok("Email Properly Sent Successfully..."));
                    } else {
                        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("email sending fail"));
                    }
                });
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
