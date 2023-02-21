package pera.software.kafileadmin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pera.software.kafileadmin.client.dto.request.CreateMessageRequest;
import pera.software.kafileadmin.service.FormService;

@RestController
public class FormController {
    private final FormService formService;

    public FormController(FormService formService) {
        this.formService = formService;
    }

    @PostMapping("/save-message")
    public ResponseEntity<Object> saveMessage(@RequestBody CreateMessageRequest message) throws InterruptedException {
        Thread.sleep(2000);

        if (message.getName().equals("ali")) {
            return ResponseEntity.badRequest().body(message);
        } else {
            formService.createMessage(message);
            return ResponseEntity.ok(message);
        }
    }
}
