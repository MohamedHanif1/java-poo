package com.example.simo.controllers;

import com.example.simo.entities.Patient;
import com.example.simo.services.HopitalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PatientController {
   /* @Autowired
    PatientRepository repository;

    @PostMapping("/patient")
    public Patient save(@RequestBody Patient patient){
        return  repository.save(patient);
    }

    @PutMapping("/patient")
    public Patient update(@RequestBody Patient patient){
        return  repository.save(patient);
    }
    @GetMapping("/patient/{id}")
    public Patient get(@PathVariable Long id){
        return  repository.findById(id).orElse(null);
    }
    @DeleteMapping("/patient/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

    */
    @Autowired
   HopitalService hopitalService;
    @RequestMapping("/createPatient")
 public  String createPatient(){
        return "CreatePatient";
    }
    @RequestMapping("/savePatient")
    public  String savePatient(
            @Valid Patient patient, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return "CreatePatient";
             Patient memo = hopitalService.savePatient(patient);
             return "CreatePatient";
    }
    @RequestMapping("/patientList")
    public String patientList(ModelMap modelMap,
                              @RequestParam(name = "page",defaultValue = "0") int page,
                              @RequestParam(name = "size",defaultValue = "1")int size)
    {
        Page<Patient> patientsController=hopitalService.getAlllPatientsByPage(page, size);
        modelMap.addAttribute("patientJsp",patientsController);
        modelMap.addAttribute("pages",new int[patientsController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "PatientList";

    }
    @RequestMapping("/deletePatient")
    public String deletePatient(@RequestParam("id") Long id,ModelMap modelMap,
                                @RequestParam(name = "page",defaultValue = "0") int page,
                                @RequestParam(name = "size",defaultValue = "1")int size)
    {
        hopitalService.deletePatientById(id);
        Page<Patient> patientsController=hopitalService.getAlllPatientsByPage(page, size);
        modelMap.addAttribute("patientJsp",patientsController);
        modelMap.addAttribute("pages",new int[patientsController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "PatientList";
    }
    @RequestMapping("/showPatient")
    public String showPatient(@RequestParam("id") Long id,ModelMap modelMap){
        Patient patientController = hopitalService.getPatient(id);
        modelMap.addAttribute("patientJsp",patientController);
        return "EditPatient";
    }
    @RequestMapping("/UpdatePatient")
    public  String updatePatient(@ModelAttribute ("patient") Patient patient)
            {
       Patient memo = hopitalService.savePatient(patient);
        return "CreatePatient";
    }
    @GetMapping("/")
    public  String home(){
        return "redirect:/patientList";
    }
    @GetMapping("/accessDenied")
    public  String accessDenied(){
        return "accessDenied";
    }
    @GetMapping("/login")
    public  String login(){
        return "login";
    }
    }



