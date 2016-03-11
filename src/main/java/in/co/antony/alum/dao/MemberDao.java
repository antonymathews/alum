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

package in.co.antony.alum.dao;

import java.util.List;

import in.co.antony.alum.model.Member;

public interface MemberDao {
	Member findById(int id);

	void saveMember(Member member);
	
	void deleteMemberById(int id);
	
	List<Member> findAllMembers();
	
	List<Member> findAllMembers(String type, String search);
	
	Member getIdFromUserName(String userName);
}
