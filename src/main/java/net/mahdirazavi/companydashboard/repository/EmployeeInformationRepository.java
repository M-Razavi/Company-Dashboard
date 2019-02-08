package net.mahdirazavi.companydashboard.repository;

import net.mahdirazavi.companydashboard.entity.EmployeeInformation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Qualifier(value = "EmployeeInformationRepository")
public interface EmployeeInformationRepository extends JpaRepository<EmployeeInformation, Long> {

    public EmployeeInformation findByPk(final String pk);
}
