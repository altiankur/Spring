package in.ankurrangwala.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ankurrangwala.insurance.entity.InsuranceDetails;

public interface InsuranceDetailsRepository extends JpaRepository<InsuranceDetails, Long> {

}
