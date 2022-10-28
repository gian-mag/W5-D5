package com.giandomenico.w5.d5.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String description;
    
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private int maxSize;
    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

}
