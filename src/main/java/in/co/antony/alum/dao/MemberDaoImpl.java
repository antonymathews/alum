/**
 * <!-- 
Author - Antony Mathews IMIT, Cuttack, Odisha, India, batch-2001
With inputs from 
Biajay Sahoo			batch-2001
Sundeep Mohanty (Tutu)	batch-2001
Sambit Satpathy			batch-2000
Soumya Ranjan Parida (Bapi) 	batch-2001
Kamalesh Nayak			batch-2001
 -->

 */

package in.co.antony.alum.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import in.co.antony.alum.dao.AbstractDao;
import in.co.antony.alum.dao.MemberDao;
import in.co.antony.alum.model.Member;

@Repository("memberDao")
public class MemberDaoImpl extends AbstractDao<Integer, Member> implements MemberDao{

	@Override
	public Member findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveMember(Member member) {
		System.out.println(" in member dao savemember");
		persist(member);
	}

	@Override
	public void deleteMemberById(int id) {
		Query query = getSession().createSQLQuery("delete from member where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Member> findAllMembers() {
		System.out.println(" in find all members ");
		Criteria criteria = createEntityCriteria();
		return (List<Member>) criteria.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Member> findAllMembers(String type, String search) {
		Criteria criteria = createEntityCriteria();
		if(null != type) {
			if(type.equals("batch")) {
				criteria.add(Restrictions.eq("batchYear", Integer.parseInt(search)));
			} else if(type.equals("name")) {
				criteria.add(Restrictions.ilike("name", search));
			} else if(type.equals("location")) {
				criteria.add(Restrictions.ilike("location", search));
			} else {
				return null;
			}
		}
		criteria.setMaxResults(100);
		return (List<Member>)criteria.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public Member getIdFromUserName(String userName) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("userName", userName));
		List<Member> memberList = criteria.list();
		if(null != memberList) {
			return memberList.get(0);
		}
		return null;
	}
}
