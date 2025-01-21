package com.aero.TafDatastoreService.Models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name = "Flights")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Flights {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(45)", unique=true)
    private String flight_number;
    @Column(columnDefinition = "varchar(50)")
    private String departure;
    @Column(columnDefinition = "varchar(50)")
    private String arrival ;
    @Column(columnDefinition = "TIME")
    private String departure_time ;
    @Column(columnDefinition = "TIME")
    private String arrival_time ;
    @Column(columnDefinition = "double default 0.0")
    private double price;
     @Column(columnDefinition = "int")
    private Long available_seats;
    @Column(columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP",nullable = false)
    private String created_at;
    @Column(columnDefinition = "TIMESTAMP ON UPDATE CURRENT_TIMESTAMP",nullable = false)
    private String updated_at;
    @PrePersist
    public void prePersist() {

        if (created_at == null) {
            created_at = new Date().toString();
        }
        if (updated_at == null) {
            updated_at = new Date().toString();

        }
    }


}
