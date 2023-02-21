package pera.software.kafileadmin.client.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pera.software.kafileadmin.client.dto.request.CreateMessageRequest;
import pera.software.kafileadmin.data.entity.Message;

@Mapper(implementationName = "MessageMapperImpl", componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MessageMapper {

    Message toMessage(CreateMessageRequest message);

}