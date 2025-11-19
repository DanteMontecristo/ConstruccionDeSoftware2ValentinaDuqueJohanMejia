package APP.adapter.in.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import APP.adapter.rest.mapper.UserRestMapper;
import APP.adapter.rest.request.CreateUserRequest;
import APP.application.usecase.RRHHUseCase;
import APP.domain.model.User;

@RestController
@RequestMapping("/api/rrhh")
@PreAuthorize("hasRole('RRHH')")
public class RRHHController {

	@Autowired
	private RRHHUseCase rrhhUseCase;

	@Autowired
	private UserRestMapper userRestMapper;

	@PostMapping("/rrhh")
	public ResponseEntity<Void> createRrhh(@RequestBody CreateUserRequest req) throws Exception {
		User user = userRestMapper.toDomain(req);
		rrhhUseCase.createRrHh(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping("/administrative-staff")
	public ResponseEntity<Void> createAdministrative(@RequestBody CreateUserRequest req) throws Exception {
		User user = userRestMapper.toDomain(req);
		rrhhUseCase.createAdministrativeStaff(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping("/information-support")
	public ResponseEntity<Void> createInformationSupport(@RequestBody CreateUserRequest req) throws Exception {
		User user = userRestMapper.toDomain(req);
		rrhhUseCase.createInformationSupport(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping("/nurse")
	public ResponseEntity<Void> createNurse(@RequestBody CreateUserRequest req) throws Exception {
		User user = userRestMapper.toDomain(req);
		rrhhUseCase.createNurse(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping("/doctor")
	public ResponseEntity<Void> createDoctor(@RequestBody CreateUserRequest req) throws Exception {
		User user = userRestMapper.toDomain(req);
		rrhhUseCase.createDoctor(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/rrhh")
	public ResponseEntity<Void> updateRrhh(@RequestBody CreateUserRequest req) throws Exception {
		User user = userRestMapper.toDomain(req);
		rrhhUseCase.updateRrHh(user);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/administrative-staff")
	public ResponseEntity<Void> updateAdministrative(@RequestBody CreateUserRequest req) throws Exception {
		User user = userRestMapper.toDomain(req);
		rrhhUseCase.updateAdministrativeStaff(user);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/information-support")
	public ResponseEntity<Void> updateInformationSupport(@RequestBody CreateUserRequest req) throws Exception {
		User user = userRestMapper.toDomain(req);
		rrhhUseCase.updateInformationSupport(user);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/nurse")
	public ResponseEntity<Void> updateNurse(@RequestBody CreateUserRequest req) throws Exception {
		User user = userRestMapper.toDomain(req);
		rrhhUseCase.updateNurse(user);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/doctor")
	public ResponseEntity<Void> updateDoctor(@RequestBody CreateUserRequest req) throws Exception {
		User user = userRestMapper.toDomain(req);
		rrhhUseCase.updateDoctor(user);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/rrhh/{document}")
	public ResponseEntity<Void> deleteRrhh(@PathVariable long document) throws Exception {
		User user = new User();
		user.setDocument(document);
		rrhhUseCase.eliminateRrHh(user);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/administrative-staff/{document}")
	public ResponseEntity<Void> deleteAdministrative(@PathVariable long document) throws Exception {
		User user = new User();
		user.setDocument(document);
		rrhhUseCase.eliminateAdministrativeStaff(user);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/information-support/{document}")
	public ResponseEntity<Void> deleteInformationSupport(@PathVariable long document) throws Exception {
		User user = new User();
		user.setDocument(document);
		rrhhUseCase.eliminateInformationSupport(user);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/nurse/{document}")
	public ResponseEntity<Void> deleteNurse(@PathVariable long document) throws Exception {
		User user = new User();
		user.setDocument(document);
		rrhhUseCase.eliminateNurse(user);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/doctor/{document}")
	public ResponseEntity<Void> deleteDoctor(@PathVariable long document) throws Exception {
		User user = new User();
		user.setDocument(document);
		rrhhUseCase.eliminateDoctor(user);
		return ResponseEntity.ok().build();
	}

}
