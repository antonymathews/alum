/**
 * <!-- 
Author - Antony Mathews IMIT, Cuttack, Odisha, India, batch-2001
With inputs from 
Biajay Sahoo			batch-2001
Sundeep Mohanty (Tutu)	batch-2001
Sambit Satpathy			batch-2000
Soumya Mohanty (Bapi) 	batch-2001
Kamalesh Nayak			batch-2001
 -->

 */

package in.co.antony.alum.service;

import java.util.List;

import in.co.antony.alum.model.Role;

public interface RoleService {
	Role findById(int id);
	
	Role findByUserName(String userName);
	
	void saveRole(Role role);
	
	void updateRole(Role role);
	
	void deleteRoleById(int id);

	List<Role> findAllRoles();
}
