package com.giandomenico.w5.d5.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String address;

    @ManyToOne
    @JoinColumn(name = "citta_id")
    private Citta citta;

    @OneToMany(mappedBy = "edificio")
    @ToString.Exclude
    List<Postazione> postazioni;


}
