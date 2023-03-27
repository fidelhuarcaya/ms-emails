package dev.fidelhuarcaya.msemails.dto.request;

import lombok.Data;

@Data
public class EmailRequest {
    private String email;//para quien envias
    private String tema;
    private String mensaje;
}
