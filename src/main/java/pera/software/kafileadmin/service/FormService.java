package pera.software.kafileadmin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pera.software.kafileadmin.client.dto.mapper.MessageMapper;
import pera.software.kafileadmin.client.dto.request.CreateMessageRequest;
import pera.software.kafileadmin.data.entity.Message;
import pera.software.kafileadmin.data.repository.FormRepository;

@RequiredArgsConstructor
@Service
public class FormService {
    private final FormRepository formRepository;
    private final MessageMapper messageMapper;

    public void createMessage(CreateMessageRequest request) {
        Message message = messageMapper.toMessage(request);
        formRepository.save(message);
    }
}
