package br.com.original.bimo.param.aptidao.credito.controller;

import br.com.original.bimo.param.aptidao.credito.exceptions.CodeCnaeRegexException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.original.bimo.param.aptidao.credito.entities.ParamAptidaoCreditoPJ;
import br.com.original.bimo.param.aptidao.credito.model.ParameterRequest;
import br.com.original.bimo.param.aptidao.credito.model.ParameterResponse;
import br.com.original.bimo.param.aptidao.credito.model.ResponseData;
import br.com.original.bimo.param.aptidao.credito.services.ParamAptidaoCreditoPjService;

import javax.validation.Valid;
import java.util.Optional;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/parameters")
public class ParamAptdaoCreditoController {

	public static final String REGEX_CODE_CNAE = "(\\d{4})-(\\d{1})/(\\d{2})";

	/*@Autowired
	@OriginalLogger
	private OriginalLogLogger logger;*/
	
	@Autowired
	ParamAptidaoCreditoPjService aptdaoCreditoService;
	
	@GetMapping
    @ResponseBody
    public ResponseEntity<ParameterResponse> getLastParamAptidaoCreditoPJ(){

		try {
			
			ParamAptidaoCreditoPJ paramAptidaoCreditoPJ = aptdaoCreditoService.getLastParamAptidaoCreditoPJ();
			
			if (paramAptidaoCreditoPJ != null && paramAptidaoCreditoPJ.getId() != null) {
				ResponseData responseData = new ResponseData(paramAptidaoCreditoPJ);
	            return new ResponseEntity<>(new ParameterResponse(responseData), HttpStatus.OK);
	        } else if (paramAptidaoCreditoPJ == null) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }	
			
		} catch (Exception e) {
//			logger.error("Error: " + e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}		
	}
	
	@PutMapping
    @ResponseBody
    public ResponseEntity<ParameterResponse> putParameter(@Valid @RequestBody ParameterRequest request,
    		@RequestHeader(name = "x-transaction-id", required = true) String transactionId){

		Optional.ofNullable(request.getCnaesRestricted()).ifPresent(i -> i.forEach(c -> {
			if(!Pattern.compile(REGEX_CODE_CNAE).matcher(c.getCode()).find()){
//				logger.error("code cnae inválido");
				throw new CodeCnaeRegexException(c.getCode());
			}
		}));
		
		try {

			ParamAptidaoCreditoPJ aptidaoCreditoPJ = aptdaoCreditoService.getLastParamAptidaoCreditoPJ();	

			if (aptidaoCreditoPJ != null && aptidaoCreditoPJ.getId() != null) {						
				aptdaoCreditoService.updateParameter(aptidaoCreditoPJ);			
				ParamAptidaoCreditoPJ paramAptidaoCreditoPJ = aptdaoCreditoService.saveParameter(request);
				ResponseData responseData = new	ResponseData(paramAptidaoCreditoPJ); 
				return new ResponseEntity<>(new ParameterResponse(responseData), HttpStatus.CREATED);
			} else if (aptidaoCreditoPJ == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
//			logger.error("Error: " + e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}	
		
	}

}
