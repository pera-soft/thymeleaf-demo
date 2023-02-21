package pera.software.kafileadmin.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pera.software.kafileadmin.data.entity.Message;

public interface FormRepository extends JpaRepository<Message, Long> {

}