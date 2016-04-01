/**
 * <!-- 
Author - Antony Mathews IMIT, Cuttack, Odisha, India, batch-2001
With inputs from 
Biajay Sahoo			batch-2001
Sundeep Mohanty (Tutu)	batch-2001
Sambit Satpathy			batch-2000
Soumya Ranjan Parida(Bapi) 	batch-2001
Kamalesh Nayak			batch-2001
 -->

 */

package in.co.antony.alum.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import in.co.antony.alum.model.Member;
import in.co.antony.alum.model.Role;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao{

	@Override
	public Role findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveRole(Role role) {
		persist(role);
	}

	@Override
	public void deleteRoleById(int id) {
		Query query = getSession().createSQLQuery("delete from role where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Role> findAllRoles() {
		Criteria criteria = createEntityCriteria();
		return (List<Role>) criteria.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public Role findByUserName(String userName) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("userName", userName));
		List<Role> roleList = criteria.list();
		if(null != roleList && roleList.size()>0) {
			return roleList.get(0);
		}
		return null;
	}
}
