package com.aero.TafDatastoreService.Repositories;

import com.aero.TafDatastoreService.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<Users,Long>{


}
