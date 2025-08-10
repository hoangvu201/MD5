package ra.edu.btvn03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.edu.btvn03.model.UserProfile;
import ra.edu.btvn03.service.UploadFileByCloudinary;

@Controller
@RequestMapping(value = {"/","/profile"})
    public class UserProfileController  {
    @Autowired
    private UploadFileByCloudinary uploadFileByCloudinary;

    @GetMapping
    public String initInsertProfile(Model model){
        UserProfile userProfile = new UserProfile();
        model.addAttribute("userProfile",userProfile);
        return "addProfile";
    }

    @PostMapping("/add-profile")
    public String addProfile(@ModelAttribute("userProfile")UserProfile userProfile, Model model){

        String avatar_url = uploadFileByCloudinary.uploadFileWithCloud(userProfile.getAvatar());

        model.addAttribute("name",userProfile.getName());
        model.addAttribute("avatarName",userProfile.getAvatar().getOriginalFilename());
        model.addAttribute("avatarUrl",avatar_url);
        return "profile";
    }

}
