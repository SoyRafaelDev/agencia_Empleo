package com.rafaelgonzalez.application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @ElementCollection
@CollectionTable(name = "admin_sources", joinColumns = @JoinColumn(name = "admin_id"))
@Column(name = "source")
    private List<String> sources;
}
