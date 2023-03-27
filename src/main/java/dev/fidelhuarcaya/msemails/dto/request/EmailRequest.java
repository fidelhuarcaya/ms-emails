package dev.fidelhuarcaya.msemails.dto.request;

import lombok.Data;

@Data
public class EmailRequest {
    private String email;//para quien envias custom
    private String tema;
    private String mensaje;
}
