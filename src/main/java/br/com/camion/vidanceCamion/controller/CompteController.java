package br.com.camion.vidanceCamion.controller;


import br.com.camion.vidanceCamion.Repository.TouRepository;
import br.com.camion.vidanceCamion.Repository.geralRepository;
import br.com.camion.vidanceCamion.model.Compte;
import br.com.camion.vidanceCamion.model.Traveaux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CompteController {

    @Autowired
    private geralRepository gr;


    @GetMapping("/index")
    public ModelAndView sm() {
        ModelAndView mv = new ModelAndView("/index");
        return mv;
    }

    @GetMapping("/reponse")
    public ModelAndView rs() {
        ModelAndView mv = new ModelAndView("/reponse");
        return mv;
    }

    @GetMapping("/detail")
    public ModelAndView detail() {
        ModelAndView mv = new ModelAndView("/detail");
        return mv;
    }

    @GetMapping("/vidance")
    public ModelAndView dados(Compte compte) {
        ModelAndView mv = new ModelAndView("/vidance");
        return mv;
    }


    /**
     * vai gravar no banco de dados , vai formatta o data e multiplicar o preço com voyage
     *
     * @param compte
     * @param result
     * @param attributes
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/vidance", method = RequestMethod.POST)
    public ModelAndView salvar(@Valid Compte compte, BindingResult result, RedirectAttributes attributes) throws ParseException {

        ModelAndView mv = new ModelAndView("/vidance");
        if (compte.getVoyage() == 0 || result.hasErrors()) {
            attributes.addFlashAttribute(" la quantite de voyage ne peut pas etre 0 ");

            return mv;

        }
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(compte.getDatePrecis());
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = simpleDateFormat1.format(date);
        compte.setDatePrecis(dataFormatada);
//        compte.retornarValor();
        compte.getHj();
        compte.setPrix(compte.getVoyage() * 25000);
        gr.save(compte);
        ModelAndView mn = new ModelAndView("redirect:/reponse/" + compte.getId());
        attributes.addFlashAttribute("mensagem", "Vous etes enregistre avec sucesse et Nous vous Reviendrons a tres Bientot");
        return mn;
    }





    /**
     * quando voces enviar sua cadastro vai te dirigir para resposta
     * @param id informando o numero de matriculacao e se foi do vidance vai te mostrar o preço tambem
     * @return
     */
    @RequestMapping("/reponse/{id}")
    public ModelAndView listarReponse(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("/reponse");
        Compte comptes = gr.findById(id);
        mv.addObject("comptes", comptes);
        return mv;

    }

    /**
     * vai listar o que o cliente cadastro
     * @return
     */
    @RequestMapping("/listarVidance")
    public ModelAndView listarContas() {
        ModelAndView mv = new ModelAndView("/listar");

        Sort sort = Sort.by("hj").ascending();

        List<Compte> comptes = gr.findAll(sort);
        mv.addObject("comptes", comptes);
        System.out.println(comptes);
        long registro = gr.count();
        mv.addObject("registro", registro);
        return mv;

    }

    /**
     * vai deletar o cadastro do usuario com id do cadastro
     * @param id
     * @return
     */
    @RequestMapping("/deletarConta")
    public String deletarConta(Long id) {
        Compte compte = gr.findById(id);
        gr.delete(compte);
        return "redirect:/listarVidance";
    }


// part de codigo de segunda controller traveaux



    @Autowired
    private TouRepository Tr;

    /**
     * pegar o dados que tinha no classe traveaux
     * @param traveaux
     * @return
     */
    @GetMapping("/travail")
    public ModelAndView donne(Traveaux traveaux){
        ModelAndView tv = new ModelAndView("/travail");
        return tv;
    }


    /**
     * vai gravar no banco de dados , vai formatta o data
     * @param traveaux
     * @param result
     * @param attributes
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/travail", method = RequestMethod.POST)
    public ModelAndView Gravar(@Valid Traveaux traveaux, BindingResult result, RedirectAttributes attributes) throws ParseException {
        if (result.hasErrors()) {
            return donne(traveaux);
        } else {
            ModelAndView tv = new ModelAndView("redirect:/reponse");
            attributes.addFlashAttribute("mensagem", "Vous etes enregistre avec sucesse et Nous vous Reviendrons a tres Bientot");

            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Date date = simpleDateFormat.parse(traveaux.getDatePrecis());
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
            String dataFormatada = simpleDateFormat1.format(date);
            traveaux.setDatePrecis(dataFormatada);
            traveaux.getHj();
            traveaux.getPrix();
            Tr.save(traveaux);

            return tv;
        }
    }

    @RequestMapping("/listaTravail")
    public  ModelAndView listaTravail(){
        ModelAndView tv = new ModelAndView("/lista");
        Sort sort = Sort.by("hj").ascending();
        List<Traveaux> traveaus =  Tr.findAll(sort);
        tv.addObject("traveaus", traveaus);

        long registros = Tr.count();
        tv.addObject("registros" ,registros);

        return tv;

    }


    @RequestMapping("/deletardonne")
    public String deletardonne(Long id){
        Traveaux traveaux = Tr.findById(id);
        Tr.delete(traveaux);
        return "redirect:/listaTravail";
    }
}
