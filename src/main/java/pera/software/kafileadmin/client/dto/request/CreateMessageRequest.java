package pera.software.kafileadmin.client.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateMessageRequest {

    private String email;

    private String company;

    private String name;

    private String phone;

    private String message;
}
