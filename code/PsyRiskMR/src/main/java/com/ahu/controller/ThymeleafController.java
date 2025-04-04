package com.ahu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {

    @RequestMapping("/")
    public String getModel(){
        return "home.html";
    }

    @RequestMapping("/home")
    public String home(){
        return "home.html";
    }

    @RequestMapping("/help")
    public String help(){
        return "help.html";
    }

    @RequestMapping("/phenotype")
    public String phenotype(){
        return "phenotype.html";
    }
    @RequestMapping("/brain_imaging")
    public String brain_imaging(){
        return "brain_imaging.html";
    }
    @RequestMapping("/bulk")
    public String bulk(){
        return "bulk.html";
    }
    @RequestMapping("/cell")
    public String cell(){
        return "cell.html";
    }
    @RequestMapping("/search")
    public String search(){
        return "search.html";
    }

    // bulk相关的链接
    @RequestMapping("/Bulktissue_ADHD")
    public String Bulktissue_ADHD(){
        return "bulkTissue/Bulktissue_ADHD.html";
    }
    @RequestMapping("/Bulktissue_ALZ")
    public String Bulktissue_ALZ(){
        return "bulkTissue/Bulktissue_ALZ.html";
    }
    @RequestMapping("/Bulktissue_ANX")
    public String Bulktissue_ANX(){
        return "bulkTissue/Bulktissue_ANX.html";
    }
    @RequestMapping("/Bulktissue_ASD")
    public String Bulktissue_ASD(){
        return "bulkTissue/Bulktissue_ASD.html";
    }
    @RequestMapping("/Bulktissue_BP")
    public String Bulktissue_BP(){
        return "bulkTissue/Bulktissue_BP.html";
    }
    @RequestMapping("/Bulktissue_DEP")
    public String Bulktissue_DEP(){
        return "bulkTissue/Bulktissue_DEP.html";
    }
    @RequestMapping("/Bulktissue_ED")
    public String Bulktissue_ED(){
        return "bulkTissue/Bulktissue_ED.html";
    }
    @RequestMapping("/Bulktissue_OCD")
    public String Bulktissue_OCD(){
        return "bulkTissue/Bulktissue_OCD.html";
    }
    @RequestMapping("/Bulktissue_PTSD")
    public String Bulktissue_PTSD(){
        return "bulkTissue/Bulktissue_PTSD.html";
    }

    @RequestMapping("/Bulktissue_SCZ")
    public String Bulktissue_SCZ(){
        return "bulkTissue/Bulktissue_SCZ.html";
    }

    // cell相关的链接
    @RequestMapping("/Cellspecific_ADHD")
    public String Cellspecific_ADHD(){
        return "cellSpecific/Cellspecific_ADHD.html";
    }
    @RequestMapping("/Cellspecific_ALZ")
    public String Cellspecific_ALZ(){
        return "cellSpecific/Cellspecific_ALZ.html";
    }
    @RequestMapping("/Cellspecific_ANX")
    public String Cellspecific_ANX(){
        return "cellSpecific/Cellspecific_ANX.html";
    }
    @RequestMapping("/Cellspecific_ASD")
    public String Cellspecific_ASD(){
        return "cellSpecific/Cellspecific_ASD.html";
    }
    @RequestMapping("/Cellspecific_BP")
    public String Cellspecific_BP(){
        return "cellSpecific/Cellspecific_BP.html";
    }
    @RequestMapping("/Cellspecific_DEP")
    public String Cellspecific_DEP(){
        return "cellSpecific/Cellspecific_DEP.html";
    }
    @RequestMapping("/Cellspecific_ED")
    public String Cellspecific_ED(){
        return "cellSpecific/Cellspecific_ED.html";
    }
    @RequestMapping("/Cellspecific_OCD")
    public String Cellspecific_OCD(){
        return "cellSpecific/Cellspecific_OCD.html";
    }
    @RequestMapping("/Cellspecific_PTSD")
    public String Cellspecific_PTSD(){
        return "cellSpecific/Cellspecific_PTSD.html";
    }
    @RequestMapping("/Cellspecific_SCZ")
    public String Cellspecific_SCZ(){
        return "cellSpecific/Cellspecific_SCZ.html";
    }

    @RequestMapping("/test")
    public String test(){
        return "test.html";
    }

}
