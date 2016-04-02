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

    //Get the profile creation form. Corresponding to (3)
    @RequestMapping(value = "/profile", method= RequestMethod.GET)
    public ModelAndView getProfileTemplate() {

         ModelAndView model = new ModelAndView("View/ProfileTemplate");

         return model;
    }

    //Get the user profile. If brief not specified, return (1), else return (2)
    @RequestMapping(value="/profile/{id}",method= RequestMethod.GET)
    public ModelAndView getProfileById(@PathVariable("id") Integer id,
                                       @RequestParam(required=false , value = "brief") boolean briefFlag) {

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

    //Post the profile to databse. Corresponding to (4)
    @RequestMapping(value="/profile/{userId}", method= RequestMethod.POST)
    public ModelAndView postProfileById( @PathVariable("userId") Integer id,
                                         @ModelAttribute("profile1") Profile profile1) {

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




    //Delete the profile, corresponding to (5)
    @RequestMapping(value="/profile/{userId}", method= RequestMethod.DELETE)
    public ModelAndView deleteProfile(@PathVariable("userId") Integer id) {
        Profile pfound = profileSvc.get(id);
        if (pfound != null) {
            profileSvc.delete(id);
            ModelAndView model = new ModelAndView("View/ProfileTemplate");
            return model;
        } else {
            ModelAndView model = new ModelAndView("View/404");
            model.addObject("msg",id);
            return model;
        }

    }

}
