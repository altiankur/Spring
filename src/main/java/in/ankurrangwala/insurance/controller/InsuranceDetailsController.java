package in.ankurrangwala.insurance.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.ankurrangwala.insurance.dto.InsuranceDetailsDTO;
import in.ankurrangwala.insurance.io.InsuranceDetailsRequest;
import in.ankurrangwala.insurance.io.InsuranceDetailsResponse;
import in.ankurrangwala.insurance.service.InsuranceDetailsService;

@RestController
@RequestMapping("/api/v1")
public class InsuranceDetailsController {

	@Autowired
	private InsuranceDetailsService detailsService;
	
	@PostMapping("/save")
	@ResponseStatus(value=HttpStatus.CREATED)
	public InsuranceDetailsResponse create(@RequestBody InsuranceDetailsRequest detailsRequest) {
		InsuranceDetailsDTO detailsDTO = new InsuranceDetailsDTO();
		BeanUtils.copyProperties(detailsRequest, detailsDTO);
		
		detailsDTO = detailsService.create(detailsDTO);
		
		InsuranceDetailsResponse response = new InsuranceDetailsResponse();
		
		BeanUtils.copyProperties(detailsDTO, response);
		
		return response;
	}
	
	@GetMapping("/read/{id}")
	public InsuranceDetailsResponse read(@PathVariable Long id) {
		InsuranceDetailsDTO detailsDTO = detailsService.read(id);
		
		InsuranceDetailsResponse returnValue = new InsuranceDetailsResponse();
		
		BeanUtils.copyProperties(detailsDTO, returnValue);
		return returnValue;
	}
}