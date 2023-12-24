package dev.fidelhuarcaya.msemails.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequest {

    private String name;
    private String email;//para quien envias custom
    private String message;
    private String subject;
    private String to;
    private String from;
    private String html;
}
