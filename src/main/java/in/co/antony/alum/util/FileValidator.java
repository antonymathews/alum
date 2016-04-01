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

package in.co.antony.alum.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.co.antony.alum.form.MemberForm;
 
@Component
public class FileValidator implements Validator {
     
    public boolean supports(Class<?> clazz) {
        return MemberForm.class.isAssignableFrom(clazz);
    }
 
    public void validate(Object obj, Errors errors) {
    	MemberForm file = (MemberForm) obj;
         
        if(file.getFile()!=null){
            if (file.getFile().getSize() == 0) {
                errors.rejectValue("file", "missing.file");
            }
        }
    }
}
