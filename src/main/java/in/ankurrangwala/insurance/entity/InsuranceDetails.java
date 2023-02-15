package in.ankurrangwala.insurance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_insurance_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name= "policy_name")
	private String policyName;
	
	@Column(name= "policy_number")
	private String policyNumber;
	
	@Column(name= "company_name")
	private String companyName;
	
	private String description;
	
	@Column(name= "premium_amount")
	private Double premiumAmount;
}
