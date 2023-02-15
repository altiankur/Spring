package in.ankurrangwala.insurance.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ankurrangwala.insurance.dto.InsuranceDetailsDTO;
import in.ankurrangwala.insurance.entity.InsuranceDetails;
import in.ankurrangwala.insurance.repository.InsuranceDetailsRepository;

@Service
public class InsuranceDetailsService {
	
	@Autowired
	private InsuranceDetailsRepository detailsRepository;
	public InsuranceDetailsDTO create(InsuranceDetailsDTO detailsDTO) {
		
		InsuranceDetails details = new InsuranceDetails();
		
		BeanUtils.copyProperties(detailsDTO, details);
		details = detailsRepository.save(details);
		
		BeanUtils.copyProperties(details, detailsDTO);
		return detailsDTO;
		
	}
	public InsuranceDetailsDTO read(Long id) {
		InsuranceDetailsDTO returnValue = new InsuranceDetailsDTO();
		InsuranceDetails details = detailsRepository.findById(id).get();
		BeanUtils.copyProperties(details, returnValue);
		
		return returnValue;
	}
}
