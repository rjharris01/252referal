package controllers.Secretary;


import Views.Secretary.SecretaryDeleteUserManualView;
import models.user.Secretary;

/**
 *
 * @author richa_bfe6tpy
 */
public class SecretaryDeleteUserManualController {
    
    private SecretaryDeleteUserManualView theView;
    private Secretary theModel;
    
    
    public SecretaryDeleteUserManualController(SecretaryDeleteUserManualView theView, Secretary theModel){
        
        this.theView = theView;
        this.theModel = theModel;
       
    }
}
