package net.plantsystem.application.repository;

import net.plantsystem.application.model.Battery;
import net.plantsystem.application.repository.custom.BatteryRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author rames on 2023-03-16
 */
@Repository
public interface BatteryRepository extends JpaRepository<Battery, Long>, BatteryRepositoryCustom {

    @Query("SELECT b FROM Battery b WHERE b.status!='D' AND b.id = :id")
    Optional<Battery> findBatteryById(@Param("id") Long id);
}
