package net.mahdirazavi.companydashboard.repository;

import net.mahdirazavi.companydashboard.entity.OrderCollectionStatus;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Qualifier(value = "OrderCollectionStatusRepository")
public interface OrderCollectionStatusRepository extends JpaRepository<OrderCollectionStatus, Long> {
}
