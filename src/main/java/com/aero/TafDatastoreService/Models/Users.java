package com.aero.TafDatastoreService.Models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(45)", unique=true)
    private String username;
    @Column(columnDefinition = "varchar(100)")
    private String email;
    @Column(columnDefinition = "varchar(15)",nullable = true)
    private String phone;
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
