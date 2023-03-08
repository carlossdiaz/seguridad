package com.carlosdiaz.seguridad;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.carlosdiaz.seguridad.models.Permission;
import com.carlosdiaz.seguridad.models.User;
import com.carlosdiaz.seguridad.repositories.PermissionRepository;
import com.carlosdiaz.seguridad.repositories.UserRepository;

@SpringBootTest
class SeguridadApplicationTests {

	@Autowired
	UserRepository userRepository;
	@Autowired
	PermissionRepository permissionRepository;
	
	
	@Test
	void contextLoads() {

		User u1 = new User();
		u1.setId(1);
		u1.setNombre("Usuario1");
		u1.setPassword(("1111"));
		u1.setEmail("email1@email");

		Permission p1 = new Permission();
		p1.setId(1);
		p1.setDescripcion("Añadir Alumnos");
		Permission p2 = new Permission();
		p2.setId(2);
		p2.setDescripcion("Modificar Alumnos");
		Permission p3 = new Permission();
		p3.setId(3);
		p3.setDescripcion("Baja Alumnos");
		Permission p4 = new Permission();
		p4.setId(4);
		p4.setDescripcion("Consulta Alumnos");

		Permission p5 = new Permission();
		p5.setId(5);
		p5.setDescripcion("Añadir Asignaturas");
		Permission p6 = new Permission();
		p6.setId(6);
		p6.setDescripcion("Modificar Asignaturas");
		Permission p7 = new Permission();
		p7.setId(7);
		p7.setDescripcion("Baja Asignaturas");
		Permission p8 = new Permission();
		p8.setId(8);
		p8.setDescripcion("Consulta Asignaturas");
		Permission p9 = new Permission();
		p9.setId(9);
		p9.setDescripcion("Matriculacion");

		p1 = permissionRepository.save(p1);
		p2 = permissionRepository.save(p2);
		p3 = permissionRepository.save(p3);
		p4 = permissionRepository.save(p4);
		p5 = permissionRepository.save(p5);
		p6 = permissionRepository.save(p6);
		p7 = permissionRepository.save(p7);
		p8 = permissionRepository.save(p8);
		p9 = permissionRepository.save(p9);

		List<Permission> permisos = new ArrayList<Permission>();
		permisos.add(p1);
		permisos.add(p2);
		permisos.add(p3);
		permisos.add(p4);
		permisos.add(p5);
		permisos.add(p6);
		permisos.add(p7);
		permisos.add(p8);
		permisos.add(p9);
		u1.setPermissions(permisos);
		userRepository.save(u1);

	}

}
