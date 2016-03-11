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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.antony.alum.dao.RoleDao;
import in.co.antony.alum.model.Role;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao dao;
	
	@Override
	public Role findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveRole(Role role) {
		dao.saveRole(role);
	}

	@Override
	public void updateRole(Role role) {
		Role entity = dao.findById(role.getId());
		if(null != entity) {
			entity.setRole(role.getRole());
		}
	}

	@Override
	public void deleteRoleById(int id) {
		dao.deleteRoleById(id);
	}

	@Override
	public List<Role> findAllRoles() {
		return dao.findAllRoles();
	}

	@Override
	public Role findByUserName(String userName) {
		return dao.findByUserName(userName);
	}

}
