package net.mahdirazavi.companydashboard.repository;

import net.mahdirazavi.companydashboard.entity.OrderReceived;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Qualifier(value = "OrderReceivedRepository")
public interface OrderReceivedRepository extends JpaRepository<OrderReceived, Long> {
}
