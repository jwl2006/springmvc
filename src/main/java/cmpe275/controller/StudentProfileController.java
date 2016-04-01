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


    @RequestMapping(value="/profile/{id}",method= RequestMethod.GET)
    public ModelAndView getProfileById(@PathVariable("id") Integer id,
                                       @RequestParam(required=false , value = "brief") boolean briefFlag) {
            System.out.println("in get mehtod");
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
        System.out.println("in post");
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
