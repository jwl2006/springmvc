package cmpe275.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wanghao on 3/22/16.
 */
@Controller
public class StudentProfileController {


    @Autowired private ProfileService profileSvc;

    @RequestMapping(value = "/profile", method= RequestMethod.GET)
    public ModelAndView getProfileTemplate() {

         ModelAndView model = new ModelAndView("View/ProfileTemplate");

         return model;
    }



    @RequestMapping(value="/profile", method = RequestMethod.POST)
    public ModelAndView submitAdmissionForm(@ModelAttribute("profile1") Profile profile1) {

         Profile pfound = profileSvc.get(profile1.getId() );

         if(pfound != null) {
             updateProfile(profile1, "true", null);
         } else {
             profileSvc.add(profile1);
         }

        ModelAndView model = new ModelAndView("View/FormWithDataByID");
        return model;
    }

    @RequestMapping(value="/updateProfle",method= RequestMethod.POST)
    public ModelAndView updateProfile(@ModelAttribute("profile1") Profile profile1,
                                      @RequestParam(required=false , value = "update") String updateFlag,
                                      @RequestParam(required=false, value="delete")String deleteFlag) {

        ModelAndView model = new ModelAndView("View/ProfileSuccess");

        if(updateFlag != null) {
            profileSvc.update(profile1);
            model.addObject("msg","The profile has been updated");
        } else if(deleteFlag != null) {
            Integer IdDelete = profile1.getId();
            profileSvc.delete(IdDelete);
            model.addObject("msg","The Profile has been deleted");
        }
        return model;
    }

    @RequestMapping(value="/profile/{id}",method= RequestMethod.GET)
    public ModelAndView getProfileById(@PathVariable("id") Integer id,
                                       @RequestParam(required=false , value = "brief") boolean briefFlag) {
        System.out.println("In get method!");
            Profile pfound = profileSvc.get(id);
            if (pfound != null) {
                if(briefFlag == true) {
                    ModelAndView model = new ModelAndView("View/ProfileSuccess");
                    model.addObject("profile1",pfound);
                    return model;
                } else {
                    ModelAndView model = new ModelAndView("View/FormWithDataByID");
                    model.addObject("profile1", pfound);
                    return model;
                }
            } else {
                ModelAndView model = new ModelAndView("View/404");
                model.addObject("msg", id);
                return model;
            }
    }


    @RequestMapping(value="/profile/{userId}", method= RequestMethod.POST)
    public ModelAndView postProfileById( @PathVariable("userId") Integer id,
                                         @ModelAttribute("profile1") Profile profile1) {

        System.out.println("In post method!");
     //   Integer id = profile1.getId();
        Profile pfound = profileSvc.get(id);
        if (pfound != null) {
            profileSvc.update(profile1);
        } else {
            profileSvc.add(profile1);
        }
        ModelAndView model = new ModelAndView("View/FormWithDataByID");
        model.addObject("profile1", profile1);
        return model;
    }





    @RequestMapping(value="/profile/{userId}", method= RequestMethod.DELETE)
    public void deleteProfile(@PathVariable("userId") Integer id) {
        System.out.println("in delete");

        Profile pfound = profileSvc.get(id);
        if (pfound != null) {
            profileSvc.delete(id);
        }
    }

}
