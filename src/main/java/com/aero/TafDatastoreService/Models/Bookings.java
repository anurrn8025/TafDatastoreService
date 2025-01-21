package com.aero.TafDatastoreService.Models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name = "Bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "flight_id",referencedColumnName = "id")
    private Flights flights;

    @Column(columnDefinition = "varchar(20)")
    private String status;
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
