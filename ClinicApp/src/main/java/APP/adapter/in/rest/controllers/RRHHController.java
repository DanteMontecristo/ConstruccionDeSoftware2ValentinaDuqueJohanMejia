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

	@DeleteMapping("/rrhh/{document}")
	public ResponseEntity<Void> deleteRrhh(@PathVariable long document) throws Exception {
		User user = new User();
		user.setDocument(document);
		rrhhUseCase.eliminateRrHh(user);
		return ResponseEntity.ok().build();
	}

}
