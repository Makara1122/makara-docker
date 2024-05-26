package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "authority_tbl")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
}
