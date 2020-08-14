package controllers.Secretary;


import Views.Secretary.SecretaryDeleteUserManualView;
import Views.Secretary.SecretaryView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.SwingConstants;
import models.user.Secretary;
import models.user.User;

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
       
        this.theView.addBackListener(new BackListener());
        this.theView.addDeleteListener(new DeleteListener());
        
        setPatientList();
    }
    
    class BackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            SecretaryView secretaryView = new SecretaryView();
            SecretaryController secretarController = new SecretaryController(secretaryView,theModel);
            theView.setVisible(false);
            secretaryView.setVisible(true);
            theView.getParent().add(secretaryView,SwingConstants.CENTER);
        }
    }
    
    class DeleteListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
             
             try{
                    User user = theView.getSelectedUser();
                    theModel.deleteUser(user.getUserId());
                    setPatientList();
                 
                    
                   
                    
        }
         catch(java.lang.NullPointerException ex)
        {
            System.out.print("No Account selected");
        }
                     
        }
    }
    
    public void setPatientList()
    {
        DefaultListModel<User> model = new DefaultListModel<>();
      
        String UserId = "P";
        theView.clearList();
        
        
        ArrayList<User> users = theModel.getAllUsers();
        Iterator itr = users.iterator();
        while (itr.hasNext()) 
        {
            User user = (User)itr.next();
            String userId = user.getUserId();
            if(UserId.charAt(0) != userId.charAt(0))
            {
                itr.remove();    
            }
            
            
        }
        for (User tempuser: users)
            {
                model.addElement(tempuser);
            }
        
        theView.setAccountDeleteManualList(model);
    }
}
