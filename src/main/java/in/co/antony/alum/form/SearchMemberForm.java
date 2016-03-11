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

package in.co.antony.alum.form;

import javax.persistence.Column;
import javax.validation.constraints.Size;

public class SearchMemberForm {
	@Size(min=2, max=10)
	@Column(name = "type", nullable = false)
	private String type;
	
	@Size(min=2, max=100)
	@Column(name = "search", nullable = false)
	private String search;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
}
