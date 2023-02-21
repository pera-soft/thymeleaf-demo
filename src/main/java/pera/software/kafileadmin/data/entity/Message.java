package pera.software.kafileadmin.data.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    String company;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String phone;

    @Column(nullable = false)
    String message;
}