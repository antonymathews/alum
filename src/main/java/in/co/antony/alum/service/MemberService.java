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

package in.co.antony.alum.service;

import java.util.List;

import in.co.antony.alum.model.Member;

public interface MemberService {
	Member findById(int id);
	
	Member getIdFromUserName(String userName);
	
	void saveMember(Member member);
	
	void updateMember(Member member, boolean admin);
	
	void deleteMemberById(int id);

	List<Member> findAllMembers();
	
	List<Member> findAllMembers(String type, String search);
}
